package model.beans;

import java.util.HashSet;
import java.util.Set;


public class Utilisateur {
	//Initialisation des attributs
	private int id = 0;
	private String nom;
	private String prenom;
	private String adresseMail;
	private String password;
	private Set<Conge> listeCongeARepondre = new HashSet<Conge>();
	private Set<Reunion> listeReunionOrganiser = new HashSet<Reunion>();
	//Constructeur


	public Utilisateur(int id, String adresseMail, String nom, String prenom, String password) {
		this.id = id;
		this.adresseMail = adresseMail;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;

	}
	
	public Utilisateur( String adresseMail, String nom, String prenom, String password) {
		this.adresseMail = adresseMail;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;

	}

	public Utilisateur() {this(0,"","","","");}
	
	public boolean equals(Utilisateur util) {
		return this.id == util.id;
	}
	// Accesseurs (Getters)
	public int getId() {
		return this.id;
	}
	public String getAdresseMail() {
		return this.adresseMail;
	}
	public String getNom(){
		return this.nom;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public Set<Conge> getListeCongeARepondre(){
		return this.listeCongeARepondre;
	}
	
	public Set<Reunion> getListeReunionOrganiser(){
		return this.listeReunionOrganiser;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	//Mutateurs (Setters)
	public void setId(int id) {
		this.id = id;
	}
	public void setAdresse_mail(String adresse_mail) {
		this.adresseMail = adresse_mail;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setListeCongeARepondre(Set<Conge> liste) {
		this.listeCongeARepondre = liste;
	}
	
	public void setListeReunionOrganiser(Set<Reunion> liste) {
		this.listeReunionOrganiser = liste;
	}

	public void ajouterConge(Conge conge) {
		if(!this.listeCongeARepondre.contains(conge))
			this.listeCongeARepondre.add(conge);
	}
	
	public void supprimerConge(Conge conge) {
		this.listeCongeARepondre.remove(conge);
	}
	
	public void ajouterReunionOrganiser(Reunion reunion) {
		if(!this.listeReunionOrganiser.contains(reunion))
			this.listeReunionOrganiser.add(reunion);
	}
	
	public void supprimerReunionOrganiser(Reunion reunion) {
		this.listeReunionOrganiser.remove(reunion);
	}

	
}
