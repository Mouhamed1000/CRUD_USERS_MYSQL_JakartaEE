package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Utilisateur;
import models.DbOperations;

public class UtilisateurDao {
	
	private static ArrayList<Utilisateur> utilisateurs;
	private static Connection cnx;
	private static boolean actionAjout, actionModif, actionSuppr;
	private static Utilisateur utilisateur;
	
	DbOperations dbOps = new DbOperations();
	
	public static Connection getConnected () throws SQLException {
		
		cnx = DbOperations.getConnected();
		return cnx;
		
	}
	
	public static boolean ajouter(Utilisateur utilisateur) throws SQLException {
		
		actionAjout = DbOperations.ajouterUtilisateur(utilisateur);
		return actionAjout;
		
	}
	
	public static ArrayList<Utilisateur> lister() throws SQLException {

		utilisateurs = DbOperations.listerUtilisateur();
		return utilisateurs;
		
	}
	
	public static boolean modifier (Utilisateur user)
	{
		
		actionModif = DbOperations.modifierUtilisateur(user);
		return actionModif;
		
	}
	
	public static boolean supprimer (int id)
	{
		
		actionSuppr = DbOperations.supprimerUtilisateur(id);
		return actionSuppr;
		
	}
	
	public static Utilisateur get (int id)
	{
		
		utilisateur = DbOperations.getUtilisateur(id);
		return utilisateur;
		
	}	
	
}
