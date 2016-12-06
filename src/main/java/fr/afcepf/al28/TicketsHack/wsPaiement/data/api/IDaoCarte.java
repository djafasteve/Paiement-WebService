package fr.afcepf.al28.TicketsHack.wsPaiement.data.api;

import fr.afcepf.al28.TicketsHack.wsPaiement.data.entity.Carte;

public interface IDaoCarte {

	public Carte trouverCarte(String numeroCarte, String crypto, String dateExpiration);
	public boolean verifierCarte(String numeroCarte, String crypto, String dateExpiration);
}
