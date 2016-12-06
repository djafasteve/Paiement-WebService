package fr.afcepf.al28.TicketsHack.wsPaiement.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="carte")
public class Carte {

	@Id
	@Column(name="numeroCarte")
	private String numeroCarte;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="dateExpiration")
	private String dateExpiration;
	
	@Column(name="crypto")
	private String crypto;
	
	@ManyToOne
	@JoinColumn(name = "numeroCompte")
	private Compte compte;

	public Carte() {
		super();
	}

	public Carte(String numeroCarte, String nom, String prenom, String dateExpiration, String crypto, Compte compte) {
		super();
		this.numeroCarte = numeroCarte;
		this.nom = nom;
		this.prenom = prenom;
		this.dateExpiration = dateExpiration;
		this.crypto = crypto;
		this.compte = compte;
	}

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	public String getCrypto() {
		return crypto;
	}

	public void setCrypto(String crypto) {
		this.crypto = crypto;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
}
