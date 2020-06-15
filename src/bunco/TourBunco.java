package bunco;

import java.util.ArrayList;
import java.util.Iterator;

import framework.ITour;

public class TourBunco implements ITour {

	private int numeroDeTour;
	
	public TourBunco(int numeroTour) {
		this.numeroDeTour = numeroTour;
	}

	public int getNumeroDeTour(){
		return this.numeroDeTour;
	}
	
	
	
	private ScoreBunco score = new ScoreBunco("AUCUNE", "null", 0);
	public ScoreBunco getScore(){
		return this.score;
	}
	public void setScore(ScoreBunco score){
		this.score = score;
	}
	
	private ArrayList<HistoriqueDeTourBunco> historique = new ArrayList<HistoriqueDeTourBunco>();
	public void add(HistoriqueDeTourBunco historique){
		this.historique.add(historique);
	}
	public Iterator<HistoriqueDeTourBunco> voirHistorique(){
		return this.historique.iterator();
	}

	@Override
	public int compareTo(ITour o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
