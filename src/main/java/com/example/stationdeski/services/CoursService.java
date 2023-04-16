package com.example.stationdeski.services;

import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.entities.Support;
import com.example.stationdeski.repositories.CoursRepository;
import com.example.stationdeski.repositories.MoniteurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CoursService implements ICoursService {

    CoursRepository coursRepository;
    MoniteurRepository moniteurRepository;

    @Override
    public List<Cours> retrieveAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours c) {
        coursRepository.save( c);
        return c;
    }

    @Override
    public Cours updateCours(Cours c) {
        coursRepository.save(c);
        return c;
    }

    @Override
    public Cours retrieveCours(Integer idCours) {
        return coursRepository.findById(idCours).get();

    }

    @Override
    public void deleteCours(Integer idCours) {
        coursRepository.deleteById(idCours);

    }

    @Override
    public List<Integer> numWeeksCourseOfMoniteurBySupport(Long numMoniteur, Support support) {
        List<Integer> liste=new ArrayList<>();
        Moniteur m= moniteurRepository.findMoniteurByNomM(numMoniteur);
        List<Cours> listecours=coursRepository.findCoursBySupport(support);
        for (Cours c:listecours
             ) {
            Integer i=coursRepository.getCoursBySupport(support);
            liste.add(i);

        }

        return liste;

    }
}
