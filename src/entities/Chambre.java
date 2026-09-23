/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author hp
 */
@Entity
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float prix;

    public enum TypeChambre {

        SIMPLE,
        DOUBLE,
        F1,
        F2,
        SUITE
    }

    public enum EtatChambre {

        DISPONIBLE,
        OCCUPEE,
        EN_MAINTENANCE
    }
    @Enumerated(EnumType.STRING)
    private TypeChambre type;

    @Enumerated(EnumType.STRING)
    private EtatChambre etat;

    @ManyToOne
    private Hotel hotel;

    public Chambre() {
    }

    public Chambre(float prix, TypeChambre type, EtatChambre etat, Hotel hotel) {
        this.prix = prix;
        this.type = type;
        this.etat = etat;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public TypeChambre getType() {
        return type;
    }

    public void setType(TypeChambre type) {
        this.type = type;
    }

    public EtatChambre getEtat() {
        return etat;
    }

    public void setEtat(EtatChambre etat) {
        this.etat = etat;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
