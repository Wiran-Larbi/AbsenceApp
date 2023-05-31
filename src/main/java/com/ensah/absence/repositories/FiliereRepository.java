package com.ensah.absence.repositories;

import com.ensah.absence.entities.Coordination;
import com.ensah.absence.entities.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    Filiere findByCodeFiliere(String codeFiliere);
    @Query("SELECT c FROM Coordination c WHERE c.filiere.idFiliere = :idFiliere")
    Set<Coordination> findCoordinationsByFiliere(@Param("idFiliere") Long idFiliere);
    List<Filiere> findAll();
    Filiere findByIdFiliere(Long id);
}
