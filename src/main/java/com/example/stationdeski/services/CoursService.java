package com.example.stationdeski.services;

import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.repositories.CoursRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursService implements ICoursService {

    CoursRepository coursRepository;

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
}
