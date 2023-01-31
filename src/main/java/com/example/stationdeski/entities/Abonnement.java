package com.example.stationdeski.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Abonnement")
public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAbonnement")
    private Integer idAbonnement;
    private long numAbon;
    private Date dateDebut;
    private Date dateFin;
    private float prixAbon;
    @Enumerated(EnumType.STRING)
    private typeAbonnement typeAbon;
}
