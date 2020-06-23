package model.beans;
public class Groupe {
	//Attributs
	private int id = 0;
	private String nom;
	
	//Constructeur
	public Groupe(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public Groupe( String nom) {
		this.nom = nom;
	}
	
	public Groupe() {
		this(0, "");
		
	}
	
	public boolean equals(Groupe grp) {
		return this.id == grp.id;
	}
	//Accesseurs
	public int getId() {
		return this.id;
	}
	public String getNom() {
		return this.nom;
	}


	
	//Mutateurs
	public void setId(int id) {
		this.id = id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
