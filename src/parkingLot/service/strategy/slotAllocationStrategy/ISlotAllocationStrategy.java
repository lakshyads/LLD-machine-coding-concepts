package parkingLot.service.strategy.slotAllocationStrategy;

import parkingLot.models.Gate;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSlot;
import parkingLot.models.constants.VehicleType;

public interface ISlotAllocationStrategy {
    ParkingSlot findParkingSlot(VehicleType vehicleType, ParkingLot parkingLot, Gate entryGate);
}
