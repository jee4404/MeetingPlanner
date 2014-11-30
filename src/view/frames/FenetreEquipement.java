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
import business.ListeEquipement;
import controleurs.ControleurEquipement;
import controleurs.ControleurParticipant;
import view.components.*;
import view.tablemodels.ListeEquipementReserveTableModel;
import view.tablemodels.ListeEquipementTableModel;

/**
 * @author Marie Desaulniers
 */
public class FenetreEquipement extends JFrame implements ActionListener {

	  private JPanel pan = new JPanel();
	  private Bouton btAjouter,btRetirer,btFermer;
	  private JTable tblEquipReserve,tblEquipDispo;
	  private JScrollPane spListeEquipementReserve,spListeEquipmentDispo;
	  private JLabel lbEquipment,lbEquipmentDispo;
	    // table model
	  private ListeEquipementTableModel equipementTableModel;
	  private ListeEquipementReserveTableModel equipementReserveTableModel;
	  
	  public FenetreEquipement(ListeEquipement listeEquipement){               
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
			

	        //Le tableau des équipement réservés
	        this.tblEquipReserve = this.getTableEquipementReserve(listeEquipement);
	        this.spListeEquipementReserve = new ListeDeroulante(tblEquipReserve,200,150);
			
		    //Le tableau des équipements disponibles
		    this.tblEquipDispo= getTableEquipement();
		    this.spListeEquipmentDispo = new ListeDeroulante(tblEquipDispo,200,150);
		    
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
		    pan.add(spListeEquipementReserve,gcEqp);
		    gcEqp.gridx=2; gcEqp.gridy=1;
		    gcEqp.gridheight = 4;
		    pan.add(spListeEquipmentDispo, gcEqp);
			this.setVisible(true);
			
			btAjouter.addActionListener(this);
			btRetirer.addActionListener(this);
			btFermer.addActionListener(this);
	  }

		@Override
		public void actionPerformed(ActionEvent evt) {

		    Object src = evt.getSource();
		    if (src == btAjouter) {
		    	Object idEquipement = this.tblEquipDispo.getValueAt(this.tblEquipDispo.getSelectionModel().getMinSelectionIndex(), 0);
		         ControleurEquipement.getInstance().reserverEquipement( (Integer)idEquipement );
		         this.equipementReserveTableModel.fireTableDataChanged();
		    } else if (src == btRetirer) {
		    	  /*Object idReservation = this.tblEquipReserve.getValueAt(this.tblEquipReserve.getSelectionModel().getMinSelectionIndex(), 0);
		          ControleurParticipant.getInstance().retirerEquipement( (Integer)idReservation );
		          this.equipementReserveTableModel.fireTableDataChanged();*/
		    } else if (src == btFermer) {
		    	this.setVisible(false);
		    }
		    
	}
		/*private JTable getTableEquipement(){
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
		}*/
		
		  private JTable getTableEquipement(){
		        this.equipementTableModel = new ListeEquipementTableModel();
		        JTable table = new JTable(this.equipementTableModel);
		        return table;
		    }
		  
		  private JTable getTableEquipementReserve(ListeEquipement listeEquipement){
			  this.equipementReserveTableModel = new ListeEquipementReserveTableModel(listeEquipement);
			  JTable table = new JTable(this.equipementReserveTableModel);
			  return table;
		  }
}
