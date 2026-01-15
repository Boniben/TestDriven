package model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Projet {
	private int id;
	private String nom;
	private int nbjoursPrevus;
	private LocalDate dateDebutPrevue;
	private LocalDate dateDebutEffective;
	private LocalDate dateFinPrevue;
	private LocalDate dateFinEffective;
	private Intervenant chefDeProjet;
	private List<Affectation> affectations;

	public Projet(int id, String nom, int nbjoursPrevus, LocalDate dateDebutPrevue, LocalDate dateDebutEffective,
			LocalDate dateFinPrevue, LocalDate dateFinEffective) {
		this.id = id;
		this.nom = nom;
		this.nbjoursPrevus = nbjoursPrevus;
		this.dateDebutPrevue = dateDebutPrevue;
		this.dateDebutEffective = dateDebutEffective;
		this.dateFinPrevue = dateFinPrevue;
		this.dateFinEffective = dateFinEffective;
	}

	public Projet(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public void addAffectation(Affectation affectation) {
		if (this.affectations == null) {
			this.affectations = new java.util.ArrayList<>();
		}
		this.affectations.add(affectation);
	}

	public int getdureePrevue() {
		if (dateDebutPrevue != null && dateFinPrevue != null) {
			return (int) java.time.temporal.ChronoUnit.DAYS.between(dateDebutPrevue, dateFinPrevue);
		} else {
			return 0;
		}
	}

	public int getNbjoursRetard() {
		if (dateFinEffective != null && dateFinPrevue != null) {
			return (int) java.time.temporal.ChronoUnit.DAYS.between(dateFinPrevue, dateFinEffective);
		} else {
			return 0;
		}
	}

	public int getNbIntervenantsParProjet() {
		if (this.affectations == null) {
			return 0;
		}
		Set<Intervenant> intervenantsUniques = new HashSet<>();

		for (Affectation a : affectations) {
			intervenantsUniques.add(a.getIntervenant());
		}

		return intervenantsUniques.size();
	}

	public int getNbtempTotalParProjet() {
		if (this.affectations == null) {
			return 0;
		}
		int totalTemps = 0;

		for (Affectation a : affectations) {
			totalTemps += a.getTempsPasse();
		}

		return totalTemps;
	}

	public int getNbTempTotalParProjetPourIntervenant(Intervenant intervenant) {
		if (this.affectations == null) {
			return 0;
		}
		int totalTemps = 0;

		for (Affectation a : affectations) {
			if (a.getIntervenant().equals(intervenant)) {
				totalTemps += a.getTempsPasse();
			}
		}

		return totalTemps;
	}

}
