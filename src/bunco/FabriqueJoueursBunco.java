package bunco;

import framework.CollectionJoueurs;
import framework.IFabriqueJoueurs;
import ui.FenetreJoueurs;

public class FabriqueJoueursBunco implements IFabriqueJoueurs {

	@Override
	public CollectionJoueurs creer() {
		
		CollectionJoueurs joueurs = new CollectionJoueurs(FenetreJoueurs.getListeJoueur().size());

		for (int i = 1; i <= FenetreJoueurs.getListeJoueur().size(); i++){
			JoueurBunco joueur = new JoueurBunco("0" + String.valueOf(i));
			joueurs.ajouter(joueur);
		}
		return joueurs;
	}
}
