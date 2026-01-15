package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Affectation;
import model.Prestataire;
import model.Projet;
import model.Salarie;
import model.Societe;

class ProjetHeritageTest {

	private Projet p1;
	private Projet p2;
	private Salarie s1;
	private Prestataire presforfait;
	private Prestataire presMinute;
	private Affectation a1;
	private Affectation a2;
	private Affectation a3;
	private Affectation a4;
	private Affectation a5;
	private Affectation a6;
	private Societe soc1;

	@BeforeEach
	void setUp() {
		// creation d'un projet avec des dates utilisant le gros constructeur
		p1 = new Projet(1, "P1", 100, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1), LocalDate.of(2024, 1, 20),
				LocalDate.of(2024, 2, 5));
		p2 = new Projet(1, "P2", 100, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1), LocalDate.of(2024, 1, 20),
				LocalDate.of(2024, 2, 5));

		soc1 = new Societe(1, "Tech Solutions", 2);

		s1 = new Salarie(1, "Doe", "John", LocalDate.of(2020, 1, 1), 3);
		presforfait = new Prestataire(2, "Smith", "Jane", true, 0);
		presMinute = new Prestataire(3, "Brown", "Charlie", false, 1);

		presforfait.addSociete(soc1);

		a1 = new Affectation(s1, p1, 50, 1, 100);
		a2 = new Affectation(presforfait, p2, 50, 3, 200);
		a3 = new Affectation(presMinute, p1, 50, 10, 2000);
		a4 = new Affectation(presforfait, p2, 50, 15, 1000);
		a5 = new Affectation(presMinute, p1, 50, 20, 500);
		a6 = new Affectation(presMinute, p2, 50, 5, 300);

		p1.addAffectation(a1);
		s1.addAffectation(a1);

		p2.addAffectation(a2);
		presforfait.addAffectation(a2);

		p1.addAffectation(a3);
		presMinute.addAffectation(a3);

		p2.addAffectation(a4);
		presforfait.addAffectation(a4);

		p1.addAffectation(a5);
		presMinute.addAffectation(a5);

		p2.addAffectation(a6);
		presMinute.addAffectation(a6);
	}

	@Test
	void calculCoutParProjet() {
		assertEquals(3000, s1.calculerCoutParProjet(p1));
		assertEquals(0, s1.calculerCoutParProjet(p2));

		assertEquals(2400, presforfait.calculerCoutParProjet(p2));
		assertEquals(0, presforfait.calculerCoutParProjet(p1));

		assertEquals(2500, presMinute.calculerCoutParProjet(p1));
		assertEquals(300, presMinute.calculerCoutParProjet(p2));

	}

}
