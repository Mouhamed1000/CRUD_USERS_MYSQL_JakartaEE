package forms;

import java.sql.SQLException;
import java.util.HashMap;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.http.HttpServletRequest;

public class AddUserForm {
	
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	
	private static final String EMPTY_MESSAGE_ERROR = "Vous devrez remplir ce champ !";

	private HashMap<String , String> erreurs;
	private String statusMessage;
	private boolean status;
	private Utilisateur utilisateur;
	private HttpServletRequest request;
	
	public AddUserForm (HttpServletRequest request)
	{
		this.request = request;
		this.status = false;
		//this.statusMessage = "Echec de l'ajout";
		this.erreurs = new HashMap<String, String>();
	}
	
	public boolean ajouter () throws Exception
	{
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		this.utilisateur = new Utilisateur(nom, prenom, login, password);

		this.validerChamps(CHAMP_NOM, CHAMP_PRENOM, CHAMP_LOGIN, CHAMP_PASSWORD);
		
		if (this.erreurs.isEmpty() && UtilisateurDao.ajouter(this.utilisateur))
		{
			this.status = true;
			//this.statusMessage = "Ajout effectué avec succès";	
		}
		
		return this.status;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public HashMap<String, String> getErreurs() {
		return erreurs;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public boolean isStatus() {
		return status;
	}

	private String getParameter (String parametre)
	{
		String valeur = this.request.getParameter(parametre);
		
		if (valeur == null | valeur.isBlank())
		{
			return null;
		}
		
		return valeur.trim();
	}
	
	private void validerChamps (String... champs)
	{
		for (String champ : champs)
		{
			if (this.getParameter(champ) == null)
			{
				this.erreurs.put(champ, EMPTY_MESSAGE_ERROR);
			}
		}
	}

}
