package api.mongo.juichibackend.Feedback;

import api.mongo.juichibackend.Exceptions.GenericRuntimeException;
import api.mongo.juichibackend.Exceptions.ReservationNotAvailableException;
import api.mongo.juichibackend.Reservation.ReservationDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackService {
    private final FeedbackDAO feedbackDAO;
    private final ReservationDAO reservationDAO;

    public List<Feedback> getAllFeedback() {
        return this.feedbackDAO.findAll();
    }

    public Feedback add(Feedback feedback) {
        if(!this.reservationDAO.existsByToken(feedback.getToken())){
            throw new ReservationNotAvailableException("Valid reservation token required in order to post a feedback");
        }
        if(feedback.getFeedback() == null && feedback.getRating() == null){
            throw new GenericRuntimeException("Unuseful Feedback: Feedback must have either rating or opinions");
        }

        return this.feedbackDAO.save(feedback);
    }
}
