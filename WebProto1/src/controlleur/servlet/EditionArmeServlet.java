package controlleur.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlleur.Facade;


/**
 * 
 * Servlet de redirection pour les armes
 * Il permet d'afficher la page de modification ou de creation selon la demande
 * 
 * Il recoit les informations suivantes :
 * - La partie (facade)
 * 
 * Il renvoie les informations suivantes :
 * - La partie (facade) mise a jour
 * - L'id de l'arme concernée
 * 
 * @author Stephane Camusso
 *
 */
public class EditionArmeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		req.setAttribute("contexteXML", partie);
		
		if (!req.getParameter("idArme").equals("null")) {
			int idArme = Integer.parseInt(req.getParameter("idArme"));
			req.setAttribute("idArme", idArme);
			req.getRequestDispatcher("modificationArme.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("creationArme.jsp").forward(req, resp);
		}
		
	}
	
}


