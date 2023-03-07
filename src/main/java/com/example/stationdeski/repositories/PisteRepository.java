package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Piste;
import com.example.stationdeski.entities.Skieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PisteRepository extends JpaRepository<Piste,Integer> {
    @Query("SELECT p FROM Piste p WHERE p.numPiste =:numPiste")
    Piste GetPisteByNum(@Param("numPiste") String numPiste);
}
