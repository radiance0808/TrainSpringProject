package edu.pja.mas.s19230.mas.model;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String goodName;

    @NotBlank
    private double weight;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    @NotNull
    private Delivery delivery;
}
