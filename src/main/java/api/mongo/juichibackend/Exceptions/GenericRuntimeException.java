package api.mongo.juichibackend.Exceptions;

public class GenericRuntimeException extends RuntimeException {

    public GenericRuntimeException(String s) {
        super(s);
    }
    public GenericRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
