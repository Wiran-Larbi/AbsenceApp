package com.ensah.absence.services.Impl;
import com.ensah.absence.entities.*;
import com.ensah.absence.entities.Module;
import com.ensah.absence.repositories.*;
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
    ElementsRepository elementsRepository;
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
    public List<Niveau> getNiveauxByIdFiliere(Long id) {
        return niveauRepository.findAllByFiliereIdFiliere(id);
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
    public Element getElementById(Long id) {
        return elementsRepository.findElementByIdElement(id);
    }

    @Override
    public List<Element> getElementByIdModule(Long id) {
        return elementsRepository.findAllByModuleIdModule(id);
    }

    @Override
    public List<Element> getAllElements() {
        return elementsRepository.findAll();
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
    public void supprimerNiveau(Long id) {
        niveauRepository.deleteById(id);
    }

    @Override
    public void supprimerModule(Long id) {
         moduleRepository.deleteById(id);
    }

    @Override
    public void supprimerElement(Long id) {
        elementsRepository.deleteById(id);
    }

    @Override
    public void ajouterModule(Module module) {
           moduleRepository.save(module);
    }

    @Override
    public void ajouterElement(Element element) {
           elementsRepository.save(element);
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