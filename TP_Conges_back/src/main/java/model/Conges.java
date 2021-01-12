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
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class Conges {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Salarie salarie;
	
	@Column(columnDefinition = "DATE")
	private LocalDate dateDebut;
	@Column(columnDefinition = "DATE")
	private LocalDate dateFin;
	
	private String motif;
	
	@Enumerated(EnumType.STRING)
	private TypeConges typeConges;
	
	
	@Column(columnDefinition = "DATETIME")
	private LocalDateTime dateCrea=LocalDateTime.now(ZoneId.systemDefault());
	
	@Version
	private int version;
	
	public Conges()
	{
		
	}
	
	public Conges(LocalDate dateDebut, LocalDate dateFin, String motif, TypeConges typeConges,
			Salarie salarie) {
	
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	
		this.motif = motif;
		this.typeConges = typeConges;
		
		this.salarie=salarie;
		//this.dateCrea = dateCrea;
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
	
	public LocalDateTime getDateCrea() {
		return dateCrea;
	}
	public void setDateCrea(LocalDateTime dateCrea) {
		this.dateCrea = dateCrea;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Salarie getSalarie() {
		return salarie;
	}

	public void setSalarie(Salarie salarie) {
		this.salarie = salarie;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	

}
