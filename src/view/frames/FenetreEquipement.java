package view.frames;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import business.Employe;
import business.Equipement;
import controleurs.ControleurEquipement;
import controleurs.ControleurParticipant;
import view.components.*;

/**
 * @author Marie Desaulniers
 */
public class FenetreEquipement extends JFrame implements ActionListener {

	  private JPanel pan = new JPanel();
	  private Bouton btAjouter,btRetirer,btFermer;
	  private JTable tableau,tableauDispo;
	  private JScrollPane listeEquipement,listeEquipmentDispo;
	  private JLabel lbEquipment,lbEquipmentDispo;
	  
	  public FenetreEquipement(){                
		    this.setTitle("Équipement");
		    this.setSize(580, 250);
		    this.setResizable(false);
		    this.setLocationRelativeTo(null);               
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setContentPane(pan);
		    this.pan.setLayout(new GridBagLayout());
		    GridBagConstraints gcEqp = new GridBagConstraints();
		    
		    //Création des composants
		    this.btAjouter = new Bouton("Ajouter <<", 100, 25);
			this.btRetirer = new Bouton("Retirer >>", 100, 25);
			this.btFermer = new Bouton("Fermer", 100, 25);
			this.lbEquipment = new JLabel("Équipement requis");
			this.lbEquipmentDispo = new JLabel("Équipement disponible");
			
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
		    this.tableau = new JTable(data, entete);
		    this.tableauDispo= getTableEquipement();
		    this.listeEquipement = new ListeDeroulante(tableau,200,150);
		    this.listeEquipmentDispo = new ListeDeroulante(tableauDispo,200,150);
		    
		    // Positionnement des composants sur la grille (boutons et tableau)
		    gcEqp.insets = new Insets(5, 5, 3, 3);
		    gcEqp.gridx=0;		gcEqp.gridy=0;
			pan.add(lbEquipment, gcEqp);
			gcEqp.gridx=2;		gcEqp.gridy=0;
			pan.add(lbEquipmentDispo, gcEqp);
			gcEqp.gridx=1;		gcEqp.gridy=1;
			pan.add(btAjouter, gcEqp);
			gcEqp.gridx=1;		gcEqp.gridy=2;
			pan.add(btRetirer, gcEqp);
			gcEqp.gridx=1;		gcEqp.gridy=4;
			gcEqp.anchor = GridBagConstraints.PAGE_END;
			pan.add(btFermer, gcEqp);
			gcEqp.gridx=0;		gcEqp.gridy=1;
			gcEqp.gridheight = 4;
		    pan.add(listeEquipement,gcEqp);
		    gcEqp.gridx=2; gcEqp.gridy=1;
		    gcEqp.gridheight = 4;
		    pan.add(listeEquipmentDispo, gcEqp);
			this.setVisible(true);
			
			btAjouter.addActionListener(this);
			btRetirer.addActionListener(this);
			btFermer.addActionListener(this);
	  }

		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
		    Object src = evt.getSource();
		    if (src == btAjouter) {
		      // ... perform action for btAjouter
		    } else if (src == btRetirer) {
			      // ... perform action for btRetirer
		    } else if (src == btFermer) {
		    	this.setVisible(false);
		    }
		    
	}
		private JTable getTableEquipement(){
			List<Equipement> lstEquipement = new ArrayList<Equipement>();
			ControleurEquipement instanceControleur = ControleurEquipement.getInstance();
			lstEquipement = instanceControleur.getListEquipement();
			String  enteteEquipement[] = {"Type"};
			JTable table;
			Equipement element;
			String type;
		    DefaultTableModel tableModel = new DefaultTableModel(enteteEquipement,1);
		    table = new JTable(tableModel);
			for (int i = 0; i < lstEquipement.size(); i++) {
			    element = lstEquipement.get(i);
			    type = element.getTypeEquipement();
			    Object[] typeEquipement = {type};
			    tableModel.addRow(typeEquipement);
			}
			return table;
		}
		
}
