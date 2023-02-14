package com.example.stationdeski.services;

import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.repositories.AbonnementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class AbonnementService implements IAbonnementService{

    AbonnementRepository abonnementRepository;

    @Override
    public List<Abonnement> retrieveAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement addAbonnement(Abonnement a) {
        abonnementRepository.save(a);
        return a;
    }

    @Override
    public Abonnement updateAbonnement(Abonnement a) {
        abonnementRepository.save(a);
        return a;
    }

    @Override
    public Abonnement retrieveAbonnement(Integer idAbonnement) {
       return abonnementRepository.findById(idAbonnement).get();

    }

    @Override
    public void deleteAbonnement(Integer idAbonnement) {
        abonnementRepository.deleteById(idAbonnement);

    }
}
