package api.mongo.juichibackend;

import api.mongo.juichibackend.Reservation.ReservationDAO;
import api.mongo.juichibackend.Reservation.ReservationEntry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class JuichiBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuichiBackendApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(
//            ReservationDAO repo
//    ){
//        return args -> {
//            ReservationEntry res = new ReservationEntry();
//            res.setDate(LocalDate.now());
//            res.setTime("Sometime");
//            res.setFirstName("Sohan");
//            res.setLastName("Deshar");
//            res.setEmail("sohan@deshar.com");
//            res.setCreatedOn(LocalDateTime.now());
//            res.setToken("some token");
//            res.setNoOfGuests(String.valueOf(5));
//            res.setSpecialRequests("I want nothingjo");
//            repo.save(res);
//        };
//    }
}
