package com.example.stationdeski.services;

import com.example.stationdeski.entities.*;
import com.example.stationdeski.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SkieurService implements ISkieurService{

    SkieurRepository skieurRepository;
    PisteRepository pisteRepository;
    CoursRepository coursRepository;
    AbonnementRepository abonnementRepository;

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
    @Transactional
    public Skieur addSkieurAndAssignToCours(Skieur skieur, Long numCours){
        Cours cours=coursRepository.getCoursByNum(String.valueOf(numCours));
        Skieur s=skieurRepository.save(skieur);
        Set<Inscription> inscriptions= s.getInscriptions();
        for (Inscription ins:inscriptions
             ) {
            ins.setCours(cours);
        }
        return s;
    }

    @Override
    public List<Skieur> retrieveSkieursByAbonnementType(typeAbonnement typeAbonnement) {
       Set<Abonnement> ab=abonnementRepository.getAbonByType(typeAbonnement);
       Skieur skieur= new Skieur();
       List<Skieur> skieurList= new ArrayList<>();
        System.out.println("abonnements= "+ab);

        for (Abonnement a:ab)
        {
            skieurList=skieurRepository.findByAbonnement(a);
            System.out.println(skieur);


        }
        return skieurList;
    }
}
