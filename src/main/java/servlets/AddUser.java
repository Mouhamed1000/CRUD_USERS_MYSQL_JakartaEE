package servlets;

import java.io.IOException;
import java.sql.SQLException;

import beans.Utilisateur;
import dao.UtilisateurDao;
import forms.AddUserForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddUser extends HttpServlet{
	
	private static final String VUE_ADD_USER = "/WEB-INF/ajouterUtilisateur.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE_ADD_USER).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddUserForm form = new AddUserForm(request);
		
		try {
			if (form.ajouter())
			{
				response.sendRedirect(request.getContextPath() + "/list");
			}
			else
			{
				request.setAttribute("status", form.isStatus());
				//request.setAttribute("statusMessage", form.getStatusMessage());
				request.setAttribute("erreurs", form.getErreurs());
				request.setAttribute("utilisateur", form.getUtilisateur());
				
				getServletContext().getRequestDispatcher(VUE_ADD_USER).forward(request, response);
			}
		} catch (Exception e) {
		}
		
	}

}
