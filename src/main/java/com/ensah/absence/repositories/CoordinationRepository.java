package com.ensah.absence.repositories;

import com.ensah.absence.entities.Coordination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoordinationRepository extends JpaRepository<Coordination,Long> {
         List<Coordination> findAllByIdCoordinationIn(List<Long> ids);
         List<Coordination> findAll();
         Coordination findByFiliereTitreFiliere(String s);
}
