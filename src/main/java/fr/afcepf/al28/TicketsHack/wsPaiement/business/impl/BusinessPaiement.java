package fr.afcepf.al28.TicketsHack.wsPaiement.business.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al28.TicketsHack.wsPaiement.business.api.IBusinessPaiement;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.api.IDaoCarte;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.api.IDaoCompte;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.api.IDaoTransaction;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Carte;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Compte;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Transaction;

@WebService(endpointInterface="fr.afcepf.al28.TicketsHack.wsPaiement.business.api.IBusinessPaiement",
targetNamespace ="http://toto.fr")
public class BusinessPaiement implements IBusinessPaiement {

	IDaoCarte daoCarte;

	IDaoCompte daoCompte;

	IDaoTransaction daoTransaction;

	@Autowired
	public void setDaoCarte(IDaoCarte daoCarte) {
		this.daoCarte = daoCarte;
	}
	@Autowired
	public void setDaoCompte(IDaoCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	@Autowired
	public void setDaoTransaction(IDaoTransaction daoTransaction) {
		this.daoTransaction = daoTransaction;
	}

	@Override
	public String verifierCarte(String numeroCarte, String crypto, String dateExpiration) {
		String retour = "";
		if (daoCarte.verifierCarte(numeroCarte, crypto, dateExpiration) == true)
			retour = "valider";
		else
			retour = "nonvalider";
		return retour;
	}

	@Override
	public String enregistrerPaiement(String numeroCarte, String crypto, String dateExpiration, double montant) {

		String retour = "";
		Carte carte = new Carte();
		Compte compte = new Compte();
System.out.println("******carte" + carte);
System.out.println("******carte" + carte.getNumeroCarte());
		carte = daoCarte.trouverCarte(numeroCarte, crypto, dateExpiration);
		compte = daoCompte.trouverCompte(carte);

		if(daoCompte.debiterCompte(compte, montant)) {
			Transaction t = new Transaction();
			t.setCarte(carte.getNumeroCarte());
			t.setMontant(montant);
			daoTransaction.enregistrerTransaction(t);
			retour = "payer";


		} else {		
			retour = "nonpayer";

		}	

		return retour;
	}

}
