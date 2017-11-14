/**
 * 
 */
package controlleur;

import java.util.ArrayList;

import modele.Gladiateur;
import modele.Mirmillon;
import modele.Retiaire;

/**
 * Gestionnaire de Gladiateurs
 * 
 * @author clement
 * 
 */
public class GGladiateur {
	
	// variable de classe
	private static int nextIdGladiateur = 1;
	private static ArrayList<Gladiateur> tousLesGladiateurs;
	
	/***
	 * Constructeur du gestionnaire
	 */
	public GGladiateur() {
		tousLesGladiateurs = new ArrayList<Gladiateur>();
	};
	
	/**
	 * Ajoute un gladiateur de type Mirimillon à la liste des gladiateurs
	 * @param pNom nom du gladiateur
	 * @param pPoids son poids
	 * @return l'objet gladiateur créer
	 */
	public static Gladiateur ajouterMirmillon(String pNom, int pPoids) {
		tousLesGladiateurs.add(new Mirmillon(GGladiateur.nextIdGladiateur++,pNom,pPoids));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * Ajoute un gladiateur de type Mirimillon ï¿½ la lste des gladiateurs
	 * @param idGladiateur
	 * @param pNom nom du gladiateur
	 * @param pPoids son poids
	 * @return l'objet gladiateur crï¿½er
	 * @throws Exception 
	 */
	public static Gladiateur ajouterMirmillon(int idGladiateur, String pNom, int pPoids) throws Exception {
		tousLesGladiateurs.add(new Mirmillon(GGladiateur.nextIdGladiateur++,pNom,pPoids));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * Ajoute un gladiateur de type Mirimillon à la lste des gladiateurs
	 * @param pNom nom du gladiateur
	 * @param pAgilite son agilité
	 * @return l'objet gladiateur créer
	 */
	public static Gladiateur ajouterRetiaire(String pNom, int pAgilite) {
		tousLesGladiateurs.add(new Retiaire(GGladiateur.nextIdGladiateur++,pNom,pAgilite));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * Ajoute un gladiateur de type Mirimillon ï¿½ la lste des gladiateurs
	 * @param idGladiateur
	 * @param pNom nom du gladiateur
	 * @param pAgilite son agilitï¿½
	 * @return l'objet gladiateur crï¿½er
	 * @throws Exception 
	 */
	public static Gladiateur ajouterRetiaire(int idGladiateur, String pNom, int pAgilite) throws Exception {
		tousLesGladiateurs.add(new Retiaire(GGladiateur.nextIdGladiateur++,pNom,pAgilite));
		return tousLesGladiateurs.get(tousLesGladiateurs.size()-1);
	}
	
	/**
	 * Méthode qui renvoie l'ensembles des gladiateurs en jeu
	 * @return Liste de gladiateurs "ArrayList<Gladiateur>()"
	 */
	public static ArrayList<Gladiateur> getTousLesGladiateurs() {
		return tousLesGladiateurs;
	}
	
	/**
	 * Methode qui retourne le gladiateur dont l'id est passé en paramètre
	 * @param pIdGladiateur
	 * @return Gladiateur
	 */
	public static Gladiateur getGladiateur(int pIdGladiateur) {
		for(Gladiateur gladiateur : tousLesGladiateurs) {
			if(gladiateur.getIdGladiateur()==pIdGladiateur) {
				return gladiateur;
			}
		}
		return null;
	}
	
	/**
	 * Supprime de la liste des gladiateurs le gladiateur correspondant à l'id
	 * @param pIdGladiateur
	 */
	public static  void supprimerGladiateur(int pIdGladiateur) {
		Gladiateur gladiateur = getGladiateur(pIdGladiateur);
		tousLesGladiateurs.remove(gladiateur);
	}
	
	
	/**
	 * Supprime de la liste des gladiateurs le gladiateur passer en parametre
	 * @param pGladiateur
	 */
	public static void supprimerGladiateur(Gladiateur pGladiateur) {
		tousLesGladiateurs.remove(pGladiateur);
	}
	
}
