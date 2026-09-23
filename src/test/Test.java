/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import entities.Chambre;
import entities.Hotel;
import services.ChambreService;
import services.HotelService;

/**
 *
 * @author hp
 */

public class Test {

    public static void main(String[] args) {

        HotelService hs = new HotelService();
        ChambreService cs = new ChambreService();

        Hotel hotel1 = new Hotel(
                "Hotel Mensour",
                "Marrakech"
        );

        hs.create(hotel1);
        Chambre c1 = new Chambre(
                500f,
                Chambre.TypeChambre.SIMPLE,
                Chambre.EtatChambre.DISPONIBLE,
                hotel1
        );

        Chambre c2 = new Chambre(
                800f,
                Chambre.TypeChambre.DOUBLE,
                Chambre.EtatChambre.OCCUPEE,
                hotel1
        );

        Chambre c3 = new Chambre(
                1200f,
                Chambre.TypeChambre.SUITE,
                Chambre.EtatChambre.DISPONIBLE,
                hotel1
        );

        cs.create(c1);
        cs.create(c2);
        cs.create(c3);

        Hotel hotel2 = new Hotel(
                "Zephyr",
                "Agadir"
        );

        hs.create(hotel2);

        Chambre c4 = new Chambre(
                600f,
                Chambre.TypeChambre.SIMPLE,
                Chambre.EtatChambre.DISPONIBLE,
                hotel2
        );

        Chambre c5 = new Chambre(
                1000f,
                Chambre.TypeChambre.DOUBLE,
                Chambre.EtatChambre.OCCUPEE,
                hotel2
        );

        cs.create(c4);
        cs.create(c5);

        Chambre chambre = cs.findById(c1.getId());

        System.out.println(
                "Chambre: " + chambre.getId()
                + " Prix: " + chambre.getPrix()
        );

        List<Chambre> chambres = cs.findAll();

        for (Chambre c : chambres) {

            System.out.println(
                    "Id: " + c.getId()
                    + " Prix: " + c.getPrix()
                    + " Etat: " + c.getEtat());
        }

// Afficher les chambres par  hôtel
        List<Chambre> chambresHotel
                = cs.findByHotel(hotel1);

        for (Chambre c : chambresHotel) {

            System.out.println(
                    "Id: " + c.getId()
                    + " Prix: " + c.getPrix()
            );
        }
// Chercher les chambres par le prix
        List<Chambre> chambresPrix
                = cs.findByPrix(500f);

        for (Chambre c : chambresPrix) {

            System.out.println(
                    "Id: " + c.getId()
                    + " Prix: " + c.getPrix()
            );
        }

    // Chercher les chambres par l'état
        List<Chambre> chambresDisponibles
                = cs.findByEtat(Chambre.EtatChambre.DISPONIBLE);

        for (Chambre c : chambresDisponibles) {

            System.out.println(
                    "Id: " + c.getId()
                    + " Prix: " + c.getPrix()
            );
        }

    // Modifier une chambre
        c1.setPrix(700f);

        cs.update(c1);

        System.out.println(
                "Nouveau prix: " + c1.getPrix()
        );

        // Supprimer une chambre 
        cs.delete(c5);

        System.out.println(
                "Chambre supprimée: " + c5.getId()
        );
    }
}
