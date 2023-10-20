package parkingLot.models;

import parkingLot.models.constants.Status;
import parkingLot.models.constants.VehicleType;
import parkingLot.service.strategy.billCalculationStrategy.IBillCalculationStrategy;
import parkingLot.service.strategy.slotAllocationStrategy.ISlotAllocationStrategy;

import java.util.List;

public class ParkingLot {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<VehicleType> supportedVehicleTypes;
    private Status parkingLotStatus;
    private ISlotAllocationStrategy slotAllocationStrategy;
    private IBillCalculationStrategy billCalculationStrategy;

}
