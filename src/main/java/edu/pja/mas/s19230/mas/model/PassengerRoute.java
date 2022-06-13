package edu.pja.mas.s19230.mas.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class PassengerRoute extends Route{

    @Min(0)
    private int ticketPrice;

    @OneToMany(mappedBy = "soldTickets", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Ticket> tickets = new HashSet<>();

    @OneToMany(mappedBy = "hasPassengerRoute", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PassengerTrainRoute> passengerTrainRoutes = new HashSet<>();
}
