package com.example.stationdeski.services;

import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.typeAbonnement;

import java.util.List;
import java.util.Set;

public interface IAbonnementService {
    List<Abonnement> retrieveAllAbonnements();

    Abonnement addAbonnement(Abonnement a);

    Abonnement updateAbonnement (Abonnement a);

    Abonnement retrieveAbonnement (Integer idAbonnement);

    void deleteAbonnement( Integer idAbonnement);
    Set<Abonnement> getAbonnementByType(typeAbonnement type);
}
