package model;

public class Prestataire extends Intervenant {

	private boolean forfait;
	private int coutMinute;
	private Societe societe;

	public Prestataire() {
		super();
	}

	public Prestataire(int id, String nom, String prenom, boolean forfait, int coutMinute) {
		super(id, nom, prenom);
		this.forfait = forfait;
		this.coutMinute = coutMinute;
	}

	public void addSociete(Societe societe) {
		this.societe = societe;
	}

	public int calculerCoutParProjet(Projet projet) {
		if (forfait == true) {
			return (societe.getCoutMinuteSociete() * this.getNbtempParProjet(projet));
		} else {
			return (this.getNbtempParProjet(projet) * this.coutMinute);
		}

	}

}
