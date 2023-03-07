package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Moniteur;
import com.example.stationdeski.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MoniteurRepository extends JpaRepository<Moniteur,Integer> {


}
