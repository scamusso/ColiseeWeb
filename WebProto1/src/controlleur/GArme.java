package controlleur;
import java.util.ArrayList;
import modele.Arme;
import modele.Gladiateur;

/**
 * GArme est la classe du gestionnaire d'arme
 * contient l'id de la prochaine arme a creer
 * et la liste de toutes les armes creees
 * 
 * @author Aline
 *
 */
public class GArme {
	
	/**
	 * Id de la prochaine arme
	 * s'incremente a la creation d'une arme
	 */
	public static int nextIdArme = 1;
	/**
	 * Liste des armes creees
	 */
	private static ArrayList<Arme> toutesLesArmes;
	
	public GArme() {
		toutesLesArmes= new ArrayList<Arme>();
	}

	/**
	 * Ajouter une nouvelle arme
	 * @param nomArme nom de l'arme
	 * @param puissOff puissance offensive de l'arme
	 * @param puissDef puissance deffensive de l'arme
	 * @return arme arme ajoutée
	 */
	public static Arme ajouterArme(String nomArme, int puissOff, int puissDef) {
		toutesLesArmes.add(new Arme(nextIdArme++, nomArme, puissOff, puissDef));		
		return toutesLesArmes.get(toutesLesArmes.size()-1);
	}
	
	/**
	 * Ajouter une nouvelle arme
	 * @param idArme id de l'arme
	 * @param nomArme nom de l'arme
	 * @param puissOff puissance offensive de l'arme
	 * @param puissDef puissance deffensive de l'arme
	 * @return arme arme ajoutée
	 */
	public static Arme ajouterArme(int idArme, String nomArme, int puissOff, int puissDef) throws Exception {
		toutesLesArmes.add(new Arme(nextIdArme++, nomArme, puissOff, puissDef));		
		return toutesLesArmes.get(toutesLesArmes.size()-1);
	}
	
	

	/**
	 * Getter
	 */
	
	/**
	 * Recupere une arme par son id dans la liste des armes creees
	 * @param idArme id de l'arme
	 * @return arme
	 */
	public static Arme getArme(int idArme){
		for(Arme arme : toutesLesArmes) {
			if(arme.getIdArme() == idArme) {
				return arme;
			}	
		}
		return null;
	}
	
	
	public static ArrayList<Arme> getToutesLesArmes() {
		return toutesLesArmes;
	}
	
	/**
	 * Permet de supprimer une arme par son ID
	 * 
	 * @param pIdArme id de l'arme
	 */
	public static  void supprimerArme(int pIdArme) {
		Arme arme = getArme(pIdArme);
		toutesLesArmes.remove(arme);
	}

}
