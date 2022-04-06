package api.mongo.juichibackend.Reservation;

import api.mongo.juichibackend.Order.Order;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ReservationDTO {
    private String lastName;
    private String email;
    private String phone;
    private String noOfGuests;
    private LocalDate date;
    private String token;
    private String time;
    private String[] seat;
    private String specialRequests;
    private List<Order> preOrders;
    private LocalDateTime createdOn;

    public ReservationDTO(ReservationEntry reservation){

        this.lastName = reservation.getLastName();
        this.email = reservation.getEmail();
        this.phone = reservation.getPhone();
        this.noOfGuests = reservation.getNoOfGuests();
        this.date = reservation.getDate();
        this.time = reservation.getTime();
        this.seat = reservation.getSeat();
        this.preOrders = reservation.getPreOrders();
        this.specialRequests = reservation.getSpecialRequests();
        this.token = reservation.getToken();
        this.createdOn = reservation.getCreatedOn();
    }
}
