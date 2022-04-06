package api.mongo.juichibackend.Reservation;


import api.mongo.juichibackend.Order.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class ReservationEntry {

    @Id
    private String id;
    private String token;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String noOfGuests;
    private LocalDate date;
    private String time;
    private String[] seat;
    private String specialRequests;
    private List<Order> preOrders;
    private LocalDateTime createdOn;

}
