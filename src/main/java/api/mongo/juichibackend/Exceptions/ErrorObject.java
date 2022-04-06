package api.mongo.juichibackend.Exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorObject {

    private String message;
    @JsonIgnore
    private Throwable throwable;
    private HttpStatus httpStatus;
    private LocalDateTime timestamp;

    public ErrorObject(Throwable e, HttpStatus code){
        this.message = e.getMessage();
        this.throwable = e;
        this.httpStatus = code;
        this.timestamp = LocalDateTime.now();
    }


}
