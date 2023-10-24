package parkingLot.service.strategy;

import parkingLot.exception.GateNotFoundException;
import parkingLot.exception.NoEmptyParkingSlotAvailableException;
import parkingLot.exception.ParkingLotNotFoundException;
import parkingLot.models.*;
import parkingLot.repository.GateRepository;
import parkingLot.repository.ParkingLotRepository;
import parkingLot.repository.TicketRepository;

import java.time.LocalDateTime;

public class TicketServiceImpl implements TicketService {
    ParkingLotRepository parkingLotRepository;
    GateRepository gateRepository;
    TicketRepository ticketRepository;

    public TicketServiceImpl(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket createTicket(Vehicle vehicle, int entryGateId, int parkingLotId, LocalDateTime entryTime)
            throws ParkingLotNotFoundException,
            GateNotFoundException,
            NoEmptyParkingSlotAvailableException {
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);
        Gate entryGate = gateRepository.get(entryGateId);
        ParkingSlot allottedSlot = parkingLot.getSlotAllocationStrategy().findParkingSlot(vehicle.getVehicleType(), parkingLot, entryGate);
        Ticket ticket = new Ticket(vehicle, allottedSlot, entryGate);
        ticketRepository.put(ticket);
        return ticket;
    }
}
