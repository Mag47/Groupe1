package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

@Entity
public class Conges {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@Column(name="NomSalarie")
	String nom;
	
	LocalDate dateDebut;
	LocalDate dateFin;
	int nbJours;
	String motif;
	
	@Enumerated(EnumType.STRING)
	private TypeConges typeConges;
	
	@Enumerated(EnumType.STRING)
	private Service service;
	
	private LocalDateTime dateCrea=LocalDateTime.now(ZoneId.systemDefault());
	
	@Version
	protected int version;
	
	public Conges()
	{
		
	}
	
	public Conges(String nom, LocalDate dateDebut, LocalDate dateFin, int nbJours, String motif, TypeConges typeConges,
			Service service) {
		super();
		this.nom = nom;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbJours = nbJours;
		this.motif = motif;
		this.typeConges = typeConges;
		this.service = service;
		//this.dateCrea = dateCrea;
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
