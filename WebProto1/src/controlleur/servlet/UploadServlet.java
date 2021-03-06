package controlleur.servlet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import controlleur.Facade;
import controlleur.GArme;
import controlleur.GGladiateur;
import modele.Arme;
import modele.Gladiateur;
import modele.Mirmillon;
import modele.ReadXMLFile;
import modele.Retiaire;


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
					//Lecture du fichier XML
					readerXML = new ReadXMLFile(fileContent);
					
					//Mise a jour des index de la partie en fonction de ceux recuperes dans le fichier XML
					for(Gladiateur gladiateur : partie.listerTousLesGladiateurs ()) {
						GGladiateur.nextIdGladiateur++;
					}
					for(Arme armes : partie.listerToutesLesArmes()) {
						GArme.nextIdArme++;
					}
					
					//Envoie de la facade contenant les informations du XML a la page jsp
					req.setAttribute("contexteXML", partie);
					req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
					
				} else {
					//rechargement de la page d'upload
					req.getRequestDispatcher("upload.html").forward(req, resp);
				}
			} catch (Exception e) {
				System.out.println("Erreur lors de l'upload du fichier XML");
				req.getRequestDispatcher("upload.html").forward(req, resp);
			}
	}
	
	
	
	/**
	 * Methode permettant de recuperer les informations du fichier
	 * @param req Requete HTML
	 * @return le contenu du fichier XML
	 * @throws IOException Exception
	 * @throws ServletException Exception
	 * @throws SAXException Exception
	 * @throws ParserConfigurationException Exception 
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






