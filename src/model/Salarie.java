package model;

import java.time.LocalDate;

public class Salarie extends Intervenant {
	private LocalDate dateEmbauche;
	private int echelon;

	public Salarie() {
		super();
	}

	public Salarie(int id, String nom, String prenom, LocalDate dateEmbauche, int echelon) {
		super(id, nom, prenom);
		this.dateEmbauche = dateEmbauche;
		this.echelon = echelon;
	}

	public int calculerCoutParProjet(Projet projet) {
		return (this.getNbtempParProjet(projet) * (this.echelon * 10));

	}

}
