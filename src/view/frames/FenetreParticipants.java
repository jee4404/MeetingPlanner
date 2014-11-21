package view.frames;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class FenetreParticipants extends JFrame implements ActionListener {
	 private JPanel pan = new JPanel();
	  private Bouton btAjouter = new Bouton("Ajouter <<", 100, 25);
	  private Bouton btRetirer = new Bouton("Retirer >>", 100, 25);
	  private Bouton btFermer = new Bouton("Fermer", 100, 25);
	  private JTable tableau;
	  private JTable lstEmployes;
	  private JScrollPane listeParticipants;
	  private JScrollPane listeEmployes;
	  private JLabel lbParticipants = new JLabel("Participants");
	  private JLabel lbEmployes = new JLabel("Employés");

	  public FenetreParticipants(){                
		    this.setTitle("Participants");
		    this.setSize(580, 250);
		    this.setLocationRelativeTo(null);               
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.setContentPane(pan);
		    pan.setLayout(new GridBagLayout());
		    GridBagConstraints gc = new GridBagConstraints();
		    
		    //Le tableau des participants
		    Object[][] data = {
		      {"Jean Augé"},
		      {"Mireille Bédard"},
		      {"Chang Choi"},
		      {"Marie Dion"},
		      {"Timothy Eaton"},
		      {"Hans Faust"},
		      {"Jimmy Giacona"},
		      {"Noëlla Hétu"},
		      {"Zhuang Ing"}
		    };
		    String  title[] = {"Nom"};
		    tableau = new JTable(data, title);
		    lstEmployes = new JTable(data, title);
		    listeParticipants = new ListeDeroulante(tableau,200,150);
		    listeEmployes = new ListeDeroulante(lstEmployes,200,150);

		    // Positionnement des composants sur la grille (boutons et tableau)
		    gc.insets = new Insets(5, 5, 3, 3);
		    gc.gridx=0;		gc.gridy=0;
			pan.add(lbParticipants, gc);
			gc.gridx=2;		gc.gridy=0;
			pan.add(lbEmployes, gc);
			gc.gridx=1;		gc.gridy=1;
			pan.add(btAjouter, gc);
			gc.gridx=1;		gc.gridy=2;
			pan.add(btRetirer, gc);
			gc.gridx=1;		gc.gridy=4;
			gc.anchor = GridBagConstraints.PAGE_END;
			pan.add(btFermer, gc);
		    gc.gridx=0;		gc.gridy=1;
			gc.gridheight = 4;
		    pan.add(listeParticipants,gc);
		    gc.gridx=2;		gc.gridy=1;
			gc.gridheight = 4;
			pan.add(listeEmployes,gc);
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
	    	// ... perform action for btFermer
	    }
	    
	    
	}
}
