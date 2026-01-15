package model;

public class Prestataire extends Intervenant {

	private boolean forfait;
	private int coutMinute;

	public Prestataire() {
		super();
	}

	public Prestataire(int id, String nom, String prenom, boolean forfait, int coutMinute) {
		super(id, nom, prenom);
		this.forfait = forfait;
		this.coutMinute = coutMinute;
	}

}
