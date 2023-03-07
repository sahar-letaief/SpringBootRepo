package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Abonnement;
import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.typeAbonnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement,Integer> {
    @Query("SELECT a FROM Abonnement a WHERE a.typeAbon =:typeAbon")
    Set<Abonnement> getAbonByType(@Param("typeAbon") typeAbonnement typeAbon);
}
