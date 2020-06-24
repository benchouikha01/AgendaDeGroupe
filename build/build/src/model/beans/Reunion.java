package model.beans;
import java.sql.Date;
import java.sql.Time;

public class Reunion {
	//Attributs
	private int id = 0;
	private Date date;
	private Time horaireDebut;
	private Time horaireFin;
	private String description;
	private int organisateurId;
	//Constructeur
	public Reunion(int id, Date date, Time deb, Time fin, String desc, int orgId) {
		this(id, date, deb, fin, orgId);
		this.description = desc;
	}
	
	
	public Reunion(int id, Date date, Time deb, Time fin, int orgId) {
		this.id = id;
		this.date = date;
		this.horaireDebut = deb;
		this.horaireFin = fin;
		this.organisateurId = orgId;
	}
	
	public Reunion() {}
	
	public boolean equals(Reunion reu) {
		return this.id == reu.id;
	}
	//Accesseurs
	public int getId() {
		return this.id;
	}
	public int getOrganisateurId() {
		return this.organisateurId;
	}
	public Date getDate() {
		return this.date;
	}
	public Time gethoraireDebut() {
		return this.horaireDebut;
	}
	public Time gethoraireFin() {
		return this.horaireFin;
	}
	public String getDescription() {
		return this.description;
	}
	
	//Mutateurs
	public void setId(int id) {
		this.id = id;
	}
	
	public void setOrganisateurId(int id) {
		this.organisateurId = id;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public void sethoraireDebut(Time time) {
		this.horaireDebut = time;
	}
	public void sethoraireFin(Time time) {
		this.horaireFin = time;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
}
