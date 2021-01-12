package model;

public enum TypeConges {
	
	congesPayes("Conges payes"), congesSansSolde("Conges sans solde"), absenceAutorisee("Absence autorisee"), absenceJustifiee("Absence justifiee");
	
private String libelle;

private TypeConges(String libelle) 
	{
	this.libelle=libelle;
	}

public String getLibelle() {
	return libelle;
}


}
