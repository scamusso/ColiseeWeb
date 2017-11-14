package modele;
/**
 * Arme est la classe représentant une arme.
 * Est caractérisée par :
 * un id d'arme
 * un nom d'arme
 * une puissance offensive
 * une puissance défensive
 * 
 * @author Aline
 *
 */
public class Arme {
	/**
	 * Id de l'arme
	 * n'est pas modifiable
	 */
	private int idArme;
	
	/**
	 * Nom de l'arme
	 * n'est pas modifiable
	 */
	private String nomArme;
	
	/**
	 * puissance defensive de l'arme
	 * est modifiable
	 */
	private int puissanceDefensive;
	
	/**
	 * puissance offensive de l'arme
	 * est modifiable
	 */
	
	private int puissanceOffensive;

	/**
	 * Constructeur Arme
	 * l'id, le nom, les puissances offensive et defensive sont données à la construction de l'arme 
	 * @param idArme id de l'arme
	 * @param nomArme nom de l'arme
	 * @param puissOff puissance offensive de l'arme
	 * @param puissDef puissance defensive de l'arme
	 */
	public Arme(int idArme, String nomArme, int puissOff, int puissDef){
		this.idArme = idArme;
		this.nomArme = nomArme;
		this.puissanceOffensive = puissOff;
		this.puissanceDefensive = puissDef;
	}
	
	/**
	 * Retourne la liste des caracteristique de l'arme
	 * @return String description de l'arme
	 */
	public String description(){
		
		return "ID arme : " + this.idArme + ", Nom de l'arme : " + this.nomArme + ", Puissance offensive : " + this.puissanceOffensive + ", Puissance défensive : " + this.puissanceDefensive + ". ";
		
	}
	/**
	 * Retourne le nom de l'arme
	 * @return String nom de l'arme
	 */
	public String getNomArme() {
		return this.nomArme;
	}
	
	/**
	 * Retourne la puissance offensive de l'arme
	 * @return int puissance offensive de l'arme
	 */
	public int getPuissanceOffensive() {
		return this.puissanceOffensive;
	}
	
	/**
	 * Retourne l'id de l'arme
	 * @return int id de l'arme
	 */
	public int getIdArme() {
		return this.idArme;
	}
	
	/**
	 * Retourne la puissance defensive de l'arme
	 * @return int puissance deffensive de l'arme
	 */
	public int getPuissanceDefensive() {
		return this.puissanceDefensive;
	}
	
	/**
	 * Met a jour la puissance offensive de l'arme
	 * @param puissanceOffensive puissance offensive
	 */
	public void setPuissanceOffensive(int puissanceOffensive) {
		if(puissanceOffensive>0){
			this.puissanceOffensive = puissanceOffensive;
		} else {
			System.out.println("puissanceOffensive incorrecte");
		}
		
	}
	/**
	 * Met a jour la puissance defensive de l'arme
	 * @param puissanceDefensive puissance defensive
	 */
	public void setPuissanceDefensive(int puissanceDefensive) {
		if(puissanceDefensive>0){
			this.puissanceDefensive = puissanceDefensive;
		} else {
			System.out.println("puissanceDefensive incorrecte");
		}
	}
	
	/**
	 * Met a jour le nom de l'arme
	 * @param nomArme nom de l'arme
	 */
	public void setNom(String nomArme) {
		this.nomArme = nomArme;
	}

	

	

	

	
	
	

}
