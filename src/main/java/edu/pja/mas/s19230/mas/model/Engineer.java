package edu.pja.mas.s19230.mas.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Engineer extends Worker{

    @NotBlank(message = "Exp. level is mandatory")
    @Size(min = 2, max = 64)
    private String experienceLevel;

    @OneToMany(mappedBy = "engineer", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Train> trains;
}
