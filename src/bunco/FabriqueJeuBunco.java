package bunco;

import framework.AFabriqueJeu;
import framework.IFabriqueDes;
import framework.IFabriqueJoueurs;
import framework.IFabriqueTours;
import framework.IRegleDeJeu;

public class FabriqueJeuBunco extends AFabriqueJeu {

	@Override
	protected IFabriqueJoueurs getFabriqueJoueurs() {
		return new FabriqueJoueursBunco();
	}

	@Override
	protected IFabriqueTours getFabriqueTours() {
		return new FabriqueToursBunco();
	}

	@Override
	protected IFabriqueDes getFabriqueDes() {
		return new FabriqueDesBunco();
	}

	@Override
	protected IRegleDeJeu getRegleDuJeu() {
		return new RegleDeJeuBunco();
	}

}
