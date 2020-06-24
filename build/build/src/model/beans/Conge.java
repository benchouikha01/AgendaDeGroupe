package model.beans;

import java.sql.Date;
import java.time.LocalDate;

public class Conge {

	private int id = 0;
	private int demandeurId;
	private int repondeurId;
	private String motifRefus;
	private boolean reponse = false;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String motifDemande;
	
	
	
	public Conge(int id, int demandeurId, LocalDate dateDebut, LocalDate dateFin) {
		this.id = id;
		this.demandeurId = demandeurId;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Conge(int id, int demandeurId, LocalDate dateDebut, LocalDate dateFin, String motifDemande) {
		this(id, demandeurId, dateDebut, dateFin);
		this.motifDemande = motifDemande;
	}
	
	public Conge() {}
	
	public boolean equals(Conge cong) {
		return this.id == cong.id;
	}
	//Accesseurs
	public int getId() {
		return this.id;
	}
	
	public LocalDate getDateDebut() {
		return this.dateDebut;
	}
	
	public LocalDate getDateFin() {
		return this.dateFin;
	}
	
	
	public boolean getReponse() {
		return this.reponse;
	}
	public String getMotifRefus() {
		return this.motifRefus;
	}
	
	public String getMotifDemande() {
		return this.motifDemande;
	}
	
	public int getRepondeurId() {
		return this.repondeurId;
	}
	
	public int getDemandeurId() {
		return this.demandeurId;
	}
	
	//Mutateurs
	public void setId(int id) {
		this.id = id;
	}
	

	public void setMotifRefus(String motif) {
		this.motifRefus = motif;
	}
	
	public void setDemandeurId(int id) {
		this.demandeurId = id;
	}
	
	public void setRepondeurId(int id) {
		this.repondeurId = id;
	}
	
	public void setDateDebut(LocalDate date) {
		this.dateDebut = date;
	}
	
	public void setDateFin(LocalDate date) {
		this.dateFin = date;
	}
	
	public void setMotifDemande(String motif) {
		this.motifDemande = motif;
	}
}
