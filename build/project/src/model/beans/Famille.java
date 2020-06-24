package model.beans;

import java.util.HashSet;
import java.util.Set;

public class Famille {
	//Attributs
	private int id = 0;
	private String nom;
	private int droitId;
	public Set<Tache> listeTache = new HashSet<Tache>();
	
	//Constructeur
	public Famille(int id, String nom, int droit) {
		this.id = id ;
		this.nom = nom;
		this.droitId = droit;
	}
	
	public Famille()
	{
		this (0,"",0);
	}
	
	public boolean equals(Famille fam) {
		return this.id == fam.id;
	}
	//Accesseurs
	public int getId() {
		return this.id;
	}
	public String getNom() {
		return this.nom;
	}
	public int getdroit() {
		return this.droitId;
	}

	public Set<Tache> getListeTache(){
		return this.listeTache;
	}
	//Mutateurs
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setDroit(int droit) {
		this.droitId = droit;
	}
	
	public void setListeTache(Set<Tache> liste) {
		this.listeTache = liste;
	}
	
	
	public void ajouterTache(Tache tache) {
		if(!this.listeTache.contains(tache))
			this.listeTache.add(tache);
	
	}
	
	public void supprimerTache(Tache tache) {
		this.listeTache.remove(tache);
	}
}
