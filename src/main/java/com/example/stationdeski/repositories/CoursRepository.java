package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.entities.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
@Repository

public interface CoursRepository extends JpaRepository<Cours,Integer> {
    @Query("SELECT c FROM Cours c WHERE c.numCours =:numCours")
    Cours getCoursByNum(@Param("numCours") Long numCours);

    int countBySupport(Cours c);

    List<Cours> findCoursBySupport(Support support);

    @Query("SELECT i.numSemaine ,m.cours,c.support FROM Inscription i,Moniteur m,Cours c WHERE i.cours MEMBER OF m.cours")
    Integer getCoursBySupport(@Param("support") Support support);







}
