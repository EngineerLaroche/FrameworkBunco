package framework;

public abstract class AFabriqueJeu {
	public Jeu creer(){
		return null;
	}
	
	protected abstract IFabriqueJoueurs getFabriqueJoueurs();
	protected abstract IFabriqueTours getFabriqueTours();
	protected abstract IFabriqueDes getFabriqueDes();
	protected abstract IRegleDeJeu getRegleDuJeu();
}
