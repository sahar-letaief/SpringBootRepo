package com.example.stationdeski.services;


import com.example.stationdeski.entities.Inscription;

import java.util.List;

public interface IinscriptonService {
    List<Inscription> retrieveAllInscription();

    Inscription addInscription(Inscription i);

    Inscription updateInscription (Inscription i);

    Inscription retrieveInscription (Integer idInscription);

    void deleteInscription(Integer idInscription);
}
