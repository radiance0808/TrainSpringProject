package edu.pja.mas.s19230.mas.repository;

import edu.pja.mas.s19230.mas.model.Route;
import edu.pja.mas.s19230.mas.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RouteRepository extends CrudRepository<Route, Long> {

    @Query("delete from Route e where e.id = :Id")
    void removeRouteById(@Param("Id") long Id);
}
