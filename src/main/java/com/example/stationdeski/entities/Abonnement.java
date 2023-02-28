package com.example.stationdeski.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table( name = "Abonnement")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAbonnement")
    private Integer idAbonnement;
    private long numAbon;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private float prixAbon;
    @Enumerated(EnumType.STRING)
    private typeAbonnement typeAbon;


}
