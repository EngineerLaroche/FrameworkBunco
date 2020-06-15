package bunco;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import framework.IJoueur;

public class JoueurBunco extends Observable implements IJoueur {
	
	private String nom;
	public JoueurBunco(String nom){
		this.nom = nom;
	}
	
	public String getNom(){
		return this.nom;
	}
	
	private ScoreBunco score = new ScoreBunco("AUCUNE", "null", 0);
	public void setScore(ScoreBunco score){
		this.score = score;
	}
	public ScoreBunco getScore(){
		return this.score;
	}
	
	private ArrayList<TourBunco> mesTours = new ArrayList<TourBunco>();
	public void add(TourBunco tour){
		this.mesTours.add(tour);
	}
	public Iterator<TourBunco> voirTours(){
		return this.mesTours.iterator();
	}

	@Override
	public int compareTo(IJoueur o) {
		return this.getScore().compareTo(o.getScore());
	}
}
