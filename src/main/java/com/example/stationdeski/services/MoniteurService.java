package com.example.stationdeski.services;

import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.entities.Support;
import com.example.stationdeski.repositories.CoursRepository;
import com.example.stationdeski.repositories.MoniteurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class MoniteurService implements IMoniteurService {
    MoniteurRepository moniteurRepository;
    CoursRepository coursRepository;
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
    @Override
    public List<Integer> numWeeksCourseOfMoniteurBySupport(long numMoniteur, Support support){
        Moniteur m=moniteurRepository.findMoniteurByNomM(numMoniteur);
        Integer nb=coursRepository.getCoursBySupport(support);
       // Integer nb=coursRepository.getCoursBySupport(support,numMoniteur);
        List<Integer> liste=new ArrayList<>();
        liste.add(nb);

        return liste;

    }
}
