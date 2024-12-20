package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class ListUser extends HttpServlet
{
	private static final String VUE_LIST_USER = "/WEB-INF/listerUtilisateur.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
		try {
			utilisateurs = UtilisateurDao.lister();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("utilisateurs", utilisateurs);
		getServletContext().getRequestDispatcher(VUE_LIST_USER).forward(request, response);
	}
}