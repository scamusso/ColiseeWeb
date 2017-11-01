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
 * Servlet d'assignation d'une arme a un gladiateur, il est appelé lorsqu'on modifie un gladiateur afin de lui ajouter ou enlever une arme
 * 
 * @author Stephane Camusso
 *
 */
public class AssignationArmeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		req.setAttribute("contexteXML", partie);
		int idArme = Integer.parseInt(req.getParameter("idArme"));
		int idGladiateur = Integer.parseInt(req.getParameter("idGladiateur"));
		String action = req.getParameter("action");
		
		//action peut contenir "equiper" ou "desequiper"
		if(action.equals("desequiper")) {
			partie.desequipperUneArme(idGladiateur, idArme);
		} else {
			partie.donnerUneArme(idGladiateur, idArme);
		}
		
		//On retourne sur la page de modification, les modifications seront sauvegardées a l'enregistrement du gladiateur
		req.setAttribute("contexteXML", partie);
		req.setAttribute("idGladiateur", idGladiateur );
		req.getRequestDispatcher("modificationGladiateur.jsp").forward(req, resp);
		
	}
	
}


