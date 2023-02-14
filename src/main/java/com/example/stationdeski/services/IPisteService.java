package com.example.stationdeski.services;


import com.example.stationdeski.entities.Piste;

import java.util.List;

public interface IPisteService {
    List<Piste> retrieveAllPistes();

    Piste addPiste(Piste p);

    Piste updatePiste (Piste p);

    Piste retrievePiste (Integer idPiste);

    void deletePiste( Integer idPiste);
}
