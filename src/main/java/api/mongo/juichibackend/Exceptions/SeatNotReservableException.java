package api.mongo.juichibackend.Exceptions;

public class SeatNotReservableException extends RuntimeException {

    public SeatNotReservableException(String message) {
        super(message);
    }

    public SeatNotReservableException(String message, Throwable cause) {
        super(message, cause);
    }
}
