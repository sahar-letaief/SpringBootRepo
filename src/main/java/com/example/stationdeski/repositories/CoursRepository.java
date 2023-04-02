package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Integer> {
    @Query("SELECT c FROM Cours c WHERE c.numCours =:numCours")
    Cours getCoursByNum(@Param("numCours") Long numCours);

    int countBySupport(Cours c);



}
