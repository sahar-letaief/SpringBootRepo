package com.example.stationdeski.services;

import com.example.stationdeski.entities.Piste;
import com.example.stationdeski.entities.Skieur;
import com.example.stationdeski.repositories.PisteRepository;
import com.example.stationdeski.repositories.SkieurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkieurService implements ISkieurService{

    SkieurRepository skieurRepository;
    PisteRepository pisteRepository;

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur s) {
        skieurRepository.save(s);
        return s;
    }

    @Override
    public Skieur updateSkieur(Skieur s) {
        skieurRepository.save(s);
        return s;
    }

    @Override
    public Skieur retrieveSkieur(Integer idSkieur) {
        return skieurRepository.findById(idSkieur).get();
    }

    @Override
    public void deleteSkieur(Integer idSkieur) {
        skieurRepository.deleteById(idSkieur);
    }
    @Transactional
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste){
        Skieur sk=skieurRepository.GetSkieurByNum(String.valueOf(numSkieur));
        Piste ps=pisteRepository.GetPisteByNum(String.valueOf(numPiste));

        sk.getPistes().add(ps);

        return sk;

    }
}
