package controlleur.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlleur.Facade;


/**
 * 
 * Servlet de suppression d'un gladiateur
 * Il prend en entrée l'id d'un gladiateur et la facade
 * En sortie il retourne sur la page jsp, avec le gladiateur supprimé
 * 
 * @author Stephane Camusso
 *
 */
public class SuppressionGladiateurServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		int idGladiateur = Integer.parseInt(req.getParameter("idGladiateur"));
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		partie.supprimerGladiateur(idGladiateur);
		
		//Lancement du servlet de sauvegarde dans le fichier XML
		req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
	}
	
}


