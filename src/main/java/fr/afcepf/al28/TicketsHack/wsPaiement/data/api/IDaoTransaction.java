package fr.afcepf.al28.TicketsHack.wsPaiement.data.api;

import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Transaction;

public interface IDaoTransaction {

	public void enregistrerTransaction(Transaction t);
}
