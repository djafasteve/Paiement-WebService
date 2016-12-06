package fr.afcepf.al28.TicketsHack.wsPaiement.data.api;

import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Carte;
import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Compte;

public interface IDaoCompte {

	public boolean debiterCompte(Compte compte, double montant);
	public Compte trouverCompte(Carte carte);
}
