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

import controleurs.ControleurAcceuil;
import view.components.Bouton;
/**
 * @author Marie Desaulniers
 */
public class FenetreLogin extends JFrame implements ActionListener {
	  private JPanel pan = new JPanel();
	  private Bouton btOuvrirSession;
	  private JTextField tfCourriel;
	  private JLabel lbCourriel;
	  public FenetreLogin()
	    {
		// Configuration de la fenêtre
	        this.setTitle("Ouverture de session");
	        this.setSize(300, 125);
		    this.setResizable(false);
		    this.setLocationRelativeTo(null);               
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setContentPane(pan);
		    this.pan.setLayout(new GridBagLayout());
		    GridBagConstraints gc = new GridBagConstraints();
		    
		    // Création des composants
		    this.lbCourriel = new JLabel("Adresse courriel");
		    this.tfCourriel = new JTextField();
		    this.tfCourriel.setPreferredSize(new Dimension(180,25));
		    this.btOuvrirSession = new Bouton("Ouvrir Session", 150,25);
		    
		    // Positionnement des composants sur la grille
		    gc.insets = new Insets(5, 5, 3, 3);
		    gc.gridx=0;		gc.gridy=0;
		    pan.add(lbCourriel, gc);
		    gc.gridx=1;		gc.gridy=0;
		    pan.add(tfCourriel,gc);
		    gc.gridx=0;		gc.gridy=1;	gc.gridwidth=2;
		    pan.add(btOuvrirSession,gc);
		    
	        this.setVisible(true);
	        
	        btOuvrirSession.addActionListener(this);
	    }
	  
		@Override
		public void actionPerformed(ActionEvent evt) {
			// TODO Auto-generated method stub
		    Object src = evt.getSource();
		    if (src == btOuvrirSession) {
		    	ControleurAcceuil.getInstance().login(this.tfCourriel.getText());
                this.setVisible(false);
		    } 
		}
}
