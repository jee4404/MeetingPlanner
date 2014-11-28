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

import business.Employe;
import controleurs.ControleurParticipant;
import dbmanager.EmployeDBManager;
import view.components.*;
/**
 * @author Marie Desaulniers
 */
public class FenetreParticipants extends JFrame implements ActionListener {
	  private JPanel pan;
	  private Bouton btAjouter, btRetirer, btFermer;
	  private JTable tableau, lstEmployes;
	  private JScrollPane listeParticipants, listeEmployes;;
	  private JLabel lbParticipants,lbEmployes;
	  private Object[][] tableEmployes;

	  public FenetreParticipants(){                
		    this.setTitle("Participants");
		    this.setSize(580, 250);
		    this.setResizable(false);
		    this.setLocationRelativeTo(null);               
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.pan = new JPanel();
		    this.setContentPane(pan);
		    this.pan.setLayout(new GridBagLayout());
		    GridBagConstraints gc = new GridBagConstraints();
		    
		    // Création des composants
			 this.btAjouter = new Bouton("Ajouter <<", 100, 25);
			 this.btRetirer = new Bouton("Retirer >>", 100, 25);
			 this.btFermer = new Bouton("Fermer", 100, 25);
			 this.lbParticipants = new JLabel("Participants");
			 this.lbEmployes = new JLabel("Employés");
		    
		    //Le tableau des participants
		    Object[][] tableParticipants = {
		      {"Jean Augé", "accepté"},
		      {"Mireille Bédard", "décliné"},
		      {"Chang Choi", "en attente" },
		      {"Jimmy Giacona", "en attente"},
		      {"Noëlla Hétu","accepté"},

		    };
		    String  enteteParticipant[] = {"Nom", "État"};
		    tableau = new JTable(tableParticipants, enteteParticipant);
		    
		    /*Object[][] tableEmployes = {
		      {"Jean Augé"},
			  {"Mireille Bédard"},
			  {"Chang Choi"},
			  {"Marie Dion"},
			  {"Timothy Eaton"},
			  {"Hans Faust"},
			  {"Jimmy Giacona"},
			  {"Noëlla Hétu"},
			  {"Zhuang Ing"}
		    };*/
		    tableEmployes= this.getTableEmployes();
		    String  enteteEmploye[] = {"Prénom, Nom"};
		    lstEmployes = new JTable(tableEmployes, enteteEmploye);
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
	    	this.setVisible(false);
	    }
	}
	
	private Object[][] getTableEmployes(){
		List<Employe> lstEmploye = new ArrayList<Employe>();
		ControleurParticipant instanceControleur = ControleurParticipant.getInstance();
		lstEmploye = instanceControleur.getListEmploye();
		for (int i = 0; i < lstEmploye.size(); i++) {
		    Employe element = lstEmploye.get(i);
		    String nom = element.getNom();
		    String prenom = element.getPrenom();
		    Object[] nomComplet = {prenom,nom};
		    tableEmployes[i] = nomComplet;
		}
		return tableEmployes;
		
	}
}
