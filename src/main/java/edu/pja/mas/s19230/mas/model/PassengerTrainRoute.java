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
public class PassengerTrainRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passengerroute_id", nullable = false)
    @NotNull
    private PassengerRoute hasPassengerRoute;

    @ManyToOne
    @JoinColumn(name = "passengertrain_id", nullable = false)
    @NotNull
    private PassengerTrain passengerTrain;

}
