package view.frames;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import view.components.*;
/**
 * @author Marie Desaulniers
 */
public class FenetreParticipants extends JFrame {
	 private JPanel pan = new JPanel();
	  private Bouton btModifier = new Bouton("Modifier...");
	  private Bouton btFermer = new Bouton("Fermer");
	  private JTable tableau;
	  private JScrollPane listeParticipants;
	  public FenetreParticipants(){                
		    this.setTitle("Participants");
		    this.setSize(400, 230);
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
		    listeParticipants = new ListeDeroulante(tableau,200,150);

		    // Positionnement des composants sur la grille (boutons et tableau)
		    gc.insets = new Insets(5, 5, 3, 3);
			gc.gridx=1;		gc.gridy=0;
			pan.add(btModifier, gc);
			gc.gridx=1;		gc.gridy=3;
			gc.anchor = GridBagConstraints.PAGE_END;
			pan.add(btFermer, gc);
		    gc.gridx=0;		gc.gridy=0;
			gc.gridheight = 4;
		    pan.add(listeParticipants,gc);
			this.setVisible(true);
	  }

}
