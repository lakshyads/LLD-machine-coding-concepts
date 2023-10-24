package parkingLot.dto;

import parkingLot.models.constants.VehicleType;

public class TicketRequestDTO {
    private final String vehicleNumber;
    private final String vehicleName;
    private final String vehicleColor;
    private final VehicleType vehicleType;

    private final int parkingLotId;
    private final int entryGateId;

    public TicketRequestDTO(String vehicleNumber, String vehicleName, String vehicleColor, VehicleType vehicleType, int parkingLotId, int entryGateId) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.vehicleType = vehicleType;
        this.parkingLotId = parkingLotId;
        this.entryGateId = entryGateId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public int getEntryGateId() {
        return entryGateId;
    }
}
