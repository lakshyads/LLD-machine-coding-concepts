package parkingLot.models;

import parkingLot.models.constants.ParkingSlotStatus;
import parkingLot.models.constants.VehicleType;

public class ParkingSlot extends BaseModel {
    private int slotNumber;
    private VehicleType supportedVehicleType;
    private Vehicle vehicle;
    private ParkingSlotStatus parkingSlotStatus;

    public ParkingSlot(int id) {
        super(id);
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public void setSupportedVehicleType(VehicleType supportedVehicleType) {
        this.supportedVehicleType = supportedVehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSlotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }
}
