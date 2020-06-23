package model.beans;

import java.util.HashSet;
import java.util.Set;

public class Droit {

	private int id = 0;
	private String nom;
	private Set<Famille> listeFamille = new HashSet<Famille>();
	
	
	public Droit(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}

	public Droit() {
		this(0,"");
	}
	
	
	public boolean equals(Droit droit) {
		return this.id == droit.id;
	}
	
	//Getters 
	
	public int getId() {
		return this.id;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Set<Famille> getListeFamille(){
		return this.listeFamille;
	}
	
	//Setters
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setListeFamille(Set<Famille> liste) {
		this.listeFamille = liste;
	}
	
	
	
	public void ajouterFamille(Famille fam) {
		if(!this.listeFamille.contains(fam))
			this.listeFamille.add(fam);
		
	}
	
	public void supprimerFamille(Famille fam) {
		this.listeFamille.remove(fam);
	}
}
