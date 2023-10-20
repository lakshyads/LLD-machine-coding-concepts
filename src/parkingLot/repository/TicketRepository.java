package parkingLot.repository;

import org.jetbrains.annotations.NotNull;
import parkingLot.exception.TicketNotFoundException;
import parkingLot.models.Ticket;

import java.util.HashMap;

public class TicketRepository {
    private final HashMap<Integer, Ticket> ticketMap;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketId) throws TicketNotFoundException {
        Ticket ticket = ticketMap.get(ticketId);
        if (ticket == null) throw new TicketNotFoundException("Ticket not found for id: " + ticketId);
        return ticket;
    }

    public Ticket put(@NotNull Ticket ticket) {
        ticketMap.put(ticket.getId(), ticket);
        return ticket;
    }
}
