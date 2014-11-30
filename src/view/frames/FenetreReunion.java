package view.frames;

import javax.swing.*;

import controleurs.ControleurEquipement;
import dbmanager.EquipementDBManager;
import view.components.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Rémy on 2014-11-18.
 * Modified by Marie on 2014-11-23
 */
public class FenetreReunion extends JFrame implements ActionListener{
	private JPanel panPrincipal,panGauche, panDroit,panHautDroit, panBasDroit;
    private JTextField sujetReunionField,dateReunionField,localReunionField;
    private JLabel sujetReunionLabel, dateReunionLabel,
        debutReunionLabel, recurrenceFoisLabel,
        nombreParticipantsLabel, dureeReunionLabel;
    private JComboBox debutReunionCBox,dureeReunionCBox;
    private JSpinner nbParticipantsSpinner, recurrenceReunionSpinner;
    private Bouton btLocal, btParticipants,btEquip,btFermer,btSave;
    private JCheckBox recurrenceCBox;
    
    public FenetreReunion()
    {
    	// Configuration de la fenêtre
        this.setTitle("Planifier une réunion");
        this.setSize(570, 270);
        this.setResizable(false);
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configuration des panneaux
        this.panPrincipal = new JPanel();
        this.panGauche  = new JPanel();
        this.panDroit = new JPanel();
        this.panHautDroit = new JPanel();
        this.panBasDroit = new JPanel();
        
        // Panneau principal
        this.setContentPane(panPrincipal);
        this.panPrincipal.setLayout(new BorderLayout());
        panPrincipal.add(panGauche, BorderLayout.WEST);
        panPrincipal.add(panDroit,BorderLayout.EAST);
        
        // Panneau gauche
	    this.panGauche.setLayout(new GridBagLayout());
	    GridBagConstraints gcG = new GridBagConstraints();
	    this.panGauche.setBorder(BorderFactory.createTitledBorder("Paramètres de la réunion"));
	    
	    // Panneau droit
	    this.panDroit.setLayout(new BorderLayout());
	    this.panDroit.add(panHautDroit,BorderLayout.NORTH);
	    this.panDroit.add(panBasDroit,BorderLayout.SOUTH);
	    
	    // Panneau haut droit
	    this.panHautDroit.setLayout(new GridBagLayout());
	    GridBagConstraints gcHD = new GridBagConstraints();
	    
	    // Panneau bas droit
	    this.panBasDroit.setLayout(new GridBagLayout());
	    GridBagConstraints gcBD = new GridBagConstraints();
	    
	    // Création des composants
	    
	    // dimensions standards
	    Dimension dim50 = new Dimension(50,25);
	    Dimension dim100 = new Dimension(100,25);
	    
	    // Sujet réunion
	    this.sujetReunionLabel = new JLabel("Sujet :");
	    this.sujetReunionLabel.setPreferredSize(dim50);
	    this.sujetReunionField = new JTextField();
	    this.sujetReunionField.setPreferredSize(new Dimension(260,25));
	    
	    // Date de la réunion
	    this.dateReunionLabel = new JLabel("Date :");
	    this.dateReunionLabel.setPreferredSize(dim50);
	    this.dateReunionField= new JTextField();
	    this.dateReunionField.setPreferredSize(dim100);
	    
	    // Choix du nombre d'occurence de la réunion
	    this.recurrenceCBox = new JCheckBox("Récurrence");
	    this.recurrenceFoisLabel = new JLabel("Nombre de récurrence :");
	    this.recurrenceFoisLabel.setPreferredSize(dim50);
        this.recurrenceReunionSpinner = new JSpinner();
        this.recurrenceReunionSpinner.setPreferredSize(dim50);
        recurrenceReunionSpinner.setEnabled(false);
        this.recurrenceReunionSpinner.setEditor(new JSpinner.NumberEditor(this.recurrenceReunionSpinner));
	    
	    // Heure du début de la réunion
	    this.debutReunionLabel = new JLabel("Heure :");
	    this.debutReunionLabel.setPreferredSize(dim100);
	    String debLabels[] = { "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30"};
	    this.debutReunionCBox = new JComboBox(debLabels);
	    this.debutReunionCBox.setPreferredSize(dim100);
	    
	    // Durée de la réunion
	    this.dureeReunionLabel = new JLabel("Durée :");
	    this.dureeReunionLabel.setPreferredSize(dim50);
	    String durLabels[] = { "0:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00", "8:30", "9:00"};
	    this.dureeReunionCBox = new JComboBox(durLabels);
	    this.dureeReunionCBox.setPreferredSize(dim100);
	    
	    
	    // Choix du nombre de participants
        this.nombreParticipantsLabel = new JLabel("Nb de participants :");
        this.nombreParticipantsLabel.setPreferredSize(new Dimension(125,25));
        this.nbParticipantsSpinner = new JSpinner();
        this.nbParticipantsSpinner.setPreferredSize(dim50);
        this.nbParticipantsSpinner.setEditor(new JSpinner.NumberEditor(this.nbParticipantsSpinner));
        
        // Choix du local
        this.btLocal = new Bouton("Choisir local",205,25);
        this.localReunionField = new JTextField();
        this.localReunionField.setEditable(false);
        this.localReunionField.setPreferredSize(new Dimension(150,25));
        
        // Boutons
        this.btParticipants = new Bouton("Inviter participants",150,25);;
        this.btEquip = new Bouton("Ajouter équipement",150,25);
        this.btFermer = new Bouton("Fermer", 150,25);
        this.btSave = new Bouton("Enregistrer",150,25);

        
	    // Positionnement des composants sur la grille
        
        // Panneau de gauche
        gcG.insets = new Insets(5, 5, 3, 3);
	    gcG.anchor = GridBagConstraints.LINE_START;
	    gcG.gridx = 0; 	gcG.gridy = 0;	gcG.gridwidth=1;
        panGauche.add(sujetReunionLabel,gcG);
        gcG.gridx = 1; 	gcG.gridy = 0; gcG.gridwidth=3;
        panGauche.add(sujetReunionField,gcG); 
        gcG.gridx = 0; 	gcG.gridy = 1; gcG.gridwidth=1;
        panGauche.add(dateReunionLabel,gcG);
        gcG.gridx = 1; 	gcG.gridy = 1;
        panGauche.add(dateReunionField,gcG);
        gcG.gridx = 2; 	gcG.gridy = 1;
        panGauche.add(recurrenceCBox,gcG);
        gcG.gridx = 3;	gcG.gridy = 1;
        panGauche.add(recurrenceReunionSpinner,gcG);
        gcG.gridx = 0; 	gcG.gridy = 2;
        panGauche.add(debutReunionLabel,gcG);
        gcG.gridx = 1; 	gcG.gridy = 2;
        panGauche.add(debutReunionCBox,gcG);
        gcG.gridx = 0; 	gcG.gridy = 3;
        panGauche.add(dureeReunionLabel,gcG);
        gcG.gridx = 1; 	gcG.gridy = 3;
        panGauche.add(dureeReunionCBox,gcG);
        gcG.gridx = 0; 	gcG.gridy = 4; 	gcG.gridwidth=2;
        panGauche.add(nombreParticipantsLabel,gcG);
        gcG.gridx = 0; 	gcG.gridy = 5;	gcG.gridwidth=2;
        panGauche.add(btLocal, gcG);
        gcG.gridx = 1; 	gcG.gridy = 4; 	gcG.gridwidth=1;
        gcG.anchor = GridBagConstraints.LINE_END;
        panGauche.add(nbParticipantsSpinner,gcG);
        gcG.gridx = 2; 	gcG.gridy = 5;gcG.gridwidth=2;
        panGauche.add(localReunionField,gcG);      
        
        // Panneau haut droit
        gcHD.insets = new Insets(5, 5, 3, 3);
        gcHD.anchor = GridBagConstraints.PAGE_START;
        gcHD.gridx = 0; 	gcHD.gridy = 0;
        panHautDroit.add(btParticipants,gcHD);
        gcHD.gridx = 0; 	gcHD.gridy = 1;
        panHautDroit.add(btEquip,gcHD);
        
        // Panneau haut gauche
        gcBD.insets = new Insets(5, 5, 3, 3);
        gcBD.anchor = GridBagConstraints.PAGE_END;
        gcBD.gridx = 0; 	gcBD.gridy = 0; gcBD.gridheight=1;

        panBasDroit.add(btSave,gcBD);
        gcBD.gridx = 0; 	gcBD.gridy = 1;
        panBasDroit.add(btFermer,gcBD);

        this.setVisible(true);
        
        btLocal.addActionListener(this);
        btParticipants.addActionListener(this);
        btEquip.addActionListener(this);
        btFermer.addActionListener(this);
        btSave.addActionListener(this);
 	   	recurrenceCBox.addActionListener(this);

    }
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
	    Object src = evt.getSource();
	    if (src == btLocal) {
	    	FenetreChoixLocal fenChoixLocal = new FenetreChoixLocal();
	    } else if (src == btParticipants) {
	    	
	    	//FenetreParticipants fenParticipants = new FenetreParticipants();
	    } else if (src == btEquip) {
	    	ControleurEquipement.getInstance().choisirEquipement();
	    	//FenetreEquipement fenEquipement = new FenetreEquipement();
	    } else if (src == btFermer) {
	    	this.setVisible(false);
	    } else if (src == btSave) {
	    	// ... perform action for btFermer
	    }else if (src == recurrenceCBox) {
	    	Boolean cbox = recurrenceCBox.isSelected();
	    	if (cbox == false){
	    		recurrenceReunionSpinner.setEnabled(false);
	    	} else {
	    		recurrenceReunionSpinner.setEnabled(true);
	    	}
	    }
	    
	}
		
	public void setDateReunionField(String s){
		this.dateReunionField.setText(s);
	}

	public void setDebutReunionField(String s){
		// this.debutReunionCBox.setText(s);
	}

	public void setSujetReunionField(String s){
		this.sujetReunionField.setText(s);
	}

	public void setLocalReunionField(String s){
		this.localReunionField.setEditable(true);
		this.localReunionField.setText(s);
		this.localReunionField.setEditable(false);
	}

}
