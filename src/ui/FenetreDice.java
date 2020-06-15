package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import bunco.ApplicationBunco;

public class FenetreDice extends JPanel{

	/***************************
	 * Classes instanciees
	 ***************************/
	protected AffichageDice 
	hautDice,
	centreDice,
	basDice;

	/***************************
	 * Objet Swing
	 ***************************/
	private static JButton lancer;

	private Color VERT_FORET = new Color(0,128,0);

	/***************************
	 * Constantes
	 ***************************/
	private static final long serialVersionUID = 3787309298809832898L;

	private String LANCER = "Lancer";

	/***************************
	 * Constantes
	 ***************************/
	private boolean nouvellePartie = true;	

	/***************************
	 *Constructeur
	 ***************************/
	public FenetreDice(){

		boutonLancer();
		panneauDice();

		this.setBackground(VERT_FORET);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	private void boutonLancer(){

		lancer = new JButton();
		lancer.setText(LANCER);
		lancer.setEnabled(false);
		lancer.setActionCommand(LANCER);
		lancer.setBackground(Color.LIGHT_GRAY);
		lancer.setPreferredSize(new Dimension(580,80));
		lancer.setFont(new Font("Arial", Font.BOLD, 40));

		lancer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){

				if(nouvellePartie){
					ApplicationBunco.demarrerIterateurs(e);
					FenetreJoueurs.getBoutonAjouter().setEnabled(false);
					FenetreJoueurs.getBoutonRetirer().setEnabled(false);
					nouvellePartie = false;
				}

				hautDice.lancerDice(); 
				centreDice.lancerDice();
				basDice.lancerDice();
			}
		});
	}

	private void panneauDice(){

		hautDice = new AffichageDice();
		centreDice = new AffichageDice();
		basDice = new AffichageDice();

		JPanel dicePanel = new JPanel();
		dicePanel.setBackground(null);
		dicePanel.add(lancer);

		JPanel dicePanel1 = new JPanel();
		dicePanel1.setBackground(null);
		dicePanel1.add(hautDice);

		JPanel dicePanel2 = new JPanel();
		dicePanel2.setBackground(null);
		dicePanel2.add(centreDice);

		JPanel dicePanel3 = new JPanel();
		dicePanel3.setBackground(null);
		dicePanel3.add(basDice);

		this.add(dicePanel);
		this.add(dicePanel1);
		this.add(dicePanel2);
		this.add(dicePanel3);
	}

	public static JButton getBoutonLancer(){
		return lancer;
	}
}
