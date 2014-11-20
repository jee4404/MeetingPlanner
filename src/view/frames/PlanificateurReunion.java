package view.frames;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
/**
 * 
 */
public class PlanificateurReunion extends JFrame {

	private static final long serialVersionUID = 1L; 
	  private JPanel pan = new JPanel();
	  private JButton btCreerReunion = new JButton("Créer réunion...");
	  private JButton btModifier = new JButton("Modifier réunion...");
	  private JButton btAnnuler = new JButton("Annuler réunion");
	  private JButton btFermer = new JButton("Fermer");
	  private JLabel lbTitre = new JLabel("Mes réunions");
	  private JTable tableau;
	  private JScrollPane listeReunion;
	  private Font ftTitre = new Font("Tahoma", Font.BOLD,14);
	  public PlanificateurReunion(){                
		    this.setTitle("Planificateur de réunions");
		    this.setSize(450, 300);
		    this.setLocationRelativeTo(null);               
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setContentPane(pan);
		    pan.setLayout(new GridBagLayout());
		    GridBagConstraints gc = new GridBagConstraints();
		    
		    // Configuration des composants de la fenêtre
		    btCreerReunion.setPreferredSize(new Dimension(250, 30));
		    btModifier.setPreferredSize(new Dimension(150, 30));
		    btAnnuler.setPreferredSize(new Dimension(150, 30));
		    btFermer.setPreferredSize(new Dimension(150, 30));
		    lbTitre.setPreferredSize(new Dimension(250, 30));
		    lbTitre.setFont(ftTitre);
		    gc.insets = new Insets(5, 5, 3, 3);
			gc.gridx=0;
			gc.gridy=0;
			pan.add(btCreerReunion, gc);
			gc.gridx=0;
			gc.gridy=1;
			pan.add(lbTitre,gc);
			gc.gridx=1;
			gc.gridy=2;
			pan.add(btModifier, gc);
			gc.gridx=1;
			gc.gridy=3;
			pan.add(btAnnuler, gc);
			gc.gridx=1;
			gc.gridy=5;
			gc.anchor = GridBagConstraints.PAGE_END;
			pan.add(btFermer, gc);
		    //Les données du tableau
		    Object[][] data = {
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

		    //Les titres des colonnes
		    String  title[] = {"Sujet", "Date","Heure"};
		    tableau = new JTable(data, title);
		    listeReunion = new JScrollPane(tableau);
		    listeReunion.setPreferredSize(new Dimension(250, 150));
		    gc.gridx=0;
			gc.gridy=2;
			gc.gridheight = 4;
		    pan.add(listeReunion,gc);
		    this.setVisible(true);
	  }
}