package controlleur;

import java.util.ArrayList;

import modele.Arme;
import modele.Gladiateur;

/**
 *  Controlleur permettant la gestion des événement liés aux Gladiateurs
 * 
 * @author clement
 *
 */
public class Facade {

	// Variable de classe
	private static GGladiateur gGladiateur;
	private static GArme gArme;

	/**
	 * Constructeur
	 */
	public  Facade() {
		gGladiateur = new GGladiateur();
		gArme=new GArme();
	}



	/**
	 *  Initialise le jeu d'essai
	 */
	public static void lancerJeuDEssai() {
		creerRetiaire("Unix", 30);
		creerMirmillon("Infomatix", 100);
		creerRetiaire("Ceplusplus", 40);
		creerMirmillon("Pythonus", 60);
		creerRetiaire("Szervlet", 50);
		creerMirmillon("Ramazmjet", 80);
		//Créer les armes
		creerUneArme("Glaive", 80, 0);
		creerUneArme("trident", 100, 0);
		creerUneArme("Filet", 40, 20);
		creerUneArme("Bouclier", 40, 40);
		creerUneArme("Casque", 0, 20);
		creerUneArme("Jambière", 0, 10);
		donnerUneArme(1, 2);
		donnerUneArme(1, 6);
		donnerUneArme(1, 3);
		donnerUneArme(2, 1);
		donnerUneArme(2, 4);
		donnerUneArme(2, 5);
		donnerUneArme(2, 6);	
		donnerUneArme(3, 2);
		donnerUneArme(3, 6);
		donnerUneArme(4, 1);
		donnerUneArme(4, 4);
		donnerUneArme(5, 1);
		donnerUneArme(5, 6);
		donnerUneArme(6, 4);
		donnerUneArme(6, 5);
	}

	/**
	 * Creer un Retiaire dans la partie
	 * @param pNom nom du gladiateur
	 * @param pAgilite agilit� du gladiateur
	 * @return le gladiateur cr�er
	 */
	public static Gladiateur creerRetiaire(String pNom, int pAgilite) {
		return gGladiateur.ajouterRetiaire(pNom, pAgilite);
	}


	/**
	 * Creer un Mirmillon dans la partie
	 * 
	 * @param pNom nom du gladiateur
	 * @param pPoids poids du gladiateur
	 * @return le gladiateur crée
	 */
	public static Gladiateur creerMirmillon(String pNom, int pPoids) {
		return gGladiateur.ajouterMirmillon(pNom, pPoids);
	}
	

	/**
	 *  Créer un Retiaire dans la partie
	 * @param idGladiateur id du gladiateur
	 * @param pNom nom du gladiateur
	 * @param pAgilite agilitéé du gladiateur
	 * @return le gladiateur créer
	 * @throws Exception Erreur lors de la creation du retiaire avec un ID
	 */
	
	public static Gladiateur creerRetiaireID(int idGladiateur, String pNom, int pAgilite) throws Exception {
		return gGladiateur.ajouterRetiaire(idGladiateur, pNom, pAgilite);
	}

	/**
	 * Ce�er un Mirmillon dans la partie
	 * @param idGladiateur id du gladiateur
	 * @param pNom nom du gladiateur
	 * @param pPoids poids du gladiateur
	 * @return le gladiateur
	 * @throws Exception erreur lors de la creation du mirmillon avec un ID
	 */

	public static Gladiateur creerMirmillonID(int idGladiateur, String pNom, int pPoids) throws Exception {
		return gGladiateur.ajouterMirmillon(idGladiateur, pNom, pPoids);
	}

	/**
	 * @return la liste des gladiateurs
	 */
	public static ArrayList<Gladiateur> listerTousLesGladiateurs () {
		return gGladiateur.getTousLesGladiateurs();
	}
	
	/**
	 * @return la liste des armes
	 */
	public static ArrayList<Arme> listerToutesLesArmes () {
		return gArme.getToutesLesArmes();
	}


	/**
	 * @return l'arme recherchée
	 */
	public static Arme getArme (int idArme) {
		return gArme.getArme(idArme);
	}
	
	/**
	 * @return le gladiateur recherché
	 */
	public static Gladiateur getGladiateur (int idGladiateur) {
		return gGladiateur.getGladiateur(idGladiateur);
	}


	
	
