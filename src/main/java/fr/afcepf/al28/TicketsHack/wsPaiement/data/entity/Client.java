package fr.afcepf.al28.TicketsHack.wsPaiement.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	@Id
	@Column(name="idClient")
	private int idClient;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@OneToMany(mappedBy = "client")
	private List<Compte> comptes;

	public Client() {
		super();
	}

	public Client(int idClient, String nom, String prenom) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	
	
}
