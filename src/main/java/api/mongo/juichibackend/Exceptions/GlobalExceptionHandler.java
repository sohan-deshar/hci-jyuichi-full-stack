package api.mongo.juichibackend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ReservationNotAvailableException.class, GenericRuntimeException.class})
    public ResponseEntity<ErrorObject> handleExceptionWithBAD_REQUESTStatus(
            RuntimeException e
    ){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ErrorObject errorObject = new ErrorObject(
                e,
                badRequest
        );
        return new ResponseEntity<>(errorObject, badRequest);
    }

    @ExceptionHandler(value = {SeatNotReservableException.class})
    public ResponseEntity<ErrorObject> handleSeatNotReservableException(
            SeatNotReservableException e
    ){
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        ErrorObject errorObject = new ErrorObject(
                e,
                status
        );
        return new ResponseEntity<>(errorObject, status);
    }

    @ExceptionHandler(value = {MenuNameAlreadyTakenException.class})
    public ResponseEntity<ErrorObject> handleExceptionWithNOT_ACCEPTABLEstatus(
        RuntimeException e
    ){
        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        ErrorObject errorObject = new ErrorObject(
                e,
                status
        );
        return new ResponseEntity<>(errorObject, status);
    }

    @ExceptionHandler(value = {DateFormatException.class, RequiredParamsNotFoundException.class})
    public ResponseEntity<ErrorObject> handleExceptionWithEXPECTATION_FAILEDstatus(
            RuntimeException e
    ){
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        ErrorObject errorObject = new ErrorObject(
                e,
                status
        );
        return new ResponseEntity<>(errorObject, status);
    }
}
