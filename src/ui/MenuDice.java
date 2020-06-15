package ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class MenuDice extends JMenuBar implements ActionListener{

	/***************************
	 * Classes instanciees
	 ***************************/
	private JMenuItem 
	nouvellePartieMenu,
	demarrerMenuItem,
	PauseMenuItem, 
	quitterMenuItem;

	/********************
	 * Constantes
	 ********************/
	private static final long serialVersionUID = 1536336192561843187L;

	private static final String
	MENU_FICHIER_TITRE = "Fichier",
	MENU_NOUVELLE_PARTIE = "Nouvelle Partie",
	MENU_DEMARRER = "Demarrer Partie",
	MENU_PAUSE = "Pause Partie",
	MENU_QUITTER = "Quitter",

	MENU_SELECTION_JEU = "Selection Jeu",
	BUNCO = "Bunco",
	KING = "King",

	MODE_BUNCO_PLUS = "Bunco++",

	OPTION_PANE_TITRE = "Quitter jeu",
	OPTION_PANE_TITRE_2 = "Nouvelle Partie",
	OPTION_PANE_MESSAGE = "Etes-vous certain de vouloir quitter ?",
	OPTION_PANE_MESSAGE_2 = "Etes-vous certain de vouloir demarrer une nouvelle partie ?"
							+ "\n\n<html><b style='color:red'>La partie actuelle sera perdu.</b><br>\n\n";

	/********************
	 * Objets Swing
	 ********************/

	//RadioButton permettant la selection du type de jeu
	private JRadioButtonMenuItem boutonBunco;
	private JMenu ongletBunco, ongletKing;
	private ButtonGroup regroupement;
	private JPanel panneau;

	/********************
	 * Variable
	 ********************/
	private String typeJeu = null;
	private int incrementer = 0;
	

	/********************
	 * Constructeur
	 ********************/
	public MenuDice(JPanel pan) {

		this.panneau = pan;

		addMenuFichier();
		addMenuSelectionJeu();
		enableComponents(FenetreJoueurs.getPanneauJoueur(), false);
	}

	/*******************************************************************
	 * @Titre: MENU FILE
	 * 
	 * @Resumer:
	 * Creation du menu "File". Section du menu qui permet de demarrer 
	 * une partie ou de l'arreter ainsi que  quitter le jeu.
	 * 
	 *******************************************************************/
	protected void addMenuFichier() {

		JMenu menu = creerMenu(MENU_FICHIER_TITRE, new String[]{ MENU_NOUVELLE_PARTIE, 
				MENU_DEMARRER, MENU_PAUSE, MENU_QUITTER});

		//Permet le demarrage d'une nouvelle partie
		nouvellePartieMenu = menu.getItem(0);
		nouvellePartieMenu.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {

				if(incrementer != 0){
				
				messageUtilisateur(OPTION_PANE_MESSAGE_2, OPTION_PANE_TITRE_2, false);
				
				//Demarrer une nouvelle partie 
				//FenetreJoueurs.viderListeJoueurs();
				}
				
				PauseMenuItem.setEnabled(true);
				AffichageDice.setDiceActif(true);
				FenetreDice.getBoutonLancer().setEnabled(true);
				FenetreJoueurs.getBoutonAjouter().setEnabled(true);
				enableComponents(panneau, !demarrerMenuItem.isSelected());

				incrementer++;
			}
		});

		//Permet de continuer une partie en arret
		demarrerMenuItem = menu.getItem(1);
		demarrerMenuItem.setEnabled(false);
		demarrerMenuItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				changementMenus(true);
			}
		});

		//Permet l'arret d'une partie
		PauseMenuItem = menu.getItem(2);
		PauseMenuItem.setEnabled(false);
		PauseMenuItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				changementMenus(false);
			}
		});

		//Permet la selection de l'option quitter
		quitterMenuItem = menu.getItem(3);
		quitterMenuItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				
				messageUtilisateur(OPTION_PANE_MESSAGE, OPTION_PANE_TITRE, true);
			}
		});

		this.revalidate();
		this.repaint();

		add(menu);
	}

	//https://stackoverflow.com/questions/10985734/java-swing-enabling-disabling-all-components-in-jpanel
	public void enableComponents(Container container, boolean enable) {

		Component[] components = container.getComponents();

		for (Component component : components) {
			component.setEnabled(enable);

			if (component instanceof Container) {
				enableComponents((Container)component, enable);
			}
		}
	}

	private void messageUtilisateur(String message, String titre, boolean fermer){

		int reponse = JOptionPane.showConfirmDialog(null, message, titre, JOptionPane.YES_NO_OPTION);

		if(reponse == JOptionPane.YES_OPTION){
			if(fermer){
				System.exit(0);
			}
		}

	}

	/*******************************************************************
	 * @Titre: MENU ORDRE
	 * 
	 * @Resumer:
	 * Creation du menu "ordre".
	 * Creation de deux onglets (croissant et decroissant).
	 * Boutons permettent la selection du type de tri.
	 * 
	 *******************************************************************/
	protected void addMenuSelectionJeu(){

		//Permet la creation des boutons avec parametres 
		creationBoutons();

		//Permet aux boutons de "communiquer" entre eux
		regroupementBoutons();

		//Demarrage par defaut le jeu Bunco++
		setTypeJeu(MODE_BUNCO_PLUS);

		JMenu menu = new JMenu(MENU_SELECTION_JEU);

		//Ajout des deux onglets au menu 
		menu.add(ongletBunco);
		menu.add(ongletKing);

		add(menu);
	}

	/*******************************************************************
	 * @Titre: RADIO BUTTON
	 * 
	 * @Resumer:
	 * Creation des JRadioButton. On leurs associent respectivement un 
	 * titre, un String de commande et un ActionListener.
	 * 
	 * @Source:
	 * setMnemonic: 	http://www.java2s.com/Code/Java/Swing-JFC/RadioButtonMnemonicKey.htm
	 * ActionCommand: 	http://www.java2s.com/Code/JavaAPI/javax.swing/JRadioButtonsetActionCommandStringactionCommand.htm
	 *  
	 *******************************************************************/
	private void creationBoutons(){

		//Numero de sequence par ordre croissant
		boutonBunco = new JRadioButtonMenuItem(MODE_BUNCO_PLUS);
		boutonBunco.setActionCommand(MODE_BUNCO_PLUS);
		boutonBunco.addActionListener(this);
		boutonBunco.setSelected(true);
	}

	/*******************************************************************
	 * @Titre: REGROUPEMENT RADIO BUTTON
	 * 
	 * @Resumer:
	 * On s'assure de regrouper les JRadioButtons pour les rendre exclusif.
	 * Ensuite on ajoute les JRadioButtons dans des onglets. 
	 * 
	 * @Source:
	 * Group: 	http://www.java2s.com/Code/Java/Swing-JFC/RadioButtonMnemonicKey.htm
	 * 	  
	 *******************************************************************/
	private void regroupementBoutons(){

		//Pour que les boutons agissent dans un but commun
		regroupement = new ButtonGroup();
		regroupement.add(boutonBunco);

		//Onglet du menu defilant permettant la selection du type de jeu Bunco
		ongletBunco = new JMenu(BUNCO);
		ongletBunco.add(boutonBunco);

		//Onglet du menu defilant permettant la selection d'un autre type de jeu
		ongletKing = new JMenu(KING);

	}

	/*******************************************************************
	 * @Titre: CHANGEMENT ITEMS MENU
	 * 
	 * @Résumer:
	 * Activer ou desactiver les items du menu selon la selection. 
	 * 
	 *******************************************************************/
	private void changementMenus(boolean actif){

		if(actif){

			PauseMenuItem.setEnabled(true);
			demarrerMenuItem.setEnabled(false);
		
			AffichageJoueur.setJoueurActif(true);
			AffichageDice.setDiceActif(true);
			
			enableComponents(panneau, !demarrerMenuItem.isSelected());
		}
		else if(!actif){

			PauseMenuItem.setEnabled(false);
			demarrerMenuItem.setEnabled(true);
			
			AffichageJoueur.setJoueurActif(false);
			AffichageDice.setDiceActif(false);
			
			enableComponents(panneau, PauseMenuItem.isSelected());
		}
	}

	/*******************************************************************
	 * @Titre: CREATION MENU
	 * 
	 * @Resumer:
	 * Permet l'insertion des options dans un menu defilent
	 * 
	 * @param titleKey champs principal
	 * @param itemKeys elements
	 * @return le menu
	 *
	 *******************************************************************/
	private static JMenu creerMenu(String titleKey, String[] itemKeys) {

		JMenu menu = new JMenu(titleKey);

		for(int i=0; i < itemKeys.length; ++i) {
			menu.add(new JMenuItem(itemKeys[i]));
		}
		return menu;
	}

	/*******************************************************************
	 * @Titre: ACTION EVENT
	 * 
	 * @Resumer:
	 * Permet de reperer le type de tri selectionne avec l'aide d'un String.
	 *
	 *******************************************************************/
	@Override
	public void actionPerformed(ActionEvent e) {
		typeJeu = e.getActionCommand();
	}

	public JMenuItem getDemarrer(){
		return demarrerMenuItem;
	}

	/********************
	 * Get Type Jeu
	 ********************/
	public String getTypeAlgorithme() {
		return typeJeu;
	}

	/********************
	 * Set Type Jeu
	 ********************/
	public void setTypeJeu(String typeAlgorithme) {
		this.typeJeu = typeAlgorithme;
	}
}
