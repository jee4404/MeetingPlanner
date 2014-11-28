package view.frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import view.components.Bouton;
/**
 * @author Marie Desaulniers
 */
public class FenetreQuantiteEquip extends JFrame implements ActionListener {
	 private JPanel pan = new JPanel();
	  private Bouton btEnregistrer;
	  private JSpinner SpQtEquipement;
	  private JLabel lbEquipement;
	  public FenetreQuantiteEquip()
	    {
		// Configuration de la fenêtre
	        this.setTitle("Quantité");
	        this.setSize(300, 125);
		    this.setResizable(false);
		    this.setLocationRelativeTo(null);               
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setContentPane(pan);
		    this.pan.setLayout(new GridBagLayout());
		    GridBagConstraints gc = new GridBagConstraints();
		    
		    // Création des composants
		    this.lbEquipement = new JLabel("Quantité requise");
		    this.SpQtEquipement = new JSpinner();
	        this.SpQtEquipement.setPreferredSize(new Dimension(60,25));
	        this.SpQtEquipement.setEditor(new JSpinner.NumberEditor(this.SpQtEquipement));
		    this.btEnregistrer = new Bouton("Enregistrer", 150,25);
		    
		    // Positionnement des composants sur la grille
		    gc.insets = new Insets(5, 5, 3, 3);
		    gc.gridx=0;		gc.gridy=0;
		    pan.add(lbEquipement, gc);
		    gc.gridx=1;		gc.gridy=0;
		    pan.add(SpQtEquipement,gc);
		    gc.gridx=0;		gc.gridy=1;	gc.gridwidth=2;
		    pan.add(btEnregistrer,gc);
		    
	        this.setVisible(true);
	        
	        btEnregistrer.addActionListener(this);
	    }
	  
	  	@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
		    Object src = evt.getSource();
		    if (src == btEnregistrer) {
		    	//PlanificateurReunion fenPlanReunion = new PlanificateurReunion();
		    } 
		}
	
	
}