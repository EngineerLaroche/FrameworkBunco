package bunco;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import framework.CollectionDes;
import framework.CollectionJoueurs;
import framework.CollectionTours;
import framework.IJoueur;
import framework.ITour;
import ui.FenetrePrincipale;

public class ApplicationBunco{
	
	private static String LANCER = "Lancer";

	public static void main(String[] args) {

		//Appel de l'interface utilisateur
		FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
	}
	
	public static void demarrerIterateurs(ActionEvent e){
		
		boolean presenceBunco = false;
		
		if(e.getActionCommand() == LANCER){

			// création des composantes
			CollectionDes des = new FabriqueDesBunco().creer();
			CollectionTours tours = new FabriqueToursBunco().creer();
			RegleDeJeuBunco regles = new RegleDeJeuBunco();
			CollectionJoueurs joueurs = new FabriqueJoueursBunco().creer(); 

			
			
			
			// joueur une simulation d'une partie (sans framework)
			Iterator<ITour> itTours = tours.creerIterateur();
			while (itTours.hasNext()){
				ITour lTour = itTours.next();
				Iterator<IJoueur> itJoueurs = joueurs.creerIterateur();
				while (itJoueurs.hasNext()){
					IJoueur lJoueur = itJoueurs.next();
					regles.calculerScoreTour(lJoueur, lTour, des);
				}
			}
			
			
			
			
			Iterator<IJoueur> itJoueurs = joueurs.creerIterateur();
			while (itJoueurs.hasNext()){
				IJoueur lJoueur = itJoueurs.next();
				regles.calculerScoreJoueur(lJoueur);

				// voir le résultat
				System.out.println("\n\n");
				System.out.println(String.format("Joueur:%s Score: Type:%s Valeur:%d", ((JoueurBunco)lJoueur).getNom(), ((JoueurBunco)lJoueur).getScore().getType(), lJoueur.getScore().getValeur()));
				
				
				Iterator<TourBunco> itTour = ((JoueurBunco)lJoueur).voirTours();
				while (itTour.hasNext()){
					System.out.println("\n");
					TourBunco lTour = itTour.next();
					if ("Bunco".equals(lTour.getScore().getType())){
						for (int i = 0; i < 10; i++){
							System.out.print("BUNCO!!!");
						}
						System.out.println("");
						presenceBunco = true;
					}
					System.out.println(String.format("\tJoueur:%s, Tour:%d, Score: Type:%s Valeur:%d", ((JoueurBunco)lJoueur).getNom(), lTour.getNumeroDeTour(), lTour.getScore().getType(), lTour.getScore().getValeur()));
					
					
					Iterator<HistoriqueDeTourBunco> itHistorique = lTour.voirHistorique();
					while (itHistorique.hasNext()){
						HistoriqueDeTourBunco lHistorique = itHistorique.next();
						ScoreBunco lScore = regles.calculerScoreDeLancer(lTour.getNumeroDeTour(), lHistorique);
						System.out.println(String.format("\t\tHistorique: Score: Type:%s Valeur:%d", lScore.getType(), lScore.getValeur()));
						Iterator<AFaceBunco> itFace = lHistorique.getFaces();
						while (itFace.hasNext()){
							System.out.println(String.format("\t\t\tLancer de: %d", itFace.next().getValeur()));
						}
					}
				}
			}
			if (presenceBunco){
				System.out.println("BUNCO!!! PRESENT");
			}
		}
	}
}
