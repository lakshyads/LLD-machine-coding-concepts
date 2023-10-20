package parkingLot.repository;

import org.jetbrains.annotations.NotNull;
import parkingLot.models.Vehicle;
import ticTacToe.exception.VehicleNotFoundException;

import java.util.HashMap;

public class VehicleRepository {
    private final HashMap<Integer, Vehicle> vehicleMap;

    public VehicleRepository() {
        this.vehicleMap = new HashMap<>();
    }

    public Vehicle get(int vehicleId) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleMap.get(vehicleId);
        if (vehicle == null) throw new VehicleNotFoundException("Vehicle not found for id: " + vehicleId);
        return vehicle;
    }

    public Vehicle put(@NotNull Vehicle vehicle) {
        vehicleMap.put(vehicle.getId(), vehicle);
        return vehicle;
    }
}
