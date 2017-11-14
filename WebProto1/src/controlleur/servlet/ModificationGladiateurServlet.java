package controlleur.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlleur.Facade;
import modele.Gladiateur;
import modele.Mirmillon;
import modele.Retiaire;


/**
 * 
 * Servlet de modification des caracteristiques d'un gladiateur
 * 
 *  Il recoit les informations suivantes :
 * - La partie (facade)
 * - L'id du gladiateur
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
public class ModificationGladiateurServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		String nom = (String) req.getParameter("nom");
		String type = (String) req.getParameter("type");
		int poids =  Integer.parseInt(req.getParameter("poids"));
		int agilite = Integer.parseInt(req.getParameter("agilite"));
		int idGladiateur = Integer.parseInt(req.getParameter("idGladiateur"));
		Gladiateur gladiateur = partie.getGladiateur(idGladiateur);
		gladiateur.setNom(nom);
		
		//Verification du type donné et du type du gladiateur pour eviter une erreur de cast entre mirmillion/gladiateur
		if (gladiateur.getType().equals("mirmillon") || gladiateur.getType().equals("Mirmillon") ) {
			Mirmillon mirmillon = (Mirmillon) gladiateur;
			if(type.equals("mirmillon")  || type.equals("Mirmillon") ) {
				if (!req.getParameter("poids").isEmpty()) {
					mirmillon.setPoids(poids);
				}
			} 
			else // Dans le cas ou le gladiateur n'a pas le bon type, on supprime et on le recreer dans l'autre type
			{
				partie.supprimerGladiateur(idGladiateur);
				try {
					partie.creerRetiaireID(idGladiateur, nom, agilite);
				} catch (Exception e1) {
					System.out.println("Erreur lors de la creation du Retiaire pour la modification du type d'un Gladiateur");
					req.setAttribute("contexteXML", partie);
					req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
				}
			}
		}
		else 
		{
			Retiaire retiaire = (Retiaire) gladiateur;
			if(type.equals("retiaire")  || type.equals("Retiaire") ) {
				if (!req.getParameter("poids").isEmpty()) {
					retiaire.setAgilite(agilite);
				}
			} 
			else  // Dans le cas ou le gladiateur n'a pas le bon type, on supprime et on le recreer dans l'autre type
			{
				partie.supprimerGladiateur(idGladiateur);
				try {
					partie.creerMirmillonID(idGladiateur, nom, poids);
				} catch (Exception e1) {
					System.out.println("Erreur lors de la creation du Mirmillon pour la modification du type d'un Gladiateur");
					req.setAttribute("contexteXML", partie);
					req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
				}
			}

		}
		
		//Lancement du servlet de sauvegarde dans le fichier XML
		req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
		
	}
	
}


