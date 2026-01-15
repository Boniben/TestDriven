package test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Affectation;
import model.Intervenant;
import model.Projet;

class ProjetTest {
	private Projet P1;
	private Projet P2;
	private Intervenant i1;
	private Intervenant i2;
	private Affectation a1;
	private Affectation a2;
	private Affectation a3;
	private Affectation a4;
	private Affectation a5;

	@BeforeEach
	void setUp() {
		// creation d'un projet avec des dates utilisant le gros constructeur
		P1 = new Projet(1, "P1", 100, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1), LocalDate.of(2024, 1, 20),
				LocalDate.of(2024, 2, 5));
		P2 = new Projet(1, "P2", 100, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1), LocalDate.of(2024, 1, 20),
				LocalDate.of(2024, 2, 5));
		i1 = new Intervenant(1, "Doe", "John");
		i2 = new Intervenant(2, "Smith", "Jane");

		a1 = new Affectation(i1, P1, 50, 1, 100);
		a2 = new Affectation(i2, P2, 50, 3, 200);
		a3 = new Affectation(i2, P1, 50, 10, 2000);
		a4 = new Affectation(i1, P2, 50, 15, 1000);
		a5 = new Affectation(i1, P1, 50, 20, 500);

		P1.addAffectation(a1);// a1 = i1-P1
		i1.addAffectation(a1);
		P2.addAffectation(a2);// a2 = i2-P2
		i2.addAffectation(a2);
		P1.addAffectation(a3);// a3 = i2-P1
		i2.addAffectation(a3);
		P2.addAffectation(a4);// a4 = i1-P2
		i1.addAffectation(a4);
		P1.addAffectation(a5);// a5 = i1-P1 (doublon)
		i1.addAffectation(a5);

	}

	@Test
	void testNbdureePrevue() {
		assertEquals(19, P1.getdureePrevue());
		assertFalse(P1.getdureePrevue() == 20);
		assertEquals(16, P1.getNbjoursRetard());
		assertFalse(P1.getNbjoursRetard() == 15);

		// nombre de projets uniques par intervenant
		assertEquals(2, i1.getNbprojetsUnique());
		assertEquals(2, i2.getNbprojetsUnique());

		// heure passé en minute par projet pour 1 intervenant
		assertEquals(600, i1.getNbtempParProjet(P1));
		assertFalse(i1.getNbtempParProjet(P1) == 500);
	}

}
