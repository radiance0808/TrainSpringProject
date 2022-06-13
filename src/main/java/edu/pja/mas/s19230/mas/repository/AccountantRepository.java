package edu.pja.mas.s19230.mas.repository;

import edu.pja.mas.s19230.mas.model.Accountant;
import edu.pja.mas.s19230.mas.model.Ticket;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountantRepository extends CrudRepository<Accountant, Long> {

    @Query("from Accountant  as e where e.soldTickets > :soldtickets")
    List<Accountant> findAccountantBySoldTicketsGreaterThan(@Param("soldtickets") int soldtickets);
}
