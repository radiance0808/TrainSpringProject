package edu.pja.mas.s19230.mas.model;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Brand name is mandatory")
    @Size(min = 2, max = 64)
    private String brandName;

    @NotBlank(message = "Model name is mandatory")
    @Size(min = 2, max = 64)
    private String modelName;

    @NotBlank(message = "Registration Number is mandatory")
    @Size(min = 2, max = 64)
    private String registrationNumber;

    @Min(10000)
    private double cost;

    private LocalDate dateOfProduction;

    @ElementCollection
    @CollectionTable(name = "train_type", joinColumns = @JoinColumn(name = "train_id"))
    @Builder.Default
    private Set<String> trainType = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "train_status", joinColumns = @JoinColumn(name = "train_id"))
    @Builder.Default
    private Set<String> trainStatus = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "engineer_id", nullable = false)
    @NotNull
    private Engineer engineer;

}
