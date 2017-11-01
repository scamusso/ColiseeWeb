package controlleur.servlet;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import controlleur.Facade;

import modele.Arme;
import modele.Gladiateur;


/**
 * Servlet de modification des caracteristiques d'une arme
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


