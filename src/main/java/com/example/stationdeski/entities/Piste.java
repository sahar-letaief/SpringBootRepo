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

    public Piste() {
    }

    public Piste(Integer idPiste, Long numPiste, String nomPiste, Couleur couleur, Integer longeur, Integer pente, Set<Skieur> skieurs) {
        this.idPiste = idPiste;
        this.numPiste = numPiste;
        this.nomPiste = nomPiste;
        this.couleur = couleur;
        this.longeur = longeur;
        this.pente = pente;
        this.skieurs = skieurs;
    }

    public Integer getIdPiste() {
        return idPiste;
    }

    public void setIdPiste(Integer idPiste) {
        this.idPiste = idPiste;
    }

    public Long getNumPiste() {
        return numPiste;
    }

    public void setNumPiste(Long numPiste) {
        this.numPiste = numPiste;
    }

    public String getNomPiste() {
        return nomPiste;
    }

    public void setNomPiste(String nomPiste) {
        this.nomPiste = nomPiste;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Integer getLongeur() {
        return longeur;
    }

    public void setLongeur(Integer longeur) {
        this.longeur = longeur;
    }

    public Integer getPente() {
        return pente;
    }

    public void setPente(Integer pente) {
        this.pente = pente;
    }

    public Set<Skieur> getSkieurs() {
        return skieurs;
    }

    public void setSkieurs(Set<Skieur> skieurs) {
        this.skieurs = skieurs;
    }
}