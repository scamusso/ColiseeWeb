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
 * Servlet de redirection pour les gladiateurs
 * Il permet d'afficher la page de mofication ou de creation selon la demande
 * 
 * @author Stephane Camusso
 *
 */
public class EditionGladiateurServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		req.setAttribute("contexteXML", partie);
		
		if (!req.getParameter("idGladiateur").equals("null")) {
			int idGladiateur = Integer.parseInt(req.getParameter("idGladiateur"));
			req.setAttribute("idGladiateur", idGladiateur );
			req.getRequestDispatcher("modificationGladiateur.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("creationGladiateur.jsp").forward(req, resp);
		}
		
	}
	
}


