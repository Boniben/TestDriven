package model;

public class Affectation {
	private Intervenant intervenant;
	private Projet projet;
	private int annee; // 98
	private int semaine; // 1 à 52
	private int tempsPasse; // en minutes

	public Affectation(Intervenant intervenant, Projet projet, int annee, int semaine, int tempsPasse) {
		this.intervenant = intervenant;
		this.projet = projet;
		this.annee = annee;
		this.semaine = semaine;
		this.tempsPasse = tempsPasse;
	}

	public int getTempsPasse() {
		return tempsPasse;
	}

	public Projet getProjet() {
		return projet;
	}

	public Intervenant getIntervenant() {
		return intervenant;
	}

}
