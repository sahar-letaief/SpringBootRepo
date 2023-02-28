package com.example.stationdeski.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    @OneToMany(mappedBy = "cours")
    private Set<Inscription> inscriptions;

    public Cours() {
    }

    public Cours(Integer idCours, long numCours, Integer niveau, com.example.stationdeski.entities.TypeCours typeCours, Support support, float prix, Integer creneau, Set<Inscription> inscriptions) {
        this.idCours = idCours;
        this.numCours = numCours;
        this.niveau = niveau;
        TypeCours = typeCours;
        this.support = support;
        this.prix = prix;
        this.creneau = creneau;
        this.inscriptions = inscriptions;
    }

    public Integer getIdCours() {
        return idCours;
    }

    public void setIdCours(Integer idCours) {
        this.idCours = idCours;
    }

    public long getNumCours() {
        return numCours;
    }

    public void setNumCours(long numCours) {
        this.numCours = numCours;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public com.example.stationdeski.entities.TypeCours getTypeCours() {
        return TypeCours;
    }

    public void setTypeCours(com.example.stationdeski.entities.TypeCours typeCours) {
        TypeCours = typeCours;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Integer getCreneau() {
        return creneau;
    }

    public void setCreneau(Integer creneau) {
        this.creneau = creneau;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
}
