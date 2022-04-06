package api.mongo.juichibackend.Exceptions;

public class ReservationNotAvailableException extends RuntimeException {

    public ReservationNotAvailableException(String message) {
        super(message);
    }

    public ReservationNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }
}
