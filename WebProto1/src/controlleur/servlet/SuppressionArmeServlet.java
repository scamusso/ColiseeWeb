package controlleur.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlleur.Facade;


/**
 * 
 * Servlet de suppression d'une arme
 * Il prend en entrée 'id d'une arme et la facade
 * En sortie il retourne sur la page jsp, avec l'arme supprimée
 * 
 * @author Stephane Camusso
 *
 */
public class SuppressionArmeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		int idArme = Integer.parseInt(req.getParameter("idArme"));
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");		
		partie.supprimerArme(idArme);
		
		//Lancement du servlet de sauvegarde dans le fichier XML
		req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
	}
}


