package com.ensah.absence.services;

import com.ensah.absence.entities.*;
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
    void supprimerNiveau(Long id);
    void supprimerModule(Long id);
    void supprimerElement(Long id);
    void ajouterModule(Module module);
    void ajouterElement(Element element);

    void ajouterFiliere(Filiere filiere);
    void affectAllNiveauxToCorrespondingFiliere(Long id);
    List<Coordination> getAllCoordinations();
    Coordination getByFiliereTitreFiliere(String s);
    void ajouterCoordination(Coordination coordination);
    void supprimerCoordination(Long id);
    Niveau getNiveauById(Long s);
    List<Niveau> getNiveauxByIdFiliere(Long id);
    Module getModuleById(Long id);
    List<Module> getModuleByIdNiveau(Long id);
    List<Module> getAllModules();
    Element getElementById(Long id);
    List<Element> getElementByIdModule(Long id);
    List<Element> getAllElements();
}