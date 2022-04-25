package com.ranu.juraganangkot.repository;

import com.ranu.juraganangkot.entity.Angkot;
import com.ranu.juraganangkot.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AngkotRepository extends JpaRepository<Angkot, Long> {
}
