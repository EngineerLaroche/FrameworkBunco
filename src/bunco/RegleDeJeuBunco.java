package bunco;

import java.util.Iterator;

import framework.ACollection;
import framework.CollectionDes;
import framework.CollectionJoueurs;
import framework.IDe;
import framework.IFace;
import framework.IJoueur;
import framework.IRegleDeJeu;
import framework.ITour;
import framework.Jeu;

public class RegleDeJeuBunco implements IRegleDeJeu {

	private final int AUCUN_POINTS = 0;
	private final int BUNCO_POINTS = 21;
	private final int IDENTIQUE_POINTS = 5;
	private final String RELANCER_DES_ACTION = "RELANCER";
	private final String AUCUNE_ACTION = "AUCUNE";
	private final String PASSER_ACTION = "PASSER AU SUIVANT";
	
	@Override
	public Iterator<IJoueur> calculerLeVainqueur(Jeu jeu) {
		CollectionJoueurs joueurs = jeu.getJoueurs();
		ACollection<IJoueur> joueursCopie = joueurs.copy();
		joueursCopie.sort();
		return joueursCopie.creerIterateur();
	}

	@Override
	public int calculerScoreJoueur(IJoueur joueur) {
		ScoreBunco lScore = null;
		if (joueur instanceof JoueurBunco){
			JoueurBunco lJoueur = (JoueurBunco)joueur;
			Iterator<TourBunco> itTour = lJoueur.voirTours();
			int valeurScoreTotal = 0;
			while (itTour.hasNext()){
				valeurScoreTotal += itTour.next().getScore().getValeur();
			}
			lScore = new ScoreBunco("AUCUNE", "Total", valeurScoreTotal);
			lJoueur.setScore(lScore);
		}
		return lScore.getValeur();
	}

	@Override
	public int calculerScoreTour(IJoueur joueur, ITour tour, CollectionDes des) {
		ScoreBunco lScore = null;
		if (joueur instanceof JoueurBunco){
			JoueurBunco lJoueur = (JoueurBunco)joueur;
			TourBunco lTour = new TourBunco(tour.getNumeroDeTour());
			
			// LANCER LES DES
			while (lScore == null || this.RELANCER_DES_ACTION.equals(lScore.getType().toUpperCase())){
				HistoriqueDeTourBunco lHistorique = new HistoriqueDeTourBunco();
				Iterator<IDe> itDes = des.creerIterateur();
				while (itDes.hasNext()){
					IFace lFace = itDes.next().rouler();
					if (lFace instanceof AFaceBunco){
						lHistorique.add((AFaceBunco)lFace);
					}
				}
				lTour.add(lHistorique);
				ScoreBunco aScore = this.calculerScoreDeLancer(tour.getNumeroDeTour(), lHistorique); 
				if (lScore == null){
					lScore = aScore;
				} else if (this.RELANCER_DES_ACTION.equals(lScore.getType().toUpperCase())){
					lScore = new ScoreBunco(aScore.getAction(), aScore.getType(), lScore.getValeur()+aScore.getValeur());
				}
			}
			
			lTour.setScore(lScore);
			lJoueur.add(lTour);
		}
		return lScore.getValeur();
	}
	
	
	public ScoreBunco calculerScoreDeLancer(int numeroDeTour, HistoriqueDeTourBunco historique){
		Iterator<AFaceBunco> itFaces = historique.getFaces();
		int valeurScore = 0;
		boolean lIdentique = true; 
		
		AFaceBunco lFace = null;
		while (itFaces.hasNext()){
			AFaceBunco lFaceTemp = itFaces.next();
			if (numeroDeTour == lFaceTemp.getValeur()){
				valeurScore++;
			}
			if (lFace == null){
				lFace = lFaceTemp;
			} else if (lIdentique) {
				if (lFace.compareTo(lFaceTemp) != 0){
					lIdentique = false;
				}
			}
		}
		
		ScoreBunco lScore = null;
		if (!lIdentique && valeurScore == AUCUN_POINTS){
			lScore = new ScoreBunco(this.PASSER_ACTION, "Zero", AUCUN_POINTS);
		} else if (lIdentique && valeurScore == historique.getNombreDeFaces()){
			lScore = new ScoreBunco(this.PASSER_ACTION, "Bunco", BUNCO_POINTS);
		} else if (lIdentique){
			lScore = new ScoreBunco(this.RELANCER_DES_ACTION, "Triple", IDENTIQUE_POINTS);
		} else {
			if (valeurScore == 1){
				lScore = new ScoreBunco(this.RELANCER_DES_ACTION, "Simple", valeurScore);
			} else if (valeurScore == 2){
				lScore = new ScoreBunco(this.RELANCER_DES_ACTION, "Double", valeurScore);
			} else{
				lScore = new ScoreBunco(this.RELANCER_DES_ACTION, "Pointage", valeurScore);
			}
		}
		
		return lScore;
	}

}
