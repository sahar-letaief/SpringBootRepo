package com.example.stationdeski.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "Inscription")
public class Inscription implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idInscription")
    private Integer idInscription;
    private String numInscription;
    private Integer numSemaine;

}
