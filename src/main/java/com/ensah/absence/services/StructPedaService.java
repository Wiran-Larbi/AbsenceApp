package com.ensah.absence.services;

import com.ensah.absence.entities.Coordination;
import com.ensah.absence.entities.Filiere;
import com.ensah.absence.entities.Niveau;

import java.util.List;
import java.util.Set;

public interface StructPedaService {
    Filiere getFiliereByCode(String s);

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
}