package fr.afcepf.al28.TicketsHack.wsPaiement.data.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {

	@Id
	@Column(name="numeroCompte")
	private int numeroCompte;
	
	@Column(name="solde")
	private double solde;
		
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	
	@OneToMany(mappedBy = "compte")
	private List<Carte> listeCartes;

	public Compte() {
		super();
	}

	public Compte(int numeroCompte, double solde, Client client) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.client = client;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
