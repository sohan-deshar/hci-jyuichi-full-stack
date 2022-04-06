package api.mongo.juichibackend.Feedback;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FeedbackDAO extends MongoRepository<Feedback, String> {
}
