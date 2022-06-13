package edu.pja.mas.s19230.mas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 64)
    private String firstName;

    @NotBlank(message = "Surname is mandatory")
    @Size(min = 2, max = 64)
    private String LastName;

    @NotBlank(message = "Email is mandatory")
    @Size(min = 2, max = 64)
    private String email;

    @NotBlank(message = "Phone number is mandatory")
    @Size(min = 2, max = 64)
    private String phoneNumber;
}
