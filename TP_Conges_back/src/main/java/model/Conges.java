package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Conges {
	
	String nom;
	LocalDate dateDebut;
	LocalDate dateFin;
	int nbJours;
	String motif;
	private TypeConges typeConges;
	private Service service;
	private LocalDateTime dateCrea;
	
	public Conges()
	{
		
	};
	public Conges(String nom, LocalDate dateDebut, LocalDate dateFin, int nbJours, String motif, TypeConges typeConges,
			Service service, LocalDateTime dateCrea) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbJours = nbJours;
		this.motif = motif;
		this.typeConges = typeConges;
		this.service = service;
		this.dateCrea = dateCrea;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public int getNbJours() {
		return nbJours;
	}
	public void setNbJours(int nbJours) {
		this.nbJours = nbJours;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public TypeConges getTypeConges() {
		return typeConges;
	}
	public void setTypeConges(TypeConges typeConges) {
		this.typeConges = typeConges;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public LocalDateTime getDateCrea() {
		return dateCrea;
	}
	public void setDateCrea(LocalDateTime dateCrea) {
		this.dateCrea = dateCrea;
	}
	
	
	

}
