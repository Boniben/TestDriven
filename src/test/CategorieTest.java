package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Categorie;
import model.Intervenant;

class CategorieTest {

	private Categorie categorie;
	private Intervenant i1;
	private Intervenant i2;

	@BeforeEach
	void setUp() {
		categorie = new Categorie(1, "Développeur java");
		i1 = new Intervenant(1, "Dupont", "Charles");
		i2 = new Intervenant(1, "Bouamsi", "Lola");
		categorie.addIntervenant(i1);
		categorie.addIntervenant(i2);
	}

	@Test
	void testGetNbIntervenantsAvecPlusieursIntervenants() {
		assertEquals(2, categorie.getNbIntervenants());
	}
}
