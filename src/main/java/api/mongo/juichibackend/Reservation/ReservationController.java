package api.mongo.juichibackend.Reservation;

import api.mongo.juichibackend.Exceptions.RequiredParamsNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Data
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/reservation")
@CrossOrigin("http://localhost:4200")
public class ReservationController {

    private ReservationService reservationService;

    @GetMapping("/get-all")
    public ResponseEntity<List<ReservationDTO>> getAllEntries(){
        log.info("Request received on 'get-all'");

        List<ReservationDTO> allEntries = this.reservationService.getAllEntries();

        log.info("List returned: " + allEntries);

        return ResponseEntity
                .ok()
                .body(allEntries);
    }

    @PostMapping("/add")
    public ResponseEntity<ReservationDTO> addReservation(@RequestBody ReservationEntry reservationEntry){
        log.info("Received reservation" + reservationEntry.toString());

        ReservationDTO reservationDTO = this.reservationService.addReservation(reservationEntry);

        log.info("Entered a reservation: " + reservationDTO);

//        Map<String, Object> mp = new HashMap<>();
//        mp.put("entry", reservationDTO);

//        log.info("Map returned: " + mp);

        return ResponseEntity.accepted().body(reservationDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Map<String, Object>> deleteReservation(@RequestBody Map<String, Object> map){
        String token, email;
        token = (String) map.get("token");
        email = (String) map.get("email");

        if(token == null || email == null){
            throw new RequiredParamsNotFoundException("Parameters required to perform action not found, `email` or 'token'");
        }
        log.info("Trying to delete reservation with token: " + token + " and email: " + email);

        ReservationDTO reservationDTO = this.reservationService.deleteReservation(token, email);

        Map<String, Object> mp = new HashMap<>();
        mp.put("message", "Reservation under 'reservation' key deleted successfully");
        mp.put("reservation", reservationDTO);

        log.info("Returning object: " + mp);
        return ResponseEntity.accepted().body(mp);
    }

    @GetMapping("/reserved-seats")
    public ResponseEntity<List<String>> getReservedSeatsOnDayAndTime(@RequestParam String date, @RequestParam String time){

        if(time == null || date == null){
            throw new RequiredParamsNotFoundException("Parameters required to perform wished action not found, `date` (in YYYY-MM-DD) `time`");
        }

        log.info("Trying to get reserved seats on Date: " + date + " and Time: " + time);

        List<String> seatings = this.reservationService.getReservedSeatsListOnDayAndTime(date, time);

        log.info("Returning reserved list: " + seatings);

        return ResponseEntity.ok(seatings);
    }

    @GetMapping("/get-by-date")
    public ResponseEntity<List<ReservationDTO>> getReservationByDate(@RequestParam String date){
        if(date == null){
            throw new RequiredParamsNotFoundException("Parameters required to perform wished action not found");
        }

        log.info("Trying to get reservations on Date: " + date);

        List<ReservationDTO> entries = this.reservationService.getReservationOnDate(date);

        return ResponseEntity.ok(entries);
    }
}
