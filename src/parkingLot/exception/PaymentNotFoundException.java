package parkingLot.exception;

public class PaymentNotFoundException extends Exception {
    public PaymentNotFoundException() {
    }

    public PaymentNotFoundException(String message) {
        super(message);
    }
}