	/**
	 * Retourne la liste des agresseur du gladiateur dont l'id est pass� en param�tre
	 * @param pIdGladiateur id du gladiateur
	 * @return liste des gladiateurs (objet) 
	 */
	public static ArrayList<Gladiateur> listerAgresseurs(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).getMesAggresseurs();	
		}
		return null;
	}

	/**
	 * Renvoie une chaine de carractere
	 * @param pIdGladiateur id du gladiateur
	 * @return String  salutation du gladiateur
	 */
	public static String faireSaluerGladiateur(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).saluer();
		}
		return null;
	}

	/**
	 * Retourne le rapport du gladiateur dont l'id est passé en paramètre
	 * @param pIdGladiateur id du gladiateur
	 * @return String rapport du gladiateur
	 */
	public static String faireRapport(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).rapport();
		}
		return null;
	}

	/**
	 * Retourne les armes du gladiateur dont l'id est passé en paramètre
	 * @param pIdGladiateur id du gladiateur
	 * @return les armes du gladaiteurs
	 */

	public static ArrayList<Arme> declarerArmes(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			return gGladiateur.getGladiateur(pIdGladiateur).getMesArmes();
		}
		return null;
	}


	/**
	 * Supprime le gladiateur dont l'id est passé en paramètre
	 * @param pIdGladiateur : int
	 */
	public static void supprimerGladiateur(int pIdGladiateur) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			gGladiateur.supprimerGladiateur(pIdGladiateur);
		}
	}
	
	/**
	 * Supprime l'arme dont l'id est passé en paramètre
	 * @param pIdArme id de l'arme
	 */
	public static void supprimerArme(int pIdArme) {
		if (gArme.getArme(pIdArme) !=  null){
			gArme.supprimerArme(pIdArme);
		}
	}

	/**
	 * Création d'une nouvelle arme	
	 * @param pNom : String
	 * @param pPuissOff : int
	 * @param pPuissDef : int
	 * @return Arme
	 */
	public static Arme creerUneArme(String pNom, int pPuissOff, int pPuissDef) {
		return gArme.ajouterArme(pNom, pPuissOff, pPuissDef);
	}


	/**
	 * Affectation d'une arme a un gladiateur
	 * @param pIdGladiateur : int
	 * @param pIdArme : int
	 */
	public static void donnerUneArme(int pIdGladiateur, int pIdArme) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			gGladiateur.getGladiateur(pIdGladiateur).recevoirArme(gArme.getArme(pIdArme));
		}
	}
	
	/**
	 * Desaffectation d'une arme a un gladiateur
	 * @param pIdGladiateur : int
	 * @param pIdArme : int
	 */
	public static void desequipperUneArme(int pIdGladiateur, int pIdArme) {
		if (gGladiateur.getGladiateur(pIdGladiateur) !=  null){
			gGladiateur.getGladiateur(pIdGladiateur).enleverArme(gArme.getArme(pIdArme));
		}
	}

	/**
	 * Retourne la description d'une arme en fonction de l'id passé en paramètre
	 * @param pIdArme id de l'arme
	 * @return String description de l'arme
	 */
	public static String decrireArme(int pIdArme) {
		if (gArme.getArme(pIdArme) !=  null){
			return gArme.getArme(pIdArme).description();
		}
		return null;
	}

	/**
	 * Renvoie le nom de l'arme dont l'id est passé en paramètre
	 * @param pIdArme Id de l'arme
	 * @return String nom de l'arme
	 */
	public static String nomArme(int pIdArme) {
		if (gArme.getArme(pIdArme) !=  null){
			return gArme.getArme(pIdArme).getNomArme();
		}
		return null;
	}

	/**
	 * Methode qui permet de lancer l'action frapper
	 * @param pIdAgresseur : int
	 * @param pIdVictime : int
	 * @param pIdArme: int
	 */
	public static void frapper(int pIdAgresseur, int pIdVictime, int pIdArme) {
		if(!gGladiateur.getGladiateur(pIdAgresseur).estMoribond() && ! gGladiateur.getGladiateur(pIdVictime).estMoribond()) {
			gGladiateur.getGladiateur(pIdAgresseur).frapper(gGladiateur.getGladiateur(pIdVictime), gArme.getArme(pIdArme));
		}
	}

}
