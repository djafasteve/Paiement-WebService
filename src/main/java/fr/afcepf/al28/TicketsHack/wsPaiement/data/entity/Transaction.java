package fr.afcepf.al28.TicketsHack.wsPaiement.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="transaction")
	private int idTransaction;

	@Column(name="carte")
	private String carte;
	
	@Column(name="montant")
	private Double montant;
	
	@Column(name="date")
	private Date date;

	public Transaction() {
		super();
		this.date = new Date();
	}

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public String getCarte() {
		return carte;
	}

	public void setCarte(String carte) {
		this.carte = carte;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
