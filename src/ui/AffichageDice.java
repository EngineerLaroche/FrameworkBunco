package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;

//https://wiki.scn.sap.com/wiki/display/Snippets/Implementing+dice+roller+using+java+Swing
//https://www.developpez.net/forums/d723163/java/interfaces-graphiques-java/graphisme/2d/mettre-degrade-couleur-jpanel/
public class AffichageDice extends JPanel{

	/***************************
	 * Constante
	 ***************************/
	private static final long serialVersionUID = 3366996016251672506L;

	/***************************
	 * Variables
	 ***************************/
	private int 
	diceHauteur = 200,
	diceLargeur = 200;

	private int 
	valeurDice, 
	diametre = 30;

	private static boolean diceActif = true;

	/***************************
	 * Objet Swing
	 ***************************/
	private Color 
	ROUGE_VIN, 
	ROUGE_PALE,
	ROUGE_DEFAUT;
	
	private GradientPaint DEGRADE;

	/********************
	 * Constructeur
	 ********************/
	public AffichageDice(){

		lancerDice(); 

		this.setPreferredSize(new Dimension(200,200));

		this.setBackground(null);
	}

	public int lancerDice() {

		Random random = new Random();

		//Genere valeur au hasard entre 1 et 6
		int valeur = random.nextInt(6) + 1; 

		setValeurDice(valeur);

		//Valeur du dice change donc on repaint()
		repaint();

		return valeur;
	}

	private void backgroundDice(Graphics g) {

		//Si joueur actif, couleurs apparaissent
		if(diceActif){

			ROUGE_VIN = new Color(178,34,34);
			ROUGE_DEFAUT = new Color(255,0,0);
			ROUGE_PALE = new Color(250,128,114);
			DEGRADE = new GradientPaint(50, 0, Color.BLACK, 0, 50, ROUGE_PALE);

			diceActif(g);
		}
		//Sinon, couleurs grises
		else if(!diceActif){

			ROUGE_VIN = new Color(96,96,96);
			ROUGE_DEFAUT = new Color(192,192,192);
			ROUGE_PALE = new Color(192,192,192);
			DEGRADE = new GradientPaint(50, 0, Color.BLACK, 0, 50, ROUGE_PALE);

			diceActif(g);
		}
	}

	private void diceActif(Graphics g){

		Graphics2D graphic = (Graphics2D)g;

		graphic.setColor(ROUGE_VIN);
		graphic.fillRoundRect(0, 0, diceLargeur, diceHauteur, 100, 100);

		graphic.setPaint(DEGRADE);
		graphic.drawRoundRect(0, 0, diceLargeur, diceHauteur, 100, 100);

		graphic.setColor(ROUGE_DEFAUT);
		graphic.fillOval(5, 5, 190, 190);

		graphic.setPaint(DEGRADE);
		graphic.drawOval(5, 5, 190, 190);
	}

	private void pointsDice(Graphics g, int x, int y) {

		int positionX = (x - diametre / 2);
		int positionY = (y - diametre / 2);

		g.setColor(Color.WHITE);
		g.fillOval(positionX, positionY, diametre, diametre);

		g.setColor(Color.black);
		g.drawOval(positionX, positionY, diametre, diametre);
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g); 

		backgroundDice(g);

		int 
		demiLargeur = (diceLargeur / 2),
		demiHauteur = (diceHauteur / 2),

		quartLargeur = (diceLargeur / 4),
		quartHauteur = (diceHauteur / 4);

		switch (valeurDice) {

		case 1: //   *

			pointsDice(g, demiLargeur, demiHauteur);
			break;

		case 2: /*   

		 			 */

			pointsDice(g, quartLargeur, quartHauteur);
			pointsDice(g, (3 * quartLargeur), (3 * quartHauteur));
			break;

		case 3: /*   
				   *
					 */

			pointsDice(g, demiLargeur, demiHauteur);
			pointsDice(g, quartLargeur, quartHauteur);
			pointsDice(g, (3 * quartLargeur), (3 * quartHauteur));
			break;

		case 4: /*    *

		 		 *    */

			pointsDice(g, quartLargeur, quartHauteur);
			pointsDice(g, (3 * quartLargeur), (3 * quartHauteur));
			pointsDice(g, (3 * quartLargeur), quartHauteur);
			pointsDice(g, quartLargeur, (3 * quartHauteur));
			break;

		case 5: /*   *
		 		   *
				 *   */

			pointsDice(g, demiLargeur, demiHauteur);
			pointsDice(g, quartLargeur, quartHauteur);
			pointsDice(g, (3 * quartLargeur), (3 * quartHauteur));
			pointsDice(g, (3 * quartLargeur), quartHauteur);
			pointsDice(g, quartLargeur, (3 * quartHauteur));
			break;

		case 6: /*   *
				 *   *
				 *   */
			pointsDice(g, quartLargeur, quartHauteur);
			pointsDice(g, (3 * quartLargeur), (3 * quartHauteur));
			pointsDice(g, (3 * quartLargeur), quartHauteur);
			pointsDice(g, quartLargeur, (3 * quartHauteur));
			pointsDice(g, quartLargeur, demiHauteur);
			pointsDice(g, (3 * quartLargeur), demiHauteur);
			break;
		}
	}

	public int getValeurDice() {

		return valeurDice;
	}

	public void setValeurDice(int valeur) {

		this.valeurDice = valeur; 
	}

	public static void setDiceActif(boolean dice){

		diceActif = dice;
	}
}
