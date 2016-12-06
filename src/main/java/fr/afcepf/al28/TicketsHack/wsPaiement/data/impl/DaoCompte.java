package fr.afcepf.al28.TicketsHack.wsPaiement.data.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.TicketsHack.wsPaiement.data.api.IDaoCompte;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Carte;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Compte;

@Service
@Transactional
public class DaoCompte implements IDaoCompte {

	private SessionFactory sf;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public boolean debiterCompte(Compte compte, double montant) {
		
		if(compte.getSolde() > montant) {
		compte.setSolde(compte.getSolde() - montant);
		sf.getCurrentSession().merge(compte);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Compte trouverCompte(Carte carte) {

		Compte compte = new Compte();
		
		compte = (Compte)sf.getCurrentSession().createQuery("SELECT c.compte FROM Carte c"
				+ " WHERE c.numeroCarte = :numeroCarte")
				.setParameter("numeroCarte", carte.getNumeroCarte()).uniqueResult();
		
		return compte;
	}

}
