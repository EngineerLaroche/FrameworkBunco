package framework;

public class CollectionTours extends ACollection<ITour> {
	public CollectionTours(int capacite){
		this.longueur = capacite;
		this.valeurs = new ITour[this.longueur];
	}
}
