package edu.pja.mas.s19230.mas.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StationRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Station Route name is mandatory")
    @Size(min = 2, max = 64)
    private String stationRouteName;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    @NotNull
    private Route routeParent;

    @ManyToOne
    @JoinColumn(name = "station_id", nullable = false)
    @NotNull
    private Station station;
}
