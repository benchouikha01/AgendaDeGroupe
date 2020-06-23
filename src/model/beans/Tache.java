package model.beans;
import java.sql.Date;
import java.sql.Time;

public class Tache {
	//Attributs
	private int id = 0;
	private Date dateDebut;
	private Date dateFin;
	private Time horaireDebut;
	private Time horaireFin;
	private String titre;
	private String description;
	private Time delaiAlarme;
	private int familleId;

	//Constructeur
	public Tache(int id, String titre, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin) {
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.horaireDebut = horaireDebut;
		this.horaireFin = horaireFin;
		this.titre = titre;
	}
	
	public Tache(int id, String titre, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin, Time delaiAlarme) {
		this(id, titre, dateDebut, dateFin, horaireDebut, horaireFin);
		this.delaiAlarme = delaiAlarme;
	}
	
	public Tache(int id, String titre, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin, Time delaiAlarme, String desc) {
		this(id, titre, dateDebut, dateFin, horaireDebut, horaireFin, delaiAlarme);
		this.description = desc;
	}
	
	public Tache(int id, String titre, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin, String desc) {
		this(id, titre, dateDebut, dateFin, horaireDebut, horaireFin);
		this.description = desc;
	}
	public Tache() {}
	
	
	public boolean equals(Tache tache) {
		return this.id == id;
	}
	//Accesseurs
	public int getId() {
		return this.id;
	}
	public int getFamilleId() {
		return this.familleId;
	}
	public Date getdateDebut() {
		return this.dateDebut;
	}
	public Date getdateFin() {
		return this.dateFin;
	}
	public Time gethoraireDebut() {
		return this.horaireDebut;
	}
	public Time gethoraireFin() {
		return this.horaireFin;
	}
	public String getTitre() {
		return this.titre;
	}
	public String getDescription() {
		return this.description;
	}
	public Time getdelaiAlarme() {
		return this.delaiAlarme;
	}
	
	//Mutateurs
	public void setId(int id) {
		this.id = id;
	}
	public void setFamilleId(int id) {
		this.familleId = id;
	}
	public void setdateDebut(Date date) {
		this.dateDebut = dateDebut;
	}
	public void setdateFin(Date date) {
		this.dateFin = dateFin;
	}
	public void sethoraireDebut(Time time) {
		this.horaireDebut = time;
	}
	public void sethoraireFin(Time time) {
		this.horaireFin = time;
	}
	public void setdelaiAlarme(Time delai) {
		this.delaiAlarme = delaiAlarme;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
