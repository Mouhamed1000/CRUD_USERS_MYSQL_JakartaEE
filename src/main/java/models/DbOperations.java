package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Utilisateur;

public class DbOperations {
	
	private static int lastId = 1;
	private static ArrayList<Utilisateur> utilisateurs;
	private Connection cnx;
	
	public static Connection getConnected () throws SQLException 
	{
		
		final String db_url = "jdbc:mysql://localhost:3306/users_jee1";
		final String db_user = "jee_user";
		final String db_password = "jepasse";
		
		//Charger le pilote jdbc
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.printf("Impossible de charger le pilote jdbc", e.getMessage());
			}	
		
		Connection conn = DriverManager.getConnection(db_url, db_user, db_password);
		
		return conn;
	}
	
	public static boolean ajouterUtilisateur(Utilisateur utilisateur) throws SQLException 
	{
		utilisateur.setId(lastId++);
		
		Connection cnx = null;
		String query = "insert into users (nom, prenom, login, password) values (?, ?, ?, ?)";
		try {
				cnx = getConnected();
				PreparedStatement pstm = cnx.prepareStatement(query);
				pstm.setString(1, utilisateur.getNom());
				pstm.setString(2, utilisateur.getPrenom());
				pstm.setString(3, utilisateur.getLogin());
				pstm.setString(4, utilisateur.getPassword());
			
				pstm.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			cnx.close();
		}
		
		return true;		
	}
	
	public static ArrayList<Utilisateur> listerUtilisateur() throws SQLException 
	{
		utilisateurs = new ArrayList<Utilisateur>();

		String sql = "select * from users";
		Connection cnx = null;
		try {
			cnx = getConnected();
			PreparedStatement pstm = cnx.prepareStatement(sql);
			//L'objet ResultSet contient le résultat de la requête SQL
			ResultSet result = pstm.executeQuery();
			
			while (result.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setId(result.getInt("id"));
				utilisateur.setNom(result.getString("nom"));
				utilisateur.setPrenom(result.getString("prenom"));
				utilisateur.setLogin(result.getString("login"));
				utilisateur.setPassword(result.getString("password"));
				utilisateurs.add(utilisateur);
			}
			

			
		}catch (Exception e) {
			
		}
		
		cnx.close();
		return utilisateurs;

	}
	
	public static boolean modifierUtilisateur (Utilisateur user)
	{
		Connection cnx = null;
		String updateQuery = "update users set nom = ?, prenom = ?, login = ?, password = ? where id = ?";
		
		try {
			cnx = getConnected();
			PreparedStatement pstm = cnx.prepareStatement(updateQuery);
			
			for (Utilisateur utilisateur : utilisateurs)
			{
				if (user.getId() == utilisateur.getId())
				{
					pstm.setString(1, user.getNom());
					pstm.setString(2, user.getPrenom());
					pstm.setString(3, user.getLogin());
					pstm.setString(4, user.getPassword());
					pstm.setInt(5, user.getId());
					
					pstm.executeUpdate();
					
					cnx.close();
					return true;
				}
			}
				
		}catch (Exception e) {
			
		}
		
		return false;
	}
	
	public static boolean supprimerUtilisateur (int id)
	{
		Connection cnx = null;
		String deleteQuery = "delete from users where id = ?";
		PreparedStatement pstm = null;
		
		try {
			cnx = getConnected();
			pstm = cnx.prepareStatement(deleteQuery);
			
			pstm.setInt(1, id);
			
			for (Utilisateur utilisateur : utilisateurs)
			{
				if (utilisateur.getId() == id)
				{
					pstm.executeUpdate();
					
					return true;
				}
			}
			
			
		} catch (Exception e) {
			
		}
		
		return false;
	}
	
	public static Utilisateur getUtilisateur (int id)
	{
		for (Utilisateur utilisateur : utilisateurs)
		{
			if (utilisateur.getId() == id)
			{
				return utilisateur;
			}
		}
		
		return null;
	}

}
