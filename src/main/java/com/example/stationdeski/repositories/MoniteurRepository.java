package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MoniteurRepository extends JpaRepository<Moniteur,Integer> {

    Moniteur findMoniteurByNomM(Long numMoniteur);

    //List<Moniteur> getMoniteurByCours();
}
