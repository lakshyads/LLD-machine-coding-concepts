package parkingLot.repository;

import org.jetbrains.annotations.NotNull;
import parkingLot.models.Payment;
import ticTacToe.exception.PaymentNotFoundException;

import java.util.HashMap;

public class PaymentRepository {
    private final HashMap<Integer, Payment> paymentMap;

    public PaymentRepository() {
        this.paymentMap = new HashMap<>();
    }

    public Payment get(int paymentId) throws PaymentNotFoundException {
        Payment payment = paymentMap.get(paymentId);
        if (payment == null) throw new PaymentNotFoundException("Payment not found for id: " + paymentId);
        return payment;
    }

    public Payment put(@NotNull Payment payment) {
        paymentMap.put(payment.getId(), payment);
        return payment;
    }
}
