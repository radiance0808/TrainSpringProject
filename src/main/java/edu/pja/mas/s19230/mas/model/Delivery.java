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
public class Delivery extends  Route{

    @Min(0)
    private int pricePerGood;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Good> goods;

    @OneToMany(mappedBy = "hasDelivery", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<CargoTrainDelivery> cargoTrainDeliveries = new HashSet<>();
}
