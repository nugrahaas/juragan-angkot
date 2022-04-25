package com.ranu.juraganangkot.service.implementation;

import com.ranu.juraganangkot.entity.Angkot;
import com.ranu.juraganangkot.entity.Driver;
import com.ranu.juraganangkot.repository.AngkotRepository;
import com.ranu.juraganangkot.repository.DriverRepository;
import com.ranu.juraganangkot.service.framework.AngkotService;
import com.ranu.juraganangkot.service.framework.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AngkotServiceImpl implements AngkotService {
    private final AngkotRepository angkotRepository;

    @Autowired
    public AngkotServiceImpl(AngkotRepository angkotRepository) {
        this.angkotRepository = angkotRepository;
    }

    @Override
    public List<Angkot> getAllAngkots() {
        return angkotRepository.findAll();
    }

    @Override
    public Optional<Angkot> findById(Long id) {
        return angkotRepository.findById(id);
    }

    @Override
    public Angkot save(Angkot angkot) {
        return angkotRepository.save(angkot);
    }

    @Override
    public void deleteById(Long id) {
        angkotRepository.deleteById(id);
    }
}