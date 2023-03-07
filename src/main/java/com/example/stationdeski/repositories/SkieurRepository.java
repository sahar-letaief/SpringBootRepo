package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Skieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur,Integer> {
    @Query("SELECT s FROM Skieur s WHERE s.numSkieur =:numSkieur")
    Skieur GetSkieurByNum(@Param("numSkieur") String numSkieur);


}
