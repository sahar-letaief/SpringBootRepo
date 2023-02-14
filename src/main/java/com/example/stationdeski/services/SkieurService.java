package com.example.stationdeski.services;

import com.example.stationdeski.entities.Skieur;
import com.example.stationdeski.repositories.SkieurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkieurService implements ISkieurService{

    SkieurRepository skieurRepository;

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur p) {
        skieurRepository.save(p);
        return p;
    }

    @Override
    public Skieur updateSkieur(Skieur p) {
        skieurRepository.save(p);
        return p;
    }

    @Override
    public Skieur retrieveSkieur(Integer idSkieur) {
        return skieurRepository.findById(idSkieur).get();
    }

    @Override
    public void deleteSkieur(Integer idSkieur) {
        skieurRepository.deleteById(idSkieur);

    }
}
