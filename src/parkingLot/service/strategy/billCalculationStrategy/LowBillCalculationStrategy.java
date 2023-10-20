package parkingLot.service.strategy.billCalculationStrategy;

import org.jetbrains.annotations.NotNull;
import parkingLot.models.Ticket;
import parkingLot.models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowBillCalculationStrategy implements IBillCalculationStrategy {
    private static final int PER_HOUR_CHARGE_2_WHEELER = 50;
    private static final int PER_HOUR_CHARGE_4_WHEELER = 100;
    private static final double INCREMENT_FACTOR = 0.1;

    @Override
    public double calculateBillAmount(@NotNull Ticket ticket, LocalDateTime exitTime) {
        LocalDateTime entryTime = ticket.getEntryTime();
        long totalHours = ChronoUnit.HOURS.between(entryTime, exitTime);
        // TODO: write a separate method to calculate fixedCost based on vehicle type
        int fixedCost = ticket.getVehicle().getVehicleType().equals(VehicleType.BIKE) ?
                PER_HOUR_CHARGE_2_WHEELER
                : PER_HOUR_CHARGE_4_WHEELER;
        double baseCost = fixedCost * totalHours;
        return baseCost + baseCost * (INCREMENT_FACTOR * (totalHours - 1));
    }
}

/*
    1st hour -> 50
    2nd hour -> 50*2 => 100 + 100 * (0.1 * 2-1) => 100 + 10 => 110
    3rd hour -> 50*2 => 150 + 100 * (0.1 * 3-1) => 150 + 30 => 180
    ...
    formula:
     baseCost = fixed cost * N
     totalCost => baseCost + baseCost * (incrementFactor * (N-1))
 */
