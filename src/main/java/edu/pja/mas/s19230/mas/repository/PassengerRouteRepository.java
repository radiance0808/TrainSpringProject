package edu.pja.mas.s19230.mas.repository;

import edu.pja.mas.s19230.mas.model.PassengerRoute;
import edu.pja.mas.s19230.mas.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PassengerRouteRepository extends CrudRepository<PassengerRoute, Long> {

    @Query("from Route as e where e.departureDate = :departdate and e.arrivalDate = :arrivdate AND e.departureFrom = :departfrom and  e.arrivalTo = :arrivto")
    List<PassengerRoute> findPassengerRouteByDepartureDateAndAndArrivalDateAndAndDepartureFromAndAndArrivalTo(@Param("departdate") LocalDate departdate, @Param("arrivdate") LocalDate arrivdate,
                                                                                                              @Param("departfrom") String departfrom, @Param("arrivto") String arrivto);
}
