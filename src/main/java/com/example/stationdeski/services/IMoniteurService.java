package com.example.stationdeski.services;
import com.example.stationdeski.entities.Moniteur;

import java.util.List;

public interface IMoniteurService {

    List<Moniteur> retrieveAllMoniteurs();

    Moniteur addMoniteur(Moniteur m);

    Moniteur updateMoniteur (Moniteur m);

    Moniteur retrieveMoniteur (Integer idMoniteur);

    void deleteMoniteur( Integer idMoniteur);
    Moniteur addMoniteurAndAssignToCours(Moniteur moniteur);

}
