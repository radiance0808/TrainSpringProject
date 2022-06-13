package edu.pja.mas.s19230.mas.repository;

import edu.pja.mas.s19230.mas.model.Machinist;
import edu.pja.mas.s19230.mas.model.Ticket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MachinistRepository extends CrudRepository<Machinist, Long> {

    @Query("from Machinist  as e where e.experienceYears < :experienceyears")
    List<Machinist> checkMachinist(@Param("experienceyears") int experienceyears);
}
