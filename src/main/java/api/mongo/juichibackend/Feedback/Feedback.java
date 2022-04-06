package api.mongo.juichibackend.Feedback;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    @Id
    @JsonIgnore
    private String id;
    private FBSubject subject;
    private Integer rating;
    private String feedback;
    private String token;
}
