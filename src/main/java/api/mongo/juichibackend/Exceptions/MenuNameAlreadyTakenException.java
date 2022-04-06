package api.mongo.juichibackend.Exceptions;

public class MenuNameAlreadyTakenException extends RuntimeException {
    public MenuNameAlreadyTakenException(String message, Throwable cause) {
        super(message, cause);
    }

    public MenuNameAlreadyTakenException(String s) {
        super(s);
    }
}
