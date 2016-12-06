package fr.afcepf.al28.TicketsHack.wsPaiement.data.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.TicketsHack.wsPaiement.data.api.IDaoCarte;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Carte;

@Service
@Transactional
public class DaoCarte implements IDaoCarte {

	private SessionFactory sf;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public boolean verifierCarte(String numeroCarte, String crypto, String dateExpiration) {

		Carte carte = new Carte();
		
		carte = (Carte)sf.getCurrentSession().createQuery("SELECT c FROM Carte c"
				+ " WHERE c.numeroCarte = :numeroCarte"
				+ " AND c.crypto = :crypto"
				+ " AND c.dateExpiration = :dateExpiration")
		.setParameter("numeroCarte", numeroCarte)
		.setParameter("crypto", crypto)
		.setParameter("dateExpiration", dateExpiration)
		.uniqueResult();
		
		if(carte != null)		
			return true;
		else
			return false;
	}

	@Override
	public Carte trouverCarte(String numeroCarte, String crypto, String dateExpiration) {
		
		Carte carte = new Carte();
		
		carte = (Carte)sf.getCurrentSession().createQuery("SELECT c FROM Carte c"
				+ " WHERE c.numeroCarte = :numeroCarte"
				+ " AND c.crypto = :crypto"
				+ " AND c.dateExpiration = :dateExpiration")
		.setParameter("numeroCarte", numeroCarte)
		.setParameter("crypto", crypto)
		.setParameter("dateExpiration", dateExpiration).uniqueResult();
		
		return carte;
	}
	

}
