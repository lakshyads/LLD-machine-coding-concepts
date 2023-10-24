package parkingLot.models;

import parkingLot.models.constants.TicketStatus;

import java.time.LocalDateTime;

public class Ticket extends BaseModel {
    private static int id = 0;
    private LocalDateTime entryTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private Gate entryGate;
    private TicketStatus ticketStatus;

    public Ticket(Vehicle vehicle, ParkingSlot parkingSlot, Gate entryGate) {
        super(++id);
        this.entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryGate = entryGate;
        this.ticketStatus = TicketStatus.ACTIVE;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
