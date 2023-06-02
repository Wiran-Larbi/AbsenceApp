package com.ensah.absence.controllers;

import com.ensah.absence.entities.*;
import com.ensah.absence.entities.Module;
import com.ensah.absence.repositories.FiliereRepository;
import com.ensah.absence.services.StructPedaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/structPeda")
@AllArgsConstructor
public class StructPedaController {
    private StructPedaService structPedaService;
    @GetMapping("/")
    public String structPeda(){
        return "redirect:/structPeda/filieres";
    }

    @GetMapping("/filieres")
    public String filieres(Model model, @RequestParam(name="filSearch",required=false) Long id){
        if(id!=null){
            Filiere filiere=structPedaService.getFiliereById(id);
            if(filiere!=null){
            model.addAttribute("filiere",filiere);
            model.addAttribute("s",true);}
            else{
                model.addAttribute("s",false);
            }
        }else{
            model.addAttribute("s",false);
        }
        return "structPeda/Filieres/filieres";
    }

    @GetMapping("/filieres/delete")
    public String deleteFiliere(Model model,@RequestParam("idFiliere")Long id){
        structPedaService.supprimerFiliere(id);
        return "structPeda/Filieres/filieres";
    }
    @GetMapping("/niveaux/delete")
    public String deleteNiveau(Model model,@RequestParam("idNiveau")Long id){
        structPedaService.supprimerNiveau(id);
        return "structPeda/Niveaux/niveaux";
    }
    @GetMapping("/modules/delete")
    public String deleteModule(Model model,@RequestParam("idModule")Long id){
        structPedaService.supprimerModule(id);
        return "structPeda/Niveaux/modules";
    }
    @GetMapping("/elements/delete")
    public String deleteElement(Model model,@RequestParam("idElement")Long id){
        structPedaService.supprimerElement(id);
        return "structPeda/Niveaux/elements";
    }
    @GetMapping("/filieres/addFiliere")
    public String addFiliere(Model model){
        model.addAttribute("filiere",new Filiere());
        return "structPeda/Filieres/addFiliere";
    }
    @PostMapping("/saveFiliere")
    public String saveFiliere(@Valid Filiere filiere, @RequestParam(value = "niveaux", required = false) List<Long> niveauxIds,@RequestParam(value = "coordinations", required = false) List<Long> coordinationsIds,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "structPeda/Filieres/addFiliere";}
        structPedaService.ajouterFiliere(filiere);

        if (niveauxIds != null && !niveauxIds.isEmpty()) {
            List<Niveau> niveaux = structPedaService.getAllNiveauxById(niveauxIds);
            filiere.addNiveaux(niveaux);
            structPedaService.ajouterFiliere(filiere);
        }
        if (coordinationsIds != null && !coordinationsIds.isEmpty()) {
            List<Coordination> coordinations = structPedaService.getAllCoordinationsByIdCoordination(coordinationsIds);
            filiere.addCoordinations(coordinations);
            structPedaService.ajouterFiliere(filiere);
        }
        return "redirect:/structPeda/Filieres/filieres?filSearch="+filiere.getIdFiliere();
    }

    /////////////////////////////////////////////////////////
    ////////////////////////////////Coordination////////////
    ////////////////////////////////////////////////////////
    @GetMapping("/coordinations")
    public String coordinations(Model model,@RequestParam(name="coorSearch",defaultValue = "")String name){
        model.addAttribute("coordinations",structPedaService.getByFiliereTitreFiliere(name));
        return "/structPeda/Filieres/coordinations";
    }
    @GetMapping("addCoordination")
    public String addCoordination(Model model){
        model.addAttribute("coordination",new Coordination());
        return "structPeda/Filieres/addCoordination";
    }
    @PostMapping("saveCoordination")
    public String saveCoordination(@Valid Coordination coordination,@RequestParam(name="id")Long id,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "structPeda/Filieres/addCoordination";}
        coordination.setDateDebut(LocalDate.parse(coordination.getDateDebutStr()));
        coordination.setDateFin(LocalDate.parse(coordination.getDateFinStr()));
        coordination.setFiliere(structPedaService.getFiliereById(id));
        structPedaService.ajouterCoordination(coordination);

        return "/structPeda/Filieres/coordinations";
    }
    /////////////////////////////////////////////////////////
    ////////////////////////////////Niveau////////////
    ////////////////////////////////////////////////////////
    @GetMapping("/niveaux")
    public String niveaux(Model model,@RequestParam(name="nivSearch",required = false)Long id){
        if(id!=null){
            Niveau niveau=structPedaService.getNiveauById(id);
            if(niveau!=null){
                model.addAttribute("niveau",niveau);
                model.addAttribute("s",true);
            }else{
                model.addAttribute("s",false);
            }
        }else{
            model.addAttribute("s",false);
        }
        return "structPeda/Niveaux/niveaux";
    }
    @GetMapping("modules")
    public String  modules(Model model,@RequestParam(name="modSearch",required = false)Long id){
        if(id!=null){
            Module module=structPedaService.getModuleById(id);
            if(module!=null){
                model.addAttribute("module",structPedaService.getModuleById(id));
                model.addAttribute("s",true);
            }else{
                model.addAttribute("s",false);
            }
        }else{
            model.addAttribute("s",false);
        }
        return "structPeda/Niveaux/modules";
    }
    @GetMapping("elements")
    public String elements(Model model, @RequestParam(name = "eleSearch", required = false) Long id) {
        if (id != null) {
            Element element = structPedaService.getElementById(id);
            if (element != null) {
                model.addAttribute("element", element);
                model.addAttribute("s", true);
            } else {
                model.addAttribute("s", false);
            }
        } else {
            model.addAttribute("s", false);
        }
        return "structPeda/Niveaux/elements";
    }

    @ModelAttribute("getFilieres")
    public List<Filiere> getFilieres() {
        return structPedaService.getAllFiliere();
    }
    @ModelAttribute("getCoordinations")
    public List<Coordination> getCoordinations() {
        return structPedaService.getAllCoordinations();
    }
    @ModelAttribute("getNiveaux")
    public List<Niveau> getNiveaux(@RequestParam(name = "filSearch", required = false) Long id) {
        if (id != null) {
            return structPedaService.getNiveauxByIdFiliere(id);
        } else {
            return structPedaService.getAllNiveaux();
        }

    }
    @ModelAttribute("getModules")
    public List<Module> getModules(@RequestParam(name = "nivSearch", required = false) Long id) {
        if (id != null) {
            return structPedaService.getModuleByIdNiveau(id);
        } else {
            return structPedaService.getAllModules();
        }
    }
    @ModelAttribute("getElements")
    public List<Element> getElement(@RequestParam(name = "modSearch", required = false) Long id) {
        if (id != null) {
            return structPedaService.getElementByIdModule(id);
        } else {
            return structPedaService.getAllElements();
        }
    }


}
