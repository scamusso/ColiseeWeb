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
 * 
 * Servlet de suppression d'une arme
 * Il prend en entrée l'id d'une arme et la facade
 * En sortie il retourne sur la page jsp, avec l'arme supprimée
 * 
 * @author Stephane Camusso
 *
 */
public class SauvegardeXMLServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		int idArme = Integer.parseInt(req.getParameter("idArme"));
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		
		partie.supprimerArme(idArme);
		req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("bienvenue.jsp").forward(req, resp);
	}
	
}


