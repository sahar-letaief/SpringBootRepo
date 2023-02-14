package com.example.stationdeski.repositories;

import com.example.stationdeski.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription,Integer> {
}
