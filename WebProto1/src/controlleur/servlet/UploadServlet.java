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

import org.xml.sax.SAXException;

import controlleur.Facade;
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
					/*
					//Recuperation des données de l'objet readerXML pour les mettres dans la partie
					for(Gladiateur gladiateur : readerXML.getGladiateursDuFichier()) {
						if (gladiateur.getType().equals("mirmillon") || gladiateur.getType().equals("Mirmillon") ) 
						{
							Mirmillon mirmillon = (Mirmillon) gladiateur;
							partie.creerMirmillon(gladiateur.getIdGladiateur(), gladiateur.getNom(), mirmillon.getPoids());
						}
						else
						{
							Retiaire retiaire = (Retiaire) gladiateur;
							partie.creerRetiaire(gladiateur.getIdGladiateur(), gladiateur.getNom(), retiaire.getAgilite());
						}
					}
*/
					//Envoie de la facade contenant les informations du XML a la page jsp
					req.setAttribute("contexteXML", partie);
					req.getRequestDispatcher("sauvegardeXML").forward(req, resp);
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
	 * @param req
	 * @return
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






