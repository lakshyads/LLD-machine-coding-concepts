package parkingLot;

import org.jetbrains.annotations.NotNull;
import parkingLot.controller.TicketController;
import parkingLot.dto.TicketRequestDTO;
import parkingLot.dto.TicketResponseDTO;
import parkingLot.exception.GateNotFoundException;
import parkingLot.exception.NoEmptyParkingSlotAvailableException;
import parkingLot.exception.ParkingLotNotFoundException;
import parkingLot.models.constants.VehicleType;
import parkingLot.repository.*;
import parkingLot.service.strategy.IInitService;
import parkingLot.service.strategy.InitServiceImpl;
import parkingLot.service.strategy.TicketService;
import parkingLot.service.strategy.TicketServiceImpl;

public class ParkingLotMain {
    public static void main(String[] args) throws NoEmptyParkingSlotAvailableException, ParkingLotNotFoundException, GateNotFoundException {
        TicketService ticketService = getTicketService();
        TicketController ticketController = new TicketController(ticketService);


        TicketRequestDTO ticketRequestDTO = new TicketRequestDTO(
                "UP14BD9903",
                "Bajaj Avenger 220",
                "Black",
                VehicleType.CAR,
                1,
                31);
        TicketResponseDTO ticketResponseDTO = ticketController.getTicket(ticketRequestDTO);
        System.out.println(ticketResponseDTO);
    }

    @NotNull
    private static TicketService getTicketService() {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingSlotRepository parkingSlotRepository = new ParkingSlotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        IInitService initService = new InitServiceImpl(parkingLotRepository, parkingFloorRepository, parkingSlotRepository, gateRepository);
        initService.init();

        return new TicketServiceImpl(parkingLotRepository, gateRepository, ticketRepository);
    }
}
