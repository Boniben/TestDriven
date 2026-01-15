package model;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	private int id;
	private String libelle;
	private List<Intervenant> intervenants;

	public Categorie(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public void addIntervenant(Intervenant intervenant) {
		if (intervenants == null) {
			intervenants = new ArrayList<>();
		}
		intervenants.add(intervenant);
	}

	public int getNbIntervenants() {
		if (intervenants == null) {
			return 0;
		}
		return intervenants.size();
	}

}
