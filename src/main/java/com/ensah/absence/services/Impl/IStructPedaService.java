package com.ensah.absence.services.Impl;
import com.ensah.absence.entities.Coordination;
import com.ensah.absence.entities.Filiere;
import com.ensah.absence.entities.Niveau;
import com.ensah.absence.entities.Module;
import com.ensah.absence.repositories.CoordinationRepository;
import com.ensah.absence.repositories.FiliereRepository;
import com.ensah.absence.repositories.ModuleRepository;
import com.ensah.absence.repositories.NiveauRepository;
import com.ensah.absence.services.StructPedaService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class IStructPedaService implements StructPedaService {
    NiveauRepository niveauRepository;
    FiliereRepository filiereRepository;
    CoordinationRepository coordinationRepository;
    ModuleRepository moduleRepository;
    @Override
    public Filiere getFiliereByCode(String s ){
        return filiereRepository.findByCodeFiliere(s);
    }

    @Override
    public Filiere getFiliereById(Long id) {
        return filiereRepository.findByIdFiliere(id);
    }

    @Override
    public List<Niveau> getAllNiveaux() {
        return niveauRepository.findAll();
    }

    @Override
    public List<Filiere> getAllFiliere() {
        return filiereRepository.findAll();
    }

    @Override
    public List<Niveau> getAllNiveauxById(List<Long> Ids) {
        return niveauRepository.findAllByIdNiveauIn(Ids);
    }
    @Override
    public void affectAllNiveauxToCorrespondingFiliere(Long id) {
        List<Niveau> niveaux = niveauRepository.findAllByFiliereIdFiliere(id);
        Filiere filiere=filiereRepository.findByIdFiliere(id);
        filiere.addNiveaux(niveaux);
    }

    @Override
    public List<Coordination> getAllCoordinations() {
        return coordinationRepository.findAll();
    }

    @Override
    public Coordination getByFiliereTitreFiliere(String s) {
        return coordinationRepository.findByFiliereTitreFiliere(s);
    }

    @Override
    public void ajouterCoordination(Coordination coordination) {
        coordinationRepository.save(coordination);
    }

    @Override
    public void supprimerCoordination(Long id) {
        coordinationRepository.deleteById(id);
    }

    @Override
    public Niveau getNiveauById(Long s) {
        return niveauRepository.findNiveauByIdNiveau(s);
    }

    @Override
    public Module getModuleById(Long id) {
        return moduleRepository.findAllByIdModule(id);
    }

    @Override
    public List<Module> getModuleByIdNiveau(Long id) {
        return moduleRepository.findAllByNiveauIdNiveau(id);
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }


    @Override
    public Set<Coordination> getCoordinationsByFiliereId(Long id) {
        return filiereRepository.findCoordinationsByFiliere(id);
    }
    @Override
    public List<Coordination> getAllCoordinationsByIdCoordination(List<Long> ids){
        return coordinationRepository.findAllByIdCoordinationIn(ids);
    }
    @Override
    public void supprimerFiliere(Long id){
        filiereRepository.deleteById(id);
    }
    @Override
    public void ajouterFiliere(Filiere filiere){
        filiereRepository.save(filiere);
    }
    @Override
    public void ajouterNiveau(Niveau niveau){
        niveauRepository.save(niveau);
    }
}