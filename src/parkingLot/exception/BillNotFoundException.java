package parkingLot.exception;

public class BillNotFoundException extends Exception {
    public BillNotFoundException() {
    }

    public BillNotFoundException(String message) {
        super(message);
    }
}
