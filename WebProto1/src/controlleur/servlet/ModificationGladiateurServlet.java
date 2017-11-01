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
import modele.Mirmillon;
import modele.Retiaire;


/**
 * 
 * Servlet de modification des caracteristiques d'un gladiateur
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
		int poids = 0;
		int agilite = 0;
		int vie = 0;
		int vieInitiale = 0;
		
		int idGladiateur = Integer.parseInt(req.getParameter("idGladiateur"));
	    vie = Integer.parseInt(req.getParameter("vie"));
		vieInitiale = Integer.parseInt(req.getParameter("vieInitiale"));
		Gladiateur gladiateur = partie.getGladiateur(idGladiateur);
		
		if (gladiateur.getType().equals("mirmillon") || gladiateur.getType().equals("Mirmillon") ) {
			Mirmillon mirmillon = (Mirmillon) gladiateur;
			mirmillon.setCType(type);
		} else {
			Retiaire retiaire = (Retiaire) gladiateur;
			retiaire.setCType(type);
		}
		
		
		
		/*
		if (!req.getParameter("poids").isEmpty()) {
			poids = Integer.parseInt(req.getParameter("poids"));
			mirmillon.setPoids(poids);
			
		}
		else if (!req.getParameter("agilite").isEmpty()) {
			agilite = Integer.parseInt(req.getParameter("agilite"));
			retiaire.setAgilite(agilite);
		}
		

		
		
		gladiateur.setNom(nom);
		gladiateur.setVie(vie);
		gladiateur.setCVieInitiale(vieInitiale);
		*/
		
		
		//Lancement du servlet de sauvegarde dans le fichier XML
		req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
		
	}
	
}


