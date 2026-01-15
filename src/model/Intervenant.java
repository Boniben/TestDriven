package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intervenant {

	private int id;
	private String nom;
	private String prenom;
	private Categorie categorie;
	private List<Projet> projets;
	private List<Affectation> affectations;

	public Intervenant(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public void addProjet(Projet projet) {
		if (this.projets == null) {
			this.projets = new java.util.ArrayList<>();
		}
		this.projets.add(projet);
	}

	public void addAffectation(Affectation affectation) {
		if (this.affectations == null) {
			this.affectations = new java.util.ArrayList<>();
		}
		this.affectations.add(affectation);
	}

	public int getNbProjets() {
		if (this.projets == null) {
			return 0;
		}
		return this.projets.size();
	}

	public int getNbprojetsUnique() {
		if (this.affectations == null) {
			return 0;
		}

		Set<Projet> projetsUniques = new HashSet<>();

		for (Affectation a : affectations) {
			projetsUniques.add(a.getProjet());
		}

		return projetsUniques.size();
	}

	public int getNbtempParProjet(Projet projet) {
		if (this.affectations == null) {
			return 0;
		}

		int totalMinutes = 0;

		for (Affectation a : affectations) {
			if (a.getProjet().equals(projet)) {
				totalMinutes += a.getTempsPasse();
			}
		}
		return totalMinutes;
	}
}
