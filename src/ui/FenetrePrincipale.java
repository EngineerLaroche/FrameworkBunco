package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*******************************************************************
 * @Titre_Classe: FENETRE PRINCIPALE
 * 
 * @Resumer: 
 * Cette classe represente la fenetre principale de l'application
 * 
 * @Auteur: Alexandre Laroche
 * @Date: 27 juin 2017 
 * 
 *******************************************************************/ 
public class FenetrePrincipale extends JFrame{

	/********************
	 * Constantes
	 ********************/
	private static final long serialVersionUID = 3187029302716063938L;
	private static final String TITRE = "Fenetre Principale";

	//On donne les dimensions de la fenetre principale. 
	private static final int 
	WIDTH = 1200,
	HEIGHT = 800;

	/********************
	 * Constructeur
	 ********************/
	public FenetrePrincipale(){
		
		JPanel panel = new JPanel();
		FenetreJoueurs fenetreJoueurs = new FenetreJoueurs();
		FenetreDice fenetreDice = new FenetreDice();
		
		panel.add(fenetreJoueurs);
		panel.add(fenetreDice);
		panel.setLayout(new GridLayout(1,2));
		
		MenuDice menuDice = new MenuDice(panel);

		this.add(menuDice, BorderLayout.NORTH);
		this.add(panel, BorderLayout.CENTER);
		
		parametreFrame();
	}

	public void parametreFrame() {
		
		this.pack();
		this.setTitle(TITRE);
		this.setVisible(true); 
		this.setResizable(false);
		this.setSize(WIDTH,HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
