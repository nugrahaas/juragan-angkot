package com.ranu.juraganangkot.controller;

import com.ranu.juraganangkot.entity.Angkot;
import com.ranu.juraganangkot.entity.Driver;
import com.ranu.juraganangkot.exception.AngkotNotFoundException;
import com.ranu.juraganangkot.exception.DriverNotFoundException;
import com.ranu.juraganangkot.service.framework.AngkotService;
import com.ranu.juraganangkot.service.framework.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/angkots")
public class AngkotController {
    private final AngkotService angkotService;

    @Autowired
    public AngkotController(AngkotService angkotService) {
        this.angkotService = angkotService;
    }

    @GetMapping
    public List<Angkot> getAllAngkot() {
        return angkotService.getAllAngkots();
    }

    @GetMapping(value = "/{id}")
    public Angkot getAngkotById(@PathVariable("id") @Min(1) Long id) {
        Angkot angkot = angkotService.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("angkot with " + id + " is Not Found!"));
        return angkot;
    }

    @PostMapping
    public Angkot addAngkot(@Valid @RequestBody Angkot angkot) {
        return angkotService.save(angkot);
    }

    @PutMapping(value = "/{id}")
    public Angkot updateAngkot(@PathVariable("id") @Min(1) Long id, @Valid @RequestBody Angkot newStd) {
        Angkot angkot = angkotService.findById(id)
                .orElseThrow(() -> new AngkotNotFoundException("Angkot with " + id + " is Not Found!"));
        angkot.setAngkot_name(newStd.getAngkot_name());
        angkot.setDestination(newStd.getDestination());
        angkot.setNumber(newStd.getNumber());
        angkot.setTax(newStd.getTax());
        return angkotService.save(angkot);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteAngkot(@PathVariable("id") @Min(1) Long id) {
        Angkot angkot = angkotService.findById(id)
                .orElseThrow(() -> new DriverNotFoundException("angkot with " + id + " is Not Found!"));
        angkotService.deleteById(angkot.getId());
        return "angkot with ID :" + id + " is deleted";
    }
}