package api.mongo.juichibackend.Reservation;

import api.mongo.juichibackend.Exceptions.DateFormatException;
import api.mongo.juichibackend.Exceptions.GenericRuntimeException;
import api.mongo.juichibackend.Exceptions.ReservationNotAvailableException;
import api.mongo.juichibackend.Exceptions.SeatNotReservableException;
import api.mongo.juichibackend.Utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Service
@Data
@AllArgsConstructor
@Slf4j
public class ReservationService {

    private ReservationDAO reservationDAO;

    private final Integer TOKEN_LENGTH_RESERVATION = 20;

    public List<ReservationDTO> getAllEntries() {

        return this.reservationDAO.findAll()
                .stream()
                .map(ReservationDTO::new)
                .toList();
    }

    public ReservationDTO addReservation(ReservationEntry entry){
        if(!checkIfFieldsOfEntryProperlySet(entry)){
            throw new GenericRuntimeException("One of the following required fields of the Reservation not set: \n Last Name, \n Email, \n Date, \n Time");
        }
        if(!checkIfSeatAvailable(entry)){
            throw new SeatNotReservableException("The chosen seat(s) is/are not reservable, as it's already reserved for someone else");
        }
        entry.setToken(Utils.generateRandomString(TOKEN_LENGTH_RESERVATION).toUpperCase(Locale.ROOT));
        entry.setCreatedOn(LocalDateTime.now());
        ReservationEntry savedEntry = this.reservationDAO.save(entry);
        return new ReservationDTO(savedEntry);
    }

    public ReservationDTO deleteReservation(String token, String email){

        if(!checkIfReservationAvailable(token, email)){
            throw new ReservationNotAvailableException("Couldn't find reservation under given email and token");
        }
        ReservationEntry reservationEntry = this.reservationDAO.deleteByTokenEqualsAndEmailEquals(token, email);
        log.debug("Deleted entry: TOKEN:" + reservationEntry.getToken() + " EMAIL: " + reservationEntry.getEmail());
        return new ReservationDTO(reservationEntry);
    }

    public List<String> getReservedSeatsListOnDayAndTime(String localDate, String time){
        LocalDate date = getLocalDate(localDate);
        ReservationEntry rv = new ReservationEntry();
        rv.setDate(date);
        rv.setTime(time);

        List<String[]> seatings = this.reservationDAO.findByDateAndTime(date, time)
                .stream()
                .map(ReservationEntry::getSeat)
                .toList();

        List<String> seatingsList = new LinkedList<>();
        for(String[] stringArray: seatings){
            seatingsList.addAll(Arrays.asList(stringArray));
        }

        return seatingsList;

    }


    private boolean checkIfReservationAvailable(String token, String email) {
        return this.reservationDAO.existsByTokenEqualsAndEmailEquals(token, email);
    }

    private boolean checkIfFieldsOfEntryProperlySet(ReservationEntry entry){
        if( entry.getEmail() == null ||
                entry.getDate() == null ||
                entry.getTime() == null ||
                entry.getLastName() == null
        ) return false;
        return true;
    }

    private boolean checkIfSeatAvailable(ReservationEntry entry) {
        List<String> seatings = this.getReservedSeatsListOnDayAndTime(entry.getDate().toString(), entry.getTime());
        if(seatings.size() == 0) return true;
        if(entry.getSeat().length == 0) return true;
        for(String list: seatings){
            for(String st: entry.getSeat()){
                if(st.equals(list)){
                    return false;
                }
            }
        }
        return true;
    }

    public List<ReservationDTO> getReservationOnDate(String localDate) {
        LocalDate date = getLocalDate(localDate);
        List<ReservationDTO> entries = this.reservationDAO.findByDate(date)
                .stream()
                .map(ReservationDTO::new)
                .toList();
        return entries;
    }

    private LocalDate getLocalDate(String localDate) {
        LocalDate date;
        try{
            date = LocalDate.parse(localDate);
        } catch (DateTimeException e){
            throw new DateFormatException("Date format should be YYYY-MM-DD");
        }
        return date;
    }
}
