package api.mongo.juichibackend.Exceptions;

public class DateFormatException extends RuntimeException{
    public DateFormatException(String message) {
        super(message);
    }

    public DateFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
