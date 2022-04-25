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
@Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "name is required")
    @Column(nullable = false, name = "name")
    private String driver_name;

    @NotEmpty(message = "name is required")
    @Column(nullable = false, name = "username")
    private String driver_username;

    @NotEmpty(message = "email is required")
    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Phone number is required")
    @Column(nullable = false, unique = true)
    private String driver_phone;

    @NotEmpty(message = "behaviour is required")
    @Column(nullable = false)
    private String behaviour;

}