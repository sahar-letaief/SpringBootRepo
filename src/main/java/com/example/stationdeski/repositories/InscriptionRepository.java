package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Inscription;
import com.example.stationdeski.entities.Skieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;

public interface InscriptionRepository extends JpaRepository<Inscription,Integer> {

    @Query("SELECT i FROM Inscription i WHERE i.numInscription =:numInscription")
    Inscription GetInsByNum(@Param("numInscription") String numInscription);

    Long countByCours(Cours cours);
}
