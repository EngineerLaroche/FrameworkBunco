package framework;

import java.util.Iterator;

public interface IRegleDeJeu {
	Iterator<IJoueur> calculerLeVainqueur(Jeu jeu);
	int calculerScoreJoueur(IJoueur joueur);
	int calculerScoreTour(IJoueur joueur, ITour tour, CollectionDes des);
}
