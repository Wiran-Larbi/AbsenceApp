package com.ensah.absence.services.Impl;
import com.ensah.absence.entities.Filiere;
import com.ensah.absence.repositories.FiliereRepository;
import com.ensah.absence.services.StructPedaService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class IStructPedaService implements StructPedaService {
    private FiliereRepository filiereRepository;
    @Override
    public List<Filiere> getAllFiliere(){
        return null;
    }
}