package view.frames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.components.Bouton;
import view.components.ListeDeroulante;

public class FenetreChoixLocal extends JFrame implements ActionListener{
	 private JPanel pan = new JPanel();
	  private Bouton btConfirmer;
	  private JTable tableauLocaux;
	  private JScrollPane lstLocauxFiltres;
	  private JLabel lbListeLocaux;
	  
	  public FenetreChoixLocal(){                
		    this.setTitle("Locaux");
		    this.setSize(320, 200);
		    this.setResizable(false);
		    this.setLocationRelativeTo(null);               
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setContentPane(pan);
		    this.pan.setLayout(new GridBagLayout());
		    GridBagConstraints gc = new GridBagConstraints();
		    
		    //Création des composants
		    this.btConfirmer = new Bouton("Confirmer", 100, 25);
		    this.lbListeLocaux = new JLabel("Locaux disponibles:");
			this.lstLocauxFiltres = new JScrollPane();
			 //Le tableau des équipements
		    String  entete[] = {"Local"};
		    Object[][] data = {
		      {"8B1"},
		      {"305"},
		      {"8C3"},
		      {"1342"},
		    };
		    this.tableauLocaux = new JTable(data, entete);
		    this.lstLocauxFiltres = new ListeDeroulante(tableauLocaux,150,90);
		    
		    // Positionnement des composants sur la grille
		    gc.insets = new Insets(5, 5, 3, 3);
		    gc.gridx=0;		gc.gridy=0;
		    pan.add(lbListeLocaux, gc);
		    gc.gridx=1;		gc.gridy=0;gc.gridheight=2;
		    pan.add(lstLocauxFiltres,gc);
		    gc.gridx=0;		gc.gridy=4;	
		    gc.gridwidth=2; gc.gridheight = 1;
		    pan.add(btConfirmer,gc);
		    
		    this.setVisible(true);
		    
		    btConfirmer.addActionListener(this);

	  }
	  @Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
		    Object src = evt.getSource();
		    if (src == btConfirmer) {
		     	if (tableauLocaux.getSelectedRows().length != 1) {
		    		// Veuillez sélectionner une seule rangée
		    	} else {
		    		// FenetreReunion fenReunion = new FenetreReunion();
		    		// ***** à faire *****
		    		// fenReunion.setLocalReunionField(tableauLocaux.getValueAt(tableauLocaux.getSelectedRow(), 1).toString());
		    	this.setVisible(false);
		    	
		    	}
		    	
		    } 
		    
	}
}
