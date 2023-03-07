package com.example.stationdeski.services;

import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.repositories.MoniteurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MoniteurService implements IMoniteurService {
    MoniteurRepository moniteurRepository;
    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur m) {moniteurRepository.save(m); return m; }

    @Override
    public Moniteur updateMoniteur(Moniteur m) {
        moniteurRepository.save(m);
        return m;
    }

    @Override
    public Moniteur retrieveMoniteur(Integer idMoniteur) {
       return moniteurRepository.findById(idMoniteur).get();

    }

    @Override
    public void deleteMoniteur(Integer idMoniteur) {
        moniteurRepository.deleteById(idMoniteur);

    }

    @Override
    public Moniteur addMoniteurAndAssignToCours(Moniteur moniteur) {
    moniteurRepository.save(moniteur);
        return moniteur;
    }
}
