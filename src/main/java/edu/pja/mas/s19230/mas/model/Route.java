package edu.pja.mas.s19230.mas.model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String routeNumber;

    @NotBlank
    private String departureFrom;

    @NotBlank
    private String arrivalTo;

    @NotBlank
    private LocalTime departureTime;

    @NotBlank
    private LocalTime arrivalTime;

    @NotBlank
    private LocalDate departureDate;

    @NotBlank
    private LocalDate arrivalDate;


    @Min(0)
    private double mileage;

    @OneToMany(mappedBy = "routeParent", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<StationRoute> stationRoutes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "machinist_id", nullable = false)
    @NotNull
    private Machinist machinist;
}
