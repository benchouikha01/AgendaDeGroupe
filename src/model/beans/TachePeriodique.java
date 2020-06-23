package model.beans;

import java.sql.Date;
import java.sql.Time;

public class TachePeriodique extends Tache {

	private Date dateFinale;
	private double frequence;
	public TachePeriodique(int id, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin, String titre) {
		super(id,titre, dateDebut, dateFin, horaireDebut, horaireFin);
	}
	
	public TachePeriodique(int id, String titre, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin, double frequence, Date dateFinale) {
		super(id, titre, dateDebut, dateFin, horaireDebut, horaireFin);
		this.frequence = frequence;
		this.dateFinale = dateFinale;
	}
	
	public TachePeriodique(int id, String titre, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin, Time delaiAlarme,double frequence, Date dateFinale) {
		super(id, titre, dateDebut, dateFin, horaireDebut, horaireFin, delaiAlarme);
		this.frequence = frequence;
		this.dateFinale = dateFinale;
	}
	
	public TachePeriodique(int id, String titre, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin, Time delaiAlarme, String desc,double frequence, Date dateFinale) {
		super(id, titre, dateDebut, dateFin, horaireDebut, horaireFin, delaiAlarme, desc);
		this.frequence = frequence;
		this.dateFinale = dateFinale;
	}
	
	public TachePeriodique(int id, String titre, Date dateDebut, Date dateFin, Time horaireDebut, Time horaireFin, String desc,double frequence, Date dateFinale) {
		super(id, titre, dateDebut, dateFin, horaireDebut, horaireFin, desc);
		this.frequence = frequence;
		this.dateFinale = dateFinale;
	}
	
	
	public TachePeriodique() {
		super();
	}
	
	//Accesseurs
	public Date getDateFinale() {
		return this.dateFinale;
	}
	
	public double getFrequence() {
		return this.frequence;
	}
	
	//Mutateurs
	
	public void setDateFinale(Date date) {
		this.dateFinale = date;
	}
	
	public void setFrequence(double freq) {
		this.frequence = freq;
	}
	
}
