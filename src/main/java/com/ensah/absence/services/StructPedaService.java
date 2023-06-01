package com.ensah.absence.services;

import com.ensah.absence.entities.Coordination;
import com.ensah.absence.entities.Filiere;
import com.ensah.absence.entities.Niveau;
import com.ensah.absence.entities.Module;

import java.util.List;
import java.util.Set;

public interface StructPedaService {
    Filiere getFiliereByCode(String s);
    Filiere getFiliereById(Long id);
    List<Niveau> getAllNiveaux();
    List<Filiere> getAllFiliere();
    List<Niveau> getAllNiveauxById(List<Long> Ids);
    void ajouterNiveau(Niveau niveau);
    Set<Coordination> getCoordinationsByFiliereId(Long id);
    List<Coordination> getAllCoordinationsByIdCoordination(List<Long> ids);
    void supprimerFiliere(Long id);
    void ajouterFiliere(Filiere filiere);
    void affectAllNiveauxToCorrespondingFiliere(Long id);
    List<Coordination> getAllCoordinations();
    Coordination getByFiliereTitreFiliere(String s);
    void ajouterCoordination(Coordination coordination);
    void supprimerCoordination(Long id);
    Niveau getNiveauById(Long s);
    Module getModuleById(Long id);
    List<Module> getModuleByIdNiveau(Long id);
    List<Module> getAllModules();
}