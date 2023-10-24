package parkingLot.controller;

import parkingLot.dto.TicketRequestDTO;
import parkingLot.dto.TicketResponseDTO;
import parkingLot.exception.GateNotFoundException;
import parkingLot.exception.NoEmptyParkingSlotAvailableException;
import parkingLot.exception.ParkingLotNotFoundException;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;
import parkingLot.service.strategy.TicketService;

import java.time.LocalDateTime;

public class TicketController {
    TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketResponseDTO getTicket(TicketRequestDTO ticketRequestDTO) throws NoEmptyParkingSlotAvailableException, ParkingLotNotFoundException, GateNotFoundException {
        Vehicle vehicle = new Vehicle(
                ticketRequestDTO.getVehicleNumber(),
                ticketRequestDTO.getVehicleName(),
                ticketRequestDTO.getVehicleColor(),
                ticketRequestDTO.getVehicleType()
        );
        Ticket ticket = ticketService.createTicket(
                vehicle,
                ticketRequestDTO.getEntryGateId(),
                ticketRequestDTO.getParkingLotId(), LocalDateTime.now());

        return new TicketResponseDTO(
                ticket.getId(),
                ticket.getParkingSlot().getSlotNumber(),
                ticket.getVehicle().getNumber(), ticket.getEntryTime());
    }
}
