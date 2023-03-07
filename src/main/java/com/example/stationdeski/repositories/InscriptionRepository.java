package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Cours;
import com.example.stationdeski.entities.Inscription;
import com.example.stationdeski.entities.Skieur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InscriptionRepository extends JpaRepository<Inscription,Integer> {


}
