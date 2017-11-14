package controlleur.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlleur.Facade;


/**
 * Servlet d'ajout d'arme. Il est appelé lorsqu'on sauvegarde une arme a partir de la jsp creationArme
 * 
 * Il recoit les informations suivantes :
 * - La partie (facade)
 * - Le nom de l'arme
 * - La puissance offensive
 * - La puissance defensive
 * 
 * Il renvoie les informations suivantes :
 * - La partie (facade) mise a jour
 * 
 * @author Stephane Camusso
 *
 */
public class AjoutArmeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		String nom = (String) req.getParameter("nom");
		int offensive = 0;
		int defensive = 0;
		if (!req.getParameter("offensive").isEmpty()) {
			offensive = Integer.parseInt(req.getParameter("offensive"));
		}
		if (!req.getParameter("defensive").isEmpty()) {
			defensive = Integer.parseInt(req.getParameter("defensive"));
		}
		partie.creerUneArme(nom, offensive, defensive);
		
		//Lancement du servlet de sauvegarde dans le fichier XML
		req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
		
	}
	
}


