package parkingLot.repository;

import org.jetbrains.annotations.NotNull;
import parkingLot.exception.ParkingSlotNotFoundException;
import parkingLot.models.ParkingSlot;

import java.util.HashMap;

public class ParkingSlotRepository {
    private final HashMap<Integer, ParkingSlot> parkingSlotMap;

    public ParkingSlotRepository() {
        this.parkingSlotMap = new HashMap<>();
    }

    public ParkingSlot get(int parkingSlotId) throws ParkingSlotNotFoundException {
        ParkingSlot parkingSlot = parkingSlotMap.get(parkingSlotId);
        if (parkingSlot == null)
            throw new ParkingSlotNotFoundException("ParkingSlot not found for id: " + parkingSlotId);
        return parkingSlot;
    }

    public ParkingSlot put(@NotNull ParkingSlot parkingSlot) {
        parkingSlotMap.put(parkingSlot.getId(), parkingSlot);
        return parkingSlot;
    }
}
