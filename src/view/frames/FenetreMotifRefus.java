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
import javax.swing.JTextField;

import view.components.Bouton;
/**
 * @author Marie Desaulniers
 */
public class FenetreMotifRefus extends JFrame implements ActionListener {
	  private JPanel pan = new JPanel();
	  private Bouton btEnregistrer;
	  private JTextField tfMotif;
	  private JLabel lbMotif;
	  public FenetreMotifRefus()
	    {
		  this.setTitle("Ouverture de session");
	        this.setSize(300, 125);
		    this.setResizable(false);
		    this.setLocationRelativeTo(null);               
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setContentPane(pan);
		    this.pan.setLayout(new GridBagLayout());
		    GridBagConstraints gc = new GridBagConstraints();
		    
		    // Création des composants
		    this.lbMotif = new JLabel("Motif du refus");
		    this.tfMotif = new JTextField();
		    this.tfMotif.setPreferredSize(new Dimension(180,25));
		    this.btEnregistrer = new Bouton("Enregistrer", 150,25);
		    
		    // Positionnement des composants sur la grille
		    gc.insets = new Insets(5, 5, 3, 3);
		    gc.gridx=0;		gc.gridy=0;
		    pan.add(lbMotif, gc);
		    gc.gridx=1;		gc.gridy=0;
		    pan.add(tfMotif,gc);
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
		    	this.setVisible(false);
		    } 
		}
}
