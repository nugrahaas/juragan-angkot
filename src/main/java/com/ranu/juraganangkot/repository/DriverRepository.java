package com.ranu.juraganangkot.repository;

import com.ranu.juraganangkot.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    // Query method
    Optional<Driver> findByEmail(String driver_email);
}