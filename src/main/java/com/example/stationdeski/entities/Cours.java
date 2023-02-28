package com.example.stationdeski.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "Cours")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


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

    @OneToMany(mappedBy = "cours")
    private Set<Inscription> inscriptions;


}
