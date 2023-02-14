package com.example.stationdeski.services;

import com.example.stationdeski.entities.Piste;
import com.example.stationdeski.repositories.PisteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PisteService implements IPisteService{

    PisteRepository pisteRepository;

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste p) {
        pisteRepository.save(p);
        return p;
    }

    @Override
    public Piste updatePiste(Piste p) {
        pisteRepository.save(p);
        return p;
    }

    @Override
    public Piste retrievePiste(Integer idPiste) {
        return pisteRepository.findById(idPiste).get();

    }

    @Override
    public void deletePiste(Integer idPiste) {
        pisteRepository.deleteById(idPiste);

    }
}
