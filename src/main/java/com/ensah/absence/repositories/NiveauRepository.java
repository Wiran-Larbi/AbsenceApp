package com.ensah.absence.repositories;

import com.ensah.absence.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NiveauRepository extends JpaRepository<Niveau,Long> {
    List<Niveau> findAllByIdNiveauIn(List<Long> Ids);
    Niveau findAllByIdNiveau(Long id);
    List<Niveau> findAllByFiliereIdFiliere(Long id);
}
