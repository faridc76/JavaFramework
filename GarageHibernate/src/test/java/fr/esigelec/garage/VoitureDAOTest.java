package fr.esigelec.garage;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runners.MethodSorters;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
//On regle la classe pour que les classes s'executent par odre alphabetique
@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class VoitureDAOTest {

	static Voiture voiture;
	
	private VoitureDAO dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//On initialise la voiture avec l'id 0
		voiture = new Voiture(0, "BT-099-JY", "207", 2007, 250000);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}

	@Before
	public void setUp() throws Exception {
		this.dao = new VoitureDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	//On nomme la classe avec a pour que ce soit la premiere à s'exécuter
	public void aTestAjouter() {
		//On ajoute la voiture dans la base de données 
		dao.ajouter(voiture);
		//Comme la fonction recupere l'id, si l'id n'est plus à zero
		//c'est que la voiture est bien inséré dans la base de données
		assertNotEquals(0, voiture.getId());
	}

	
	@Test(expected=NullPointerException.class)
	public void eTestSupprimerInt() {
		int id = voiture.getId();
		dao.supprimer(id);
		Voiture v = dao.get(id);
		System.out.println(v.toString());
	}
	
	@Test(expected=NullPointerException.class)
	public void fTestSupprimerVoiture() {
		Voiture v = new Voiture(0, "AN-628-HJ", "SERIE 3", 2003, 380000);
		dao.ajouter(v);
		int id = v.getId();
		dao.supprimer(v);
		Voiture voit = dao.get(id);
		System.out.println(voit.toString());
	}


	@Test
	public void dTestRouler() {
		int distance = 300;
		int kmPrecedent = voiture.getKm();
		dao.rouler(voiture, distance);
		Voiture voit = dao.get(voiture.getId());
		assertEquals(voit.getKm(), distance + kmPrecedent);
	}

	@Test
	public void bTestGet() {
		//On recupere dans la base de données la voiture avec l'id de notre voiture
		Voiture v = dao.get(voiture.getId());
		//La voiture ne doit pas etre null
		assertNotNull(v);
		//Son id n'est pas egal à 0
		assertNotEquals(v.getId(), 0);
		//On utilise la fonction equals que l'on a redefini
		assertTrue(voiture.equals(v));
	}

	@Test
	public void cTestGetVoitures() {
		//On recupere toutes les voitures
		List<Voiture> voitures = dao.getVoitures();
		//On test que la list n'est pas vide
		assertFalse(voitures.isEmpty());
		//On test que la liste contient bien la classe
		voitures.contains(voiture);
		
	}

}
