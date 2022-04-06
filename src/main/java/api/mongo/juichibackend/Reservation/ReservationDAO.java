package api.mongo.juichibackend.Reservation;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO extends MongoRepository<ReservationEntry, String> {

    ReservationEntry deleteByTokenEqualsAndEmailEquals(String token, String email);

    boolean existsByTokenEqualsAndEmailEquals(String token, String email);

    List<ReservationEntry> findByDateAndTime(LocalDate date, String time);

    boolean existsByToken(String token);

    List<ReservationEntry> findByDate(LocalDate date);
}
