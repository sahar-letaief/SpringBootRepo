package com.example.stationdeski.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "Inscription")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Inscription implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idInscription")
    private Integer idInscription;
    private String numInscription;
    private Integer numSemaine;

    @ManyToOne
    private Skieur skieur;

    @ManyToOne
    private Cours cours;




}
