package com.ensah.absence.repositories;

import com.ensah.absence.entities.Niveau;
import com.ensah.absence.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module,Long> {
       List<Module> findAll();
       Module findAllByIdModule(Long id);
       List<Module> findAllByNiveauIdNiveau(Long id);
}
