package com.example.stationdeski.services;

import com.example.stationdeski.entities.Cours;

import java.util.List;

public interface ICoursService {
    List<Cours> retrieveAllCours();

    Cours addCours(Cours c);

    Cours updateCours (Cours c);

    Cours retrieveCours (Integer idCours);

    void deleteCours( Integer idCours);
}
