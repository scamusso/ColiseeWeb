package controlleur.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlleur.Facade;


/**
 * 
 * Servlet d'ajout d'un gladiateur. Il est appelé lorsqu'on sauvegarde un gladiateur a partir de la jsp creationGladiateur
 * 
 *  Il recoit les informations suivantes :
 * - La partie (facade)
 * - Le nom du gladiateur
 * - Le poids du gladiateur
 * - L'agilité du gladiateur
 * - Le type du gladiateur
 * 
 * Il renvoie les informations suivantes :
 * - La partie (facade) mise a jour
 * 
 * 
 * @author Stephane Camusso
 *
 */
public class AjoutGladiateurServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		String nom = (String) req.getParameter("nom");
		String type = (String) req.getParameter("type");
		int poids = 0;
		int agilite = 0;

		if (!req.getParameter("poids").isEmpty()) {
			poids = Integer.parseInt(req.getParameter("poids"));
		}
		if (!req.getParameter("agilite").isEmpty()) {
			agilite = Integer.parseInt(req.getParameter("agilite"));
		}
		if (type.equals("Mirmillon") && !nom.isEmpty()){
			partie.creerMirmillon(nom, poids);
		} else if (!nom.isEmpty()) {
			partie.creerRetiaire(nom, agilite);
		}
		
		//Lancement du servlet de sauvegarde dans le fichier XML
		req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
		
	}
	
}


