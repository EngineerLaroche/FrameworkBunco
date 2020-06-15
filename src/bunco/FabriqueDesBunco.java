package bunco;

import framework.CollectionDes;
import framework.IFabriqueDes;

public class FabriqueDesBunco implements IFabriqueDes {

	private final int NOMBRE_DE_DES = 3;
	
	
	
	@Override
	public CollectionDes creer() {
		CollectionDes des = new CollectionDes(this.NOMBRE_DE_DES);
		for (int i = 0; i < NOMBRE_DE_DES; i++){
			DeBunco de = new DeBunco();
			des.ajouter(de);
		}
		return des;
	}

}
