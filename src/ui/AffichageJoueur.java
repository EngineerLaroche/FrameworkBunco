package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class AffichageJoueur extends JPanel{
	
	/***************************
	 * Constantes
	 ***************************/
	private static final long serialVersionUID = -4755430435441458006L;

	/***************************
	 * Objet Swing
	 ***************************/
	private Color 
	NUMERO,
	ECRITURE,
	BACKGROUND;

	private GradientPaint DEGRADE;

	/***************************
	 * Variable
	 ***************************/
	private int numeroJoueur;

	private static boolean joueurActif = true;

	/***************************
	 * Constructeur
	 ***************************/
	public AffichageJoueur(){
		
		this.setBackground(null);
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(600,120));
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponents(g);

		//Si joueur actif, couleurs apparaissent
		if(joueurActif){

			NUMERO = new Color(255,215,0);
			BACKGROUND = new Color(178,34,34);
			ECRITURE = new Color(255,255,255,255);
			DEGRADE = new GradientPaint(0, 300, Color.BLACK, 300, 0, BACKGROUND);

			joueurActif(g);
		}
		//Sinon, couleurs grises
		else if(!joueurActif){

			NUMERO = new Color(128,128,128);
			BACKGROUND = new Color(192,192,192);
			ECRITURE = new Color(105,105,105);
			DEGRADE = new GradientPaint(0, 300, Color.BLACK, 300, 0, BACKGROUND);

			joueurActif(g);
		}
	}
	
	private void joueurActif(Graphics g){

		Graphics2D graphic = (Graphics2D)g;

		graphic.setPaint(DEGRADE);
		graphic.fillRoundRect(10, 10, 570, 110, 50, 50);

		graphic.setFont(new Font("Arial", Font.BOLD, 80));
		graphic.setColor(NUMERO);
		graphic.drawString("0" + numeroJoueur,40,95);

		graphic.setFont(new Font("Arial", Font.BOLD, 30));
		graphic.setColor(ECRITURE);
		graphic.drawString("Score du joueur:",160,60);

		graphic.setFont(new Font("Arial", Font.BOLD, 20));
		graphic.setColor(ECRITURE);
		graphic.drawString("Bonco:",160,100);

		graphic.setFont(new Font("Arial", Font.BOLD, 20));
		graphic.setColor(ECRITURE);
		graphic.drawString("Double:",270,100);

		graphic.setFont(new Font("Arial", Font.BOLD, 20));
		graphic.setColor(ECRITURE);
		graphic.drawString("Simple:",380,100);
	}

	public void setNumeroJoueur(int joueur){
		this.numeroJoueur = joueur;
	}

	public static void setJoueurActif(boolean joueur){
		joueurActif = joueur;
	}
}