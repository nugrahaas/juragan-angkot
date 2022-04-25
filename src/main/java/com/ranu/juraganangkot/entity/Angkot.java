package com.ranu.juraganangkot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "angkot")
public class Angkot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name is required")
    @Column(nullable = false, name = "name")
    private String angkot_name;

    @NotEmpty(message = "name is required")
    @Column(nullable = false)
    private String destination;

    @NotEmpty(message = "Phone number is required")
    @Column(nullable = false, unique = true)
    private String number;

    @NotEmpty(message = "behaviour is required")
    @Column(nullable = false)
    private String tax;

}
