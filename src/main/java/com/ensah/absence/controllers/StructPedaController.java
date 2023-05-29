package com.ensah.absence.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/structPeda")
public class StructPedaController {
    @GetMapping("/filieres")
    public String filieres(Model model){
        return "filieres";
    }
}
