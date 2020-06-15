package framework;

public class CollectionScores extends ACollection<IScore> {
	public CollectionScores(int capacite){
		this.longueur = capacite;
		this.valeurs = new IScore[this.longueur];
	}
}
