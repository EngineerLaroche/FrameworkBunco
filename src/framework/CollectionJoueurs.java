package framework;

import java.util.Iterator;

public class CollectionJoueurs extends ACollection<IJoueur> {
	public CollectionJoueurs(int capacite){
		this.longueur = capacite;
		this.valeurs = new IJoueur[this.longueur];
	}
}
