package parkingLot.service.strategy.billCalculationStrategy;

import parkingLot.models.Ticket;

import java.time.LocalDateTime;

public interface IBillCalculationStrategy {
    double calculateBillAmount(Ticket ticket, LocalDateTime exitTime);
}
