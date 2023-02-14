package com.example.stationdeski.services;

import com.example.stationdeski.entities.Inscription;
import com.example.stationdeski.repositories.InscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InscriptionService implements IinscriptonService{

    InscriptionRepository inscriptionRepository;

    @Override
    public List<Inscription> retrieveAllInscription() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription addInscription(Inscription i) {
        inscriptionRepository.save(i);
        return i;
    }

    @Override
    public Inscription updateInscription(Inscription i) {
        inscriptionRepository.save(i);
        return i;
    }

    @Override
    public Inscription retrieveInscription(Integer idInscription) {
       return inscriptionRepository.findById(idInscription).get();
    }

    @Override
    public void deleteInscription(Integer idInscription) {
        inscriptionRepository.deleteById(idInscription);

    }
}
