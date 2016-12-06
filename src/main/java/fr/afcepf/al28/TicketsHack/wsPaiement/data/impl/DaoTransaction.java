package fr.afcepf.al28.TicketsHack.wsPaiement.data.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.TicketsHack.wsPaiement.data.api.IDaoTransaction;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Transaction;

@Service
@Transactional
public class DaoTransaction implements IDaoTransaction {

	private SessionFactory sf;
	@Autowired
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void enregistrerTransaction(Transaction t) {

		sf.getCurrentSession().persist(t);
		
	}

	
}
