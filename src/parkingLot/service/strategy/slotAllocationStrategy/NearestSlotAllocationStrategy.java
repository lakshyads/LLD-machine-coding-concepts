package parkingLot.service.strategy.slotAllocationStrategy;

import org.jetbrains.annotations.NotNull;
import parkingLot.exception.NoEmptyParkingSlotAvailableException;
import parkingLot.models.Gate;
import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSlot;
import parkingLot.models.constants.ParkingSlotStatus;
import parkingLot.models.constants.VehicleType;

public class NearestSlotAllocationStrategy implements ISlotAllocationStrategy {
    @Override
    public ParkingSlot findParkingSlot(
            VehicleType vehicleType,
            @NotNull ParkingLot parkingLot,
            @NotNull Gate entryGate
    ) throws NoEmptyParkingSlotAvailableException {
        int currentFloor = entryGate.getFloorNumber();
        ParkingSlot slot = null;
        // find empty slot in current floor
        slot = findEmptySlotInCurrentFloor(parkingLot.getParkingFloors().get(currentFloor), vehicleType);
        if (slot != null) return slot;
        // find empty slot in next nearest floor - up or down
        int i = currentFloor - 1;
        int j = currentFloor + 1;
        while (i >= 0 || j < parkingLot.getParkingFloors().size()) {
            if (i >= 0) {
                slot = findEmptySlotInCurrentFloor(parkingLot.getParkingFloors().get(i), vehicleType);
                if (slot != null) return slot;
            }
            if (j < parkingLot.getParkingFloors().size()) {
                slot = findEmptySlotInCurrentFloor(parkingLot.getParkingFloors().get(j), vehicleType);
                if (slot != null) return slot;
            }
            i--;
            j++;
        }
        throw new NoEmptyParkingSlotAvailableException("No empty parking slot available");
    }

    private ParkingSlot findEmptySlotInCurrentFloor(ParkingFloor parkingFloor, VehicleType vehicleType) {
        for (ParkingSlot slot : parkingFloor.getParkingSlots()) {
            if (slot.getSupportedVehicleType().equals(vehicleType)
                    && slot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY)
            )
                return slot;
        }
        return null;
    }
}
