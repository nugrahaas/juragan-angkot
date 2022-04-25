package com.ranu.juraganangkot.service.framework;

import com.ranu.juraganangkot.entity.Angkot;
import com.ranu.juraganangkot.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface AngkotService {
    List<Angkot> getAllAngkots();

    Optional<Angkot> findById(Long id);

    Angkot save(Angkot angkot);

    void deleteById(Long id);
}