package controlleur.servlet;
import java.io.FileOutputStream;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import controlleur.Facade;

import modele.Arme;
import modele.Gladiateur;
import modele.Mirmillon;
import modele.Retiaire;



/**
 * 
 * Servlet de sauvegarde des modifications de l'XML
 * Il prend en entrée la facade
 * En sortie il retourne le XML modifié
 * 
 * @author Stephane Camusso
 *
 */
public class SauvegardeXMLServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		Facade partie = (Facade) req.getSession().getAttribute("contexteXML");
		saveToXML(partie);

		/*req.setAttribute("contexteXML", partie);
		req.getRequestDispatcher("bienvenue.jsp").forward(req, resp);*/
	}


	public void saveToXML(Facade partie) {
		Document dom;
		Element e = null;
		Element gladiateurNode= null;
		Element gladiateurSousNode= null;
		Element gladiateurArmeNode= null;
		Element armeNode= null;
		Element armeSousNode= null;


		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			dom = db.newDocument();

			// creation de la structure root (colisee)
			Element rootEle = dom.createElement("colisee");
			Attr idAttribut;
			// creation de la structure pour la liste des gladiateurs
			e = dom.createElement("gladiateurs");
			rootEle.appendChild(e);


			for(Gladiateur gladiateur : partie.listerTousLesGladiateurs ()) { 

				gladiateurNode = dom.createElement("gladiateur");
				idAttribut = dom.createAttribute("id");
				idAttribut.setValue( String.valueOf(gladiateur.getIdGladiateur()));
				gladiateurNode.setAttributeNode(idAttribut);
				e.appendChild(gladiateurNode);




				gladiateurSousNode = dom.createElement("type");
				gladiateurSousNode.appendChild(dom.createTextNode(gladiateur.getType()));
				gladiateurNode.appendChild(gladiateurSousNode);

				gladiateurSousNode = dom.createElement("nom");
				gladiateurSousNode.appendChild(dom.createTextNode(gladiateur.getNom()));
				gladiateurNode.appendChild(gladiateurSousNode);
				
				if(gladiateur.getType().equals("Retiaire") || gladiateur.getType().equals("retiaire") ){
					
					gladiateurSousNode = dom.createElement("agilite");
					Retiaire retiaire = (Retiaire)gladiateur;
					gladiateurSousNode.appendChild(dom.createTextNode(String.valueOf(retiaire.getAgilite())));
					gladiateurNode.appendChild(gladiateurSousNode);
					
				} else if (gladiateur.getType().equals("mirmillon") || gladiateur.getType().equals("Mirmillon") ) {
					
					gladiateurSousNode = dom.createElement("poids");
					Mirmillon mirmillon = (Mirmillon)gladiateur;
					gladiateurSousNode.appendChild(dom.createTextNode(String.valueOf(mirmillon.getPoids())));
					gladiateurNode.appendChild(gladiateurSousNode);
					
				}

				gladiateurSousNode = dom.createElement("armes");
				gladiateurNode.appendChild(gladiateurSousNode);

				for(Arme armeGladiateur : gladiateur.getMesArmes()){
					gladiateurArmeNode = dom.createElement("arme");
					idAttribut = dom.createAttribute("id");
					idAttribut.setValue( String.valueOf(armeGladiateur.getIdArme()));
					gladiateurArmeNode.setAttributeNode(idAttribut);
					gladiateurSousNode.appendChild(gladiateurArmeNode);
				}
			}


			// creation de la structure pour la liste des armes
			e = dom.createElement("armes");
			rootEle.appendChild(e);

			for(Arme arme : partie.listerToutesLesArmes()) { 
				armeNode = dom.createElement("arme");
				e.appendChild(armeNode);

				//A corriger en attribut
				armeSousNode = dom.createElement("id");
				armeSousNode.appendChild(dom.createTextNode(String.valueOf(arme.getIdArme())));
				armeNode.appendChild(armeSousNode);

				armeSousNode = dom.createElement("nom");
				armeSousNode.appendChild(dom.createTextNode(arme.getNomArme()));
				armeNode.appendChild(armeSousNode);

				//ATTENTION puissancOffensive dans le XML de base
				armeSousNode = dom.createElement("puissanceOffensive");
				armeSousNode.appendChild(dom.createTextNode(String.valueOf(arme.getPuissanceOffensive())));
				armeNode.appendChild(armeSousNode);

				armeSousNode = dom.createElement("puissanceDefensive");
				armeSousNode.appendChild(dom.createTextNode(String.valueOf(arme.getPuissanceDefensive())));
				armeNode.appendChild(armeSousNode);
			}





			dom.appendChild(rootEle);

			try {
				Transformer tr = TransformerFactory.newInstance().newTransformer();
				tr.setOutputProperty(OutputKeys.INDENT, "yes");
				tr.setOutputProperty(OutputKeys.METHOD, "xml");
				tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");


				// send DOM to file
				tr.transform(new DOMSource(dom), 
						new StreamResult(new FileOutputStream("C://temp//test.xml")));
				System.out.println("generé");

			} catch (TransformerException te) {
				System.out.println(te.getMessage());
			} catch (IOException ioe) {
				System.out.println(ioe.getMessage());
			}
		} catch (ParserConfigurationException pce) {
			System.out.println("UsersXML: Error trying to instantiate DocumentBuilder " + pce);
		}
	}
}


