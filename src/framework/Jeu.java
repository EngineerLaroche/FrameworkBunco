package framework;

import java.util.Iterator;

public class Jeu {

	private CollectionJoueurs joueurs;
	private CollectionDes des;
	private CollectionTours tours;
	private IRegleDeJeu reglesDuJeu;
	
	public Jeu(IRegleDeJeu regles, CollectionJoueurs joueurs, CollectionTours tours, CollectionDes des){
		this.joueurs = joueurs;
		this.tours = tours;
		this.des = des;
		this.reglesDuJeu = regles;
	}
	
	public CollectionJoueurs getJoueurs(){
		return null;
	}
	public CollectionTours getTours(){
		return null;
	}
	public CollectionDes getDes(){
		return null;
	}
	
}
