package com.example.stationdeski.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "Cours")
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCours")
    private Integer idCours;
    private long numCours;
    private Integer niveau;
    @Enumerated(EnumType.STRING)
    private TypeCours TypeCours;
    @Enumerated(EnumType.STRING)
    private Support support;
    private float prix;
    private Integer creneau;
}
