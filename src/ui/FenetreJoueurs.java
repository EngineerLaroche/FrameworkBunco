package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetreJoueurs extends JPanel{

	/***************************
	 * Objet Swing
	 ***************************/
	private static JPanel panneauInfo;
	private static JButton retirer, ajouter;
	private Color GOLD = new Color(255,215,0);
	private static ArrayList <AffichageJoueur> listeJoueur;

	/***************************
	 * Constantes
	 ***************************/
	private static final long serialVersionUID = 6977500047043442217L;

	private final String
	AJOUTER = " + ",
	RETIRER = " – ";

	/***************************
	 *Constructeur
	 ***************************/
	public FenetreJoueurs(){

		listeJoueur = new ArrayList();

		panneauInfo();
		boutonsAjouterRetirer();

		this.setBackground(Color.DARK_GRAY);
	}

	private void panneauInfo(){

		JLabel labelTour = new JLabel();
		labelTour.setText(" Nombre de tour: 00 ");
		labelTour.setFont(new Font("Arial", Font.BOLD, 20));

		JLabel labelJoueur = new JLabel();
		labelJoueur.setText(" Joueur qui mene: 01 ");
		labelJoueur.setFont(new Font("Arial", Font.BOLD, 28));

		JLabel labelBoncoTotal = new JLabel();
		labelBoncoTotal.setText(" Nombre total de Bonco: 00");
		labelBoncoTotal.setFont(new Font("Arial", Font.BOLD, 20));

		panneauInfo = new JPanel();
		panneauInfo.setBackground(GOLD);
		panneauInfo.setPreferredSize(new Dimension(600,100));
		panneauInfo.setLayout(new GridLayout(2,2));

		panneauInfo.add(labelTour);
		panneauInfo.add(labelJoueur);
		panneauInfo.add(labelBoncoTotal);

		this.add(panneauInfo, BorderLayout.CENTER);
	}

	private void boutonsAjouterRetirer(){

		retirer = new JButton();
		retirer.setText(RETIRER);
		retirer.setEnabled(false);
		retirer.setActionCommand(RETIRER);
		retirer.setBackground(Color.LIGHT_GRAY);
		retirer.setFont(new Font("Arial", Font.BOLD, 60));
		retirer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){

				gestionAfficheJoueur(e);

				if(listeJoueur.isEmpty()){
					retirer.setEnabled(false);
				}
			}
		});

		ajouter = new JButton(); 
		ajouter.setText(AJOUTER);
		ajouter.setEnabled(false);
		ajouter.setActionCommand(AJOUTER);
		ajouter.setBackground(Color.LIGHT_GRAY);
		ajouter.setFont(new Font("Arial", Font.BOLD, 60));
		ajouter.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){

				retirer.setEnabled(true);
				gestionAfficheJoueur(e);
			}
		});

		JPanel panneauBouton = new JPanel();
		panneauBouton.setPreferredSize(new Dimension(600, 80));
		panneauBouton.setLayout(new GridLayout(1,2));
		panneauBouton.add(ajouter);
		panneauBouton.add(retirer);

		this.add(panneauBouton);
	}

	private void gestionAfficheJoueur(ActionEvent e){

		if(e.getActionCommand() == AJOUTER){
			AffichageJoueur joueur = new AffichageJoueur();
			listeJoueur.add(joueur);

			for(int i = 0; i < listeJoueur.size(); i++){
				joueur.setNumeroJoueur(i + 1);
				this.add(joueur);
			}
		}
		else if(e.getActionCommand() == RETIRER){
			if(!listeJoueur.isEmpty()){
				this.remove(listeJoueur.get(listeJoueur.size() - 1));
				listeJoueur.remove(listeJoueur.get(listeJoueur.size() - 1));
			}
		}

		this.revalidate();
		this.repaint();
	}

	public static JPanel getPanneauJoueur(){
		return panneauInfo;
	}
	
	public static JButton getBoutonRetirer(){
		return retirer;
	}

	public static JButton getBoutonAjouter(){
		return ajouter;
	}

	public static ArrayList <AffichageJoueur> getListeJoueur(){
		return listeJoueur;
	}
}