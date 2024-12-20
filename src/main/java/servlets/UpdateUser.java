package servlets;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateUser extends HttpServlet{
	
	private static final String VUE_UPDATE_USER = "/WEB-INF/modifierUtilisateur.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Utilisateur utilisateur = null;
		
		if (id.matches("[0-9]+"))
		{
			if ( ( utilisateur = UtilisateurDao.get(Integer.parseInt(id)) ) != null )
			{
				request.setAttribute("utilisateur", utilisateur);
				getServletContext().getRequestDispatcher(VUE_UPDATE_USER).forward(request, response);
				return;	
			}
		}
	
		response.sendRedirect("list");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		Utilisateur utilisateur = new Utilisateur(Integer.parseInt(id), nom, prenom, login, password);
		UtilisateurDao.modifier(utilisateur);
		
		response.sendRedirect("list");
	}

}
