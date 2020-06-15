package bunco;
import framework.IFace;

/**
 * Une face abstraite d'un dés bunco
 * 
 * @author Maxime Gelinas
 * @date 14/07/17
 */
public abstract class AFaceBunco implements IFace {
	public abstract int getValeur();
	
	@Override
	/**
	 * compare avec la valeur d'une autre face
	 */
	public int compareTo(IFace o){
		return this.getValeur() - o.getValeur();
	}
}