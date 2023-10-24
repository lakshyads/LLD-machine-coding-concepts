package parkingLot.dto;

import java.time.LocalDateTime;

public class TicketResponseDTO {
    private final int ticketId;
    private final int parkingSlotNumber;
    private final String vehicleNumber;

    private final LocalDateTime entryTime;

    public TicketResponseDTO(
            int ticketId,
            int parkingSlotNumber,
            String vehicleNumber,
            LocalDateTime entryTime) {
        this.ticketId = ticketId;
        this.parkingSlotNumber = parkingSlotNumber;
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getParkingSlotId() {
        return parkingSlotNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "TicketResponseDTO{" +
                "ticketId=" + ticketId +
                ", parkingSlotNumber=" + parkingSlotNumber +
                ", vehicleNumber=" + vehicleNumber +
                ", entryTime=" + entryTime +
                '}';
    }
}
