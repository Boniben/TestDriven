package model;

public class Societe {

	private int id;
	private String nom;
	private int coutMinute;

	public Societe(int id, String nom, int coutMinute) {
		this.id = id;
		this.nom = nom;
		this.coutMinute = coutMinute;
	}

	public int getCoutMinuteSociete() {
		return coutMinute;
	}
}
