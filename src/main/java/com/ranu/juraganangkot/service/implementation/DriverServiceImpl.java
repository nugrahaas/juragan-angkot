package com.ranu.juraganangkot.service.implementation;

import com.ranu.juraganangkot.entity.Driver;
import com.ranu.juraganangkot.repository.DriverRepository;
import com.ranu.juraganangkot.service.framework.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public Optional<Driver> findById(Long id) {
        return driverRepository.findById(id);
    }

    @Override
    public Optional<Driver> findByEmail(String driver_email) {
        return driverRepository.findByEmail(driver_email);
    }

    @Override
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public void deleteById(Long id) {
        driverRepository.deleteById(id);
    }
}