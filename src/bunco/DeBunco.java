package bunco;

import java.util.Random;

import framework.IDe;
import framework.IFace;

/**
 * Un dé utilisé pour le jeu bunco
 * 
 * @author Maxime Gelinas
 * @date 14/07/17
 */
public class DeBunco implements IDe {
	public final int NOMBRE_DE_FACES = 6;
	
	// faces du dé
	private AFaceBunco[] faces;
	private Random rnd = new Random();
	
	/**
	 * Constructeur
	 */
	public DeBunco(){
		this.faces = new AFaceBunco[this.NOMBRE_DE_FACES];
		this.faces[0] = new FaceUn();
		this.faces[1] = new FaceDeux();
		this.faces[2] = new FaceTrois();
		this.faces[3] = new FaceQuatre();
		this.faces[4] = new FaceCinq();
		this.faces[5] = new FaceSix();
	}

	/**
	 * Roule le dé
	 * @return la face du dé
	 */
	@Override
	public IFace rouler() {
		return this.faces[rnd.nextInt(this.NOMBRE_DE_FACES)];
	}

	/**
	 * compare le nombre de face avec un autre de
	 * @param un autre de
	 * @return une comparaison
	 */
	@Override
	public int compareTo(IDe o) {
		return this.getNombreDeFaces() - o.getNombreDeFaces();
	}

	/**
	 * Retourne le nombre de face du de
	 * @return nombre de face
	 */
	@Override
	public int getNombreDeFaces() {
		return this.NOMBRE_DE_FACES;
	}
}
