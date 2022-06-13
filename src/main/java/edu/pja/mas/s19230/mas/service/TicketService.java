package edu.pja.mas.s19230.mas.service;

import edu.pja.mas.s19230.mas.model.PassengerRoute;
import edu.pja.mas.s19230.mas.model.Route;
import edu.pja.mas.s19230.mas.model.Ticket;
import edu.pja.mas.s19230.mas.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public List<Ticket> getTicketsByRouteId(long routeId) {
        return ticketRepository.findTicketsByPassengerRouteId(routeId);
    }

    public List<Ticket> getAllTickets() {
        Iterable<Ticket> all = ticketRepository.findAll();
        List<Ticket> res = new ArrayList<>();
        all.forEach(res :: add);
        return res;
    }
}
