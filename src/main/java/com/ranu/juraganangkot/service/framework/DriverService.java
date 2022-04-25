package com.ranu.juraganangkot.service.framework;

import com.ranu.juraganangkot.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();

    Optional<Driver> findById(Long id);

    Optional<Driver> findByEmail(String driver_email);

    Driver save(Driver driver);

    void deleteById(Long id);
}