package fr.afcepf.al28.TicketsHack.wsPaiement.business.api;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace ="http://toto.fr")
public interface IBusinessPaiement {

	public String verifierCarte(@WebParam(name="numeroCarte")String numeroCarte, @WebParam(name="crypto")String crypto, @WebParam(name="dateExpiration")String dateExpiration);
	
	public String enregistrerPaiement(@WebParam(name="numeroCarte")String numeroCarte, @WebParam(name="crypto")String crypto, @WebParam(name="dateExpiration")String dateExpiration, @WebParam(name="montant")double montant);
}
