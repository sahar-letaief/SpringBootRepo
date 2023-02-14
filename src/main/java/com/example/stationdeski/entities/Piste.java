package com.example.stationdeski.entities;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table( name = "Piste")
public class Piste implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idPiste")
    private Integer idPiste; // Clé primaire
    private Long numPiste;
    private String nomPiste;
    @Enumerated(EnumType.STRING) //si non 0,1,2
    private Couleur couleur;
    private Integer longeur;
    private Integer pente;



    @ManyToMany(mappedBy = "pistes")
    private Set<Skieur> skieurs;
}