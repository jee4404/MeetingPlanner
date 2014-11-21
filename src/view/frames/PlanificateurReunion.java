package view.frames;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import view.components.*;
/**
 * @author Marie Desaulniers
 * Interface graphique principale du planificateur de réunion
 */
public class PlanificateurReunion extends JFrame {
	
	private static final long serialVersionUID = 1L; 
	private JTabbedPane onglet;
	private JPanel panMesReunions = new JPanel();
	private JPanel panMesInvitations = new JPanel();
	private Bouton btCreerReunion = new Bouton("Nouvelle réunion...");
	private Bouton btModifier = new Bouton("Modifier réunion...");
	private Bouton btAnnuler = new Bouton("Annuler réunion");
	private Bouton btFermer1 = new Bouton("Fermer");
	private Bouton btFermer2 = new Bouton("Fermer");
	private Bouton btAccepter = new Bouton("Accepter");
	private Bouton btRefuser = new Bouton("Refuser");
	private JTable tableau1;
	private JTable tableau2;
	private ListeDeroulante listeReunion1;
	private ListeDeroulante listeReunion2;

	public PlanificateurReunion(){
		// Configuration de la fenêtre
		this.setTitle("Planificateur de réunions");
		this.setSize(500, 250);
		this.setResizable(false);
		this.setLocationRelativeTo(null);               
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		// Configuration des onglets
		onglet = new JTabbedPane();
		onglet.addTab("Mes Réunions", panMesReunions);
		onglet.addTab("Mes invitations",panMesInvitations);
		this.getContentPane().add(onglet);

		// Données du tableau des réunions
		String  enteteReunion[] = {"Sujet", "Date","Heure"};
		Object[][] dataReunion = {
				{"Projet XYZ", "14-11-2014", "15:30"},
				{"Recrutement", "31-11-2014", "13:00"},
				{"Entrevue 1", "02-12-2014", "9:00"},
				{"Entrevue 2", "02-12-2014", "10:00"},
				{"Entrevue 3", "02-12-2014", "13:00"},
				{"Entrevue 4", "02-12-2014", "14:00"},
				{"Revue candidats", "03-12-2014", "10:00"},
				{"Projet A", "10-12-2014", "11:00"},
				{"Projet B", "12-12-2014", "14:00"}
		};

		//Construction des tableaux
		tableau1 = new JTable(dataReunion, enteteReunion);
		tableau2 = new JTable(dataReunion, enteteReunion);
		listeReunion1 = new ListeDeroulante(tableau1,300, 150);
		listeReunion2 = new ListeDeroulante(tableau2,300, 150);
		
		// Onglet MesReunion
		panMesReunions.setLayout(new GridBagLayout());
		GridBagConstraints gc1 = new GridBagConstraints();
		
		// Positionnement des composants sur la grille (boutons et tableau)
		gc1.insets = new Insets(5, 5, 3, 3);
		gc1.gridx=1;	gc1.gridy=0;
		panMesReunions.add(btCreerReunion, gc1);
		gc1.gridx=1;	gc1.gridy=1;
		panMesReunions.add(btModifier, gc1);
		gc1.gridx=1;	gc1.gridy=2;
		panMesReunions.add(btAnnuler, gc1);
		gc1.gridx=1;	gc1.gridy=3;
		gc1.anchor = GridBagConstraints.PAGE_END;
		panMesReunions.add(btFermer1, gc1);
		gc1.gridx=0;	gc1.gridy=0;
		gc1.gridheight = 4;
		panMesReunions.add(listeReunion1,gc1);
		
		// Onglet MesInvitations
		panMesInvitations.setLayout(new GridBagLayout());
		GridBagConstraints gc2 = new GridBagConstraints();
		
		// Positionnement des composants sur la grille (boutons et tableau)
		gc2.insets = new Insets(5, 5, 3, 3);
		gc2.gridx=1;	gc2.gridy=0;
		panMesInvitations.add(btAccepter, gc2);
		gc2.gridx=1;	gc2.gridy=1;
		panMesInvitations.add(btRefuser, gc2);
		gc2.gridx=1;	gc2.gridy=3;
		gc2.anchor = GridBagConstraints.PAGE_END;
		panMesInvitations.add(btFermer2, gc2);
		gc2.gridx=0;	gc2.gridy=0;
		gc2.gridheight = 4;
		panMesInvitations.add(listeReunion2,gc2);
		
		this.setVisible(true);
	  }
}