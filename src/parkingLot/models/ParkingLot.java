package parkingLot.models;

import parkingLot.models.constants.Status;
import parkingLot.models.constants.VehicleType;
import parkingLot.service.strategy.billCalculationStrategy.IBillCalculationStrategy;
import parkingLot.service.strategy.slotAllocationStrategy.ISlotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<VehicleType> supportedVehicleTypes;
    private Status parkingLotStatus;
    private ISlotAllocationStrategy slotAllocationStrategy;
    private IBillCalculationStrategy billCalculationStrategy;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public Status getParkingLotStatus() {
        return parkingLotStatus;
    }

    public ISlotAllocationStrategy getSlotAllocationStrategy() {
        return slotAllocationStrategy;
    }

    public IBillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }
}
