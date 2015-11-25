package fr.esigelec.garage;

import java.util.List;

/**
 * Hello hibernate!
 *
 */
public class App {
    public static void main(String[] args) {
        
    	// dÃ©claration et initialisation
    	System.out.println("Hello Hibernate! Getting started...");
        VoitureDAO dao = new VoitureDAO();	          // instanciation du DAO
        Voiture voiture = new Voiture(0, "AB-123-CD", // creÌ�ation d'une voiture
                  "Peugeot 207", 2007, 100000);
        System.out.println(voiture);                  // affichage de la personne ajouteÌ�e
        
        // opÃ©rations avec Hibernate
        dao.ajouter(voiture);                         // ajout de la voiture v
        Voiture voiture1 = dao.get(1);                // rÃ©cupÃ©rer une voiture avec id = 1
        System.out.println(voiture1);                 // affichage
        
        List<Voiture> voitures = dao.getVoitures();   // rÃ©cupÃ©ration de toutes les voitures
        for(Voiture v : voitures)
        	System.out.println(v);                    // affichage
        
        //for(Voiture v : voitures) 
        	//dao.supprimer(v);                         // supprimer toutes les voitures
        
    }
}
