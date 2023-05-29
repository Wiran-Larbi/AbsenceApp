package com.ensah.absence.repositories;

import com.ensah.absence.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {


}
