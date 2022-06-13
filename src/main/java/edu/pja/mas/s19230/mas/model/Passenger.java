package edu.pja.mas.s19230.mas.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Passenger extends Person{

    @NotBlank(message = "idNumber is mandatory")
    @Size(min = 2, max = 64)
    private String idNumber;

    @NotBlank(message = "Insurance number is mandatory")
    @Size(min = 2, max = 64)
    private String insuranceNumber;

    @OneToMany(mappedBy = "hasTicket", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Ticket> tickets = new HashSet<>();
}
