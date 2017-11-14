package controlleur.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlleur.Facade;


/**
 * 
 * Servlet de redirection pour les gladiateurs
 * Il permet d'afficher la page de mofication ou de creation selon la demande
 * 
 * Il recoit les informations suivantes :
 * - La partie (facade)
 * 
 * Il renvoie les informations suivantes :
 * - La partie (facade) mise a jour
 * - L'id de du gladiateur concerné
 * 
 * @author Stephane Camusso
 *
 */
public class EditionGladiateurServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		req.setAttribute("contexteXML", partie);
		String nom = (String) req.getParameter("nom");
		
		if (!req.getParameter("idGladiateur").equals("null")) {
			int idGladiateur = Integer.parseInt(req.getParameter("idGladiateur"));
			req.setAttribute("idGladiateur", idGladiateur );
			req.getRequestDispatcher("modificationGladiateur.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("creationGladiateur.jsp").forward(req, resp);
		}
		
	}
	
}


