package api.mongo.juichibackend.Exceptions;

public class RequiredParamsNotFoundException extends RuntimeException{
    public RequiredParamsNotFoundException(String message) {
        super(message);
    }

    public RequiredParamsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
