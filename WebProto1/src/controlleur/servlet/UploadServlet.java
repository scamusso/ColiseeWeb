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
 * Servlet du traitement du fichier xml
 * Il prend en entrée le fichier
 * Il rend en sortie une facade contenant les informations du XML
 * 
 * @author Stephane Camusso
 *
 */
public class UploadServlet extends HttpServlet {
	Facade partie = new Facade();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	

		try {
			Facade partie = new Facade();
			InputStream fileContent = getFileFromHTTP(req);
			Document xmlParsed =readXml(fileContent);
			//traitementXML(xmlParsed);
			partie.lancerJeuDEssai();
			
			
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//Envoie de la facade contenant les informations du XML a la page jsp
		req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("bienvenue.jsp").forward(req, resp);
	}
	
	
	
	
	
	
	
	public InputStream getFileFromHTTP(HttpServletRequest req) throws IOException, ServletException, SAXException, ParserConfigurationException {
		//Recuperation du fichier envoyer par le HTML
		Part filePart = req.getPart("uploadFile");
		String filePath = filePart.getSubmittedFileName();
		Path p = Paths.get(filePath);
		String fileName = p.getFileName().toString();
		InputStream fileContent = filePart.getInputStream();
		//Verification du type de fichier
		System.out.println(fileName);
		if((fileName.indexOf(".xml")) == -1 && (fileName.indexOf(".XML")) == -1){
			System.out.println(fileName + " n'est pas un fichier XML");
			req.getRequestDispatcher("/index.html");
		}
		return fileContent;
	}
	
	
	
	
	
	
	
	

	public static Document readXml(InputStream is) throws SAXException, IOException,ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setValidating(false);
		dbf.setIgnoringComments(false);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setNamespaceAware(true);
		DocumentBuilder db = null;
		db = dbf.newDocumentBuilder();
		db.setEntityResolver(new NullResolver());
		return db.parse(is);
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void traitementXML (Document xmlParsed)  {
		
		NodeList nodesGladiateur = xmlParsed.getElementsByTagName("gladiateur");
		
		int i;
		for(i=0;i<=nodesGladiateur.item(i).getChildNodes().getLength()-1;i++)
		{

			nodesGladiateur.item(i).getChildNodes().item(1).getFirstChild().getNodeValue();
			nodesGladiateur.item(i).getChildNodes().getLength();

		}
		
		
		
		
	}
}






class NullResolver implements EntityResolver {
	public InputSource resolveEntity(String publicId, String systemId) throws SAXException,
	IOException {
		return new InputSource(new StringReader(""));
	}

}

