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
import modele.ReadXMLFile;
import modele.Retiaire;
import modele.ReadXMLFile;


/**
 * 
 * Servlet du traitement du fichier xml
 * Il prend en entrée le fichier
 * Il rend en sortie une facade contenant les informations du XML
 * 
 * @author Stephane Camusso
 *
 */
public class UploadServlet extends HttpServlet {
	Facade partie = new Facade();
	boolean fichierValide = false;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
			Facade partie = new Facade();
			InputStream fileContent;
			ReadXMLFile readerXML;
			try {
				fileContent = getFileFromHTTP(req);
				
				
				if (fichierValide)  {
					readerXML = new ReadXMLFile(fileContent);

					//Envoie de la facade contenant les informations du XML a la page jsp
					req.setAttribute("contexteXML", partie);
					req.getRequestDispatcher("gestionGladiateur.jsp").forward(req, resp);
				} else {
					//rechargement de la page d'upload
					req.getRequestDispatcher("upload.html").forward(req, resp);
				}
				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
	
	/**
	 * Methode permettant de recuperer les informations du fichier
	 * 
	 * @param req
	 * @return le contenu du fichier uploadé
	 * @throws IOException
	 * @throws ServletException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public InputStream getFileFromHTTP(HttpServletRequest req) throws IOException, ServletException, SAXException, ParserConfigurationException {
		//Recuperation du fichier envoyer par le HTML
		Part filePart = req.getPart("uploadFile");
		String filePath = filePart.getSubmittedFileName();
		Path p = Paths.get(filePath);
		String fileName = p.getFileName().toString();
		InputStream fileContent = filePart.getInputStream();
		//Verification du type de fichier
		if((fileName.indexOf(".xml")) == -1 && (fileName.indexOf(".XML")) == -1){
			System.out.println(fileName + " n'est pas un fichier XML");
		} else {
			fichierValide = true;
		}
		return fileContent;
	}
	
	
	

	
}






