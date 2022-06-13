package edu.pja.mas.s19230.mas.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CargoTrainDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    @NotNull
    private Delivery hasDelivery;

    @ManyToOne
    @JoinColumn(name = "cargotrain_id", nullable = false)
    @NotNull
    private CargoTrain cargoTrainDelivers;
}
