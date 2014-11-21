package view.frames;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.components.*;

/**
 * @author Marie Desaulniers
 */
public class FenetreEquipement extends JFrame{

	 private JPanel pan = new JPanel();
	  private Bouton btAjouter = new Bouton("Ajouter <<", 100, 25);
	  private Bouton btRetirer = new Bouton("Retirer >>", 100, 25);
	  private Bouton btFermer = new Bouton("Fermer", 100, 25);
	  private JTable tableau;
	  private JTable tableauDispo;
	  private JScrollPane listeEquipement;
	  private JScrollPane listeEquipmentDispo;
	  private JLabel lbEquipment = new JLabel("Équipement requis");
	  private JLabel lbEquipmentDispo = new JLabel("Équipement disponible");
	  public FenetreEquipement(){                
		    this.setTitle("Équipement");
		    this.setSize(580, 250);
		    this.setLocationRelativeTo(null);               
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setContentPane(pan);
		    pan.setLayout(new GridBagLayout());
		    GridBagConstraints gc = new GridBagConstraints();
		    
		    //Le tableau des équipements
		    String  entete[] = {"Type", "Quantité"};
		    Object[][] data = {
		      {"Projecteur", "1"},
		      {"Ordinateur portable", "3"},
		      {"Tableau blanc", "1"},
		      {"Tableau feuille", "2"},
		      {"Écran", "1"},
		      {"Micros", "2"},
		    };
		    tableau = new JTable(data, entete);
		    tableauDispo = new JTable(data, entete);
		    listeEquipement = new ListeDeroulante(tableau,200,150);
		    listeEquipmentDispo = new ListeDeroulante(tableauDispo,200,150);
		    
		    // Positionnement des composants sur la grille (boutons et tableau)
		    gc.insets = new Insets(5, 5, 3, 3);
		    gc.gridx=0;		gc.gridy=0;
			pan.add(lbEquipment, gc);
			gc.gridx=2;		gc.gridy=0;
			pan.add(lbEquipmentDispo, gc);
			gc.gridx=1;		gc.gridy=1;
			pan.add(btAjouter, gc);
			gc.gridx=1;		gc.gridy=2;
			pan.add(btRetirer, gc);
			gc.gridx=1;		gc.gridy=4;
			gc.anchor = GridBagConstraints.PAGE_END;
			pan.add(btFermer, gc);
		    gc.gridx=0;		gc.gridy=1;
			gc.gridheight = 4;
		    pan.add(listeEquipement,gc);
		    gc.gridx=2; gc.gridy=1;
		    gc.gridheight = 4;
		    pan.add(listeEquipmentDispo, gc);
			this.setVisible(true);
	  }

}
