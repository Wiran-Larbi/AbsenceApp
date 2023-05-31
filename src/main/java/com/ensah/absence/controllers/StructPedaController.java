package com.ensah.absence.controllers;

import com.ensah.absence.entities.Coordination;
import com.ensah.absence.entities.Filiere;
import com.ensah.absence.entities.Niveau;
import com.ensah.absence.services.StructPedaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/structPeda")
@AllArgsConstructor
public class StructPedaController {
    private StructPedaService structPedaService;

    @GetMapping("/filieres")
    public String filieres(Model model, @RequestParam(name="filSearch",defaultValue = "") String s){

        if(!Objects.equals(s, "")){
            Filiere filiere=structPedaService.getFiliereByCode(s);
            structPedaService.affectAllNiveauxToCorrespondingFiliere(filiere.getIdFiliere());
        model.addAttribute("filiere",filiere);
        model.addAttribute("s",true);

        return "structPeda/Filieres/filieres";
        }
        model.addAttribute("s",false);
        return "structPeda/Filieres/filieres";
    }

    @GetMapping("/filieres/delete")
    public String deleteFiliere(Model model,@RequestParam("idFiliere")Long id){
        structPedaService.supprimerFiliere(id);
        return "structPeda/Filieres/filieres";
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
        return "redirect:/structPeda/Filieres/filieres?filSearch="+filiere.getCodeFiliere();
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
    public String saveCoordination(@ModelAttribute Coordination coordination,@RequestParam(name="titre")String titre,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "structPeda/Filieres/addCoordination";}
        coordination.setFiliere(structPedaService.getFiliereByCode(titre));
        structPedaService.ajouterCoordination(coordination);

        return "/structPeda/Filieres/coordinations";
    }

    @ModelAttribute("getFilieres")
    public List<Filiere> getFilieres() {
        return structPedaService.getAllFiliere();
    }
    @ModelAttribute("getCoordinations")
    public List<Coordination> getCoordinations() {
        return structPedaService.getAllCoordinations();
    }

}
