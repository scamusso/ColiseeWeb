package controlleur.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlleur.Facade;
import modele.Arme;


/**
 * Servlet de modification des caracteristiques d'une arme
 * 
 * Il recoit les informations suivantes :
 * - La partie (facade)
 * - L'id de l'arme
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
public class ModificationArmeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		String nom = (String) req.getParameter("nom");
		int offensive = 0;
		int defensive = 0;
		int idArme = Integer.parseInt(req.getParameter("idArme"));
		
		if (!req.getParameter("offensive").isEmpty()) {
			offensive = Integer.parseInt(req.getParameter("offensive"));
		}
		
		if (!req.getParameter("defensive").isEmpty()) {
			defensive = Integer.parseInt(req.getParameter("defensive"));
		}
		Arme arme = partie.getArme(idArme);
		arme.setNom(nom);
		arme.setPuissanceDefensive(defensive);
		arme.setPuissanceOffensive(offensive);
		
		//Lancement du servlet de sauvegarde dans le fichier XML
		req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
		
	}
	
}


