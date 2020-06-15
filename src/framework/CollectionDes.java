package framework;

import java.util.Iterator;

public class CollectionDes extends ACollection<IDe> {
	public CollectionDes(int capacite){
		this.longueur = capacite;
		this.valeurs = new IDe[this.longueur];
	}
}
