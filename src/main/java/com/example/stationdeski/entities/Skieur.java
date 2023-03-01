package com.example.stationdeski.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name="Skieur")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSkieur")
    private Integer idSkieur;
    private long numSkieur;
    private String nomS;
    private String prenomS;
    private LocalDate dateNaissance;
    private String ville;


    @ManyToMany
    private Set<Piste> pistes;

    @OneToMany(mappedBy = "skieur",cascade = CascadeType.PERSIST)
    private Set<Inscription> inscriptions;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Abonnement abonnement;


}



