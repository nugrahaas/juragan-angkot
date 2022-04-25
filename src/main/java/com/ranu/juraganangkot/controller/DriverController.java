package com.ranu.juraganangkot.controller;

import com.ranu.juraganangkot.entity.Driver;
import com.ranu.juraganangkot.exception.DriverNotFoundException;
import com.ranu.juraganangkot.service.framework.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping(value = "/{id}")
    public Driver getDriverById(@PathVariable("id") @Min(1) Long id) {
        Driver driver = driverService.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("Driver with " + id + " is Not Found!"));
        return driver;
    }

    @PostMapping
    public Driver addDriver(@Valid @RequestBody Driver driver) {
        return driverService.save(driver);
    }

    @PutMapping(value = "/{id}")
    public Driver updateDriver(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Driver newStd) {
        Driver driver = driverService.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("Driver with " + id + " is Not Found!"));
        driver.setDriver_name(newStd.getDriver_name());
        driver.setDriver_username(newStd.getDriver_username());
        driver.setEmail(newStd.getEmail());
        driver.setDriver_phone(newStd.getDriver_phone());
        driver.setBehaviour(newStd.getBehaviour());
        return driverService.save(driver);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteDriver(@PathVariable("id") @Min(1) Long id) {
        Driver std = driverService.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("Driver with " + id + " is Not Found!"));
        driverService.deleteById(std.getId());
        return "Driver with ID :" + id + " is deleted";
    }
}