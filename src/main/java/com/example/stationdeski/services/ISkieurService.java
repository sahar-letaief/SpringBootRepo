package com.example.stationdeski.services;

import com.example.stationdeski.entities.Piste;
import com.example.stationdeski.entities.Skieur;

import java.util.List;

public interface ISkieurService {

    List<Skieur> retrieveAllSkieurs();

    Skieur addSkieur(Skieur s);

    Skieur updateSkieur (Skieur s);

    Skieur retrieveSkieur(Integer idSkieur);

    void deleteSkieur( Integer idSkieur);
}
