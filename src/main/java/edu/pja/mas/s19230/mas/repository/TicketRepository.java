package edu.pja.mas.s19230.mas.repository;

import edu.pja.mas.s19230.mas.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Long> {


    @Query("from Ticket  as e where e.soldTickets.id = :passengerrouteId")
    List<Ticket> findTicketsByPassengerRouteId(@Param("passengerrouteId") long passengerrouteId);

    @Query(value = "insert into Ticket (id, ticketNumber, cost, passenger_id, passsengerroute_id) values :id, :ticketnumber, :cost, :passengerid, :passengerrouteId", nativeQuery = true)
    void createTicket(@Param("id") Long id, @Param("cost") double cost, @Param("ticketnumber") String ticketnumber, @Param("passengerid") long passengerid, @Param("passengerrouteId") long passengerrouteId);

    @Query("DELETE from Ticket e where e.ticketNumber = :ticketnumber and e.soldTickets.departureDate <= :currentdate")
    void removeTicketByTicketNumber(@Param("ticketnumber") String ticketnumber, @Param("currentdate") LocalDate currentdate);
}
