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


public class FenetreParticipants extends JFrame {
	 private JPanel pan = new JPanel();
	  private JButton btAjouter = new JButton("Ajouter...");
	  private JButton btRetirer = new JButton("Retirer...");
	  private JButton btFermer = new JButton("Fermer");
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
		    // Configuration des composants de la fenêtre
		    btAjouter.setPreferredSize(new Dimension(150, 30));
		    btRetirer.setPreferredSize(new Dimension(150, 30));
		    btFermer.setPreferredSize(new Dimension(150, 30));
		    
		    gc.insets = new Insets(5, 5, 3, 3);
			gc.gridx=1;
			gc.gridy=0;
			pan.add(btAjouter, gc);
			gc.gridx=1;
			gc.gridy=1;
			pan.add(btRetirer, gc);
			gc.gridx=1;
			gc.gridy=3;
			gc.anchor = GridBagConstraints.PAGE_END;
			pan.add(btFermer, gc);
			 //Les données du tableau
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

		    //Les titres des colonnes
		    String  title[] = {"Nom"};
		    tableau = new JTable(data, title);
		    listeParticipants = new JScrollPane(tableau);
		    listeParticipants.setPreferredSize(new Dimension(200, 150));
		    gc.gridx=0;
			gc.gridy=0;
			gc.gridheight = 4;
		    pan.add(listeParticipants,gc);
			this.setVisible(true);
	  }

}
