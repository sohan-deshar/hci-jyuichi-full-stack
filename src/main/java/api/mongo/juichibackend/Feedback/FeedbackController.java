package api.mongo.juichibackend.Feedback;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping("/get-all")
    public ResponseEntity<List<Feedback>> getAllFeedback(){
        List<Feedback> allFeedback = this.feedbackService.getAllFeedback();
        return ResponseEntity.ok(allFeedback);
    }

    @PostMapping("/add")
    public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback){
        Feedback fb = this.feedbackService.add(feedback);
        return ResponseEntity.ok(fb);
    }
}
