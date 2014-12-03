package view.frames;

import javax.swing.*;

import business.Reunion;
import controleurs.ControleurEquipement;
import controleurs.ControleurParticipant;
import controleurs.ControleurPlanifierReunion;
import view.components.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Rémy on 2014-11-18.
 * Modified by Marie on 2014-11-23
 */
public class FenetreReunion extends JFrame implements ActionListener{
    private JTextField sujetReunionField,dateReunionField,localReunionField;
    private JSpinner recurrenceReunionSpinner, nbParticipantsSpinner;
    private Bouton btLocal, btParticipants,btEquip,btFermer,btSave;
    private JCheckBox recurrenceCBox;
    private JComboBox debutReunionCBox, dureeReunionCBox;

    private Reunion reunion;
    private boolean choixRecurrence;

    public FenetreReunion(Reunion reunion)
    {
    	// Configuration de la fenêtre
        this.setTitle("Planifier une réunion");
        this.setSize(570, 270);
        this.setResizable(false);
        this.setLocationRelativeTo(null);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configuration des panneaux
        JPanel panPrincipal = new JPanel();
        JPanel panGauche  = new JPanel();
        JPanel panDroit = new JPanel();
        JPanel panHautDroit = new JPanel();
        JPanel panBasDroit = new JPanel();
        
        // Panneau principal
        this.setContentPane(panPrincipal);
        panPrincipal.setLayout(new BorderLayout());
        panPrincipal.add(panGauche, BorderLayout.WEST);
        panPrincipal.add(panDroit,BorderLayout.EAST);
        
        // Panneau gauche
	    panGauche.setLayout(new GridBagLayout());
	    GridBagConstraints gcG = new GridBagConstraints();
	    panGauche.setBorder(BorderFactory.createTitledBorder("Paramètres de la réunion"));
	    
	    // Panneau droit
	    panDroit.setLayout(new BorderLayout());
	    panDroit.add(panHautDroit,BorderLayout.NORTH);
	    panDroit.add(panBasDroit,BorderLayout.SOUTH);
	    
	    // Panneau haut droit
	    panHautDroit.setLayout(new GridBagLayout());
	    GridBagConstraints gcHD = new GridBagConstraints();
	    
	    // Panneau bas droit
	    panBasDroit.setLayout(new GridBagLayout());
	    GridBagConstraints gcBD = new GridBagConstraints();
	    
	    // Création des composants
	    
	    // dimensions standards
	    Dimension dim50 = new Dimension(50,25);
	    Dimension dim100 = new Dimension(100,25);
	    
	    // Sujet réunion
	    JLabel sujetReunionLabel = new JLabel("Sujet :");
        sujetReunionLabel.setPreferredSize(dim50);
        sujetReunionField = new JTextField();
        sujetReunionField.setPreferredSize(new Dimension(260,25));
	    
	    // Date de la réunion
        JLabel dateReunionLabel = new JLabel("Date :");
	    dateReunionLabel.setPreferredSize(dim50);
	    dateReunionField= new JTextField();
	    dateReunionField.setPreferredSize(dim100);
	    
	    // Choix du nombre d'occurence de la réunion
	    this.recurrenceCBox = new JCheckBox("Récurrence");
        JLabel recurrenceFoisLabel = new JLabel("Nombre de récurrence :");
        recurrenceFoisLabel.setPreferredSize(dim50);
	    
	    // Configuration du JPinner pour le nombre d'occurences
	    Integer minOcc = new Integer(1);
	    Integer maxOcc = new Integer(50);
	    Integer stepOcc = new Integer(1);
	    SpinnerNumberModel modelOcc = new SpinnerNumberModel(minOcc, minOcc, maxOcc, stepOcc);
        this.recurrenceReunionSpinner = new JSpinner(modelOcc);
        this.recurrenceReunionSpinner.setPreferredSize(dim50);
        recurrenceReunionSpinner.setEnabled(false);
        this.recurrenceReunionSpinner.setEditor(new JSpinner.NumberEditor(this.recurrenceReunionSpinner));
	    
	    // Heure du début de la réunion
        JLabel debutReunionLabel = new JLabel("Heure :");
	    debutReunionLabel.setPreferredSize(dim100);
	    String debLabels[] = { "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30"};
	    this.debutReunionCBox = new JComboBox(debLabels);
	    debutReunionCBox.setPreferredSize(dim100);
	    
	    // Durée de la réunion
        JLabel dureeReunionLabel = new JLabel("Durée :");
	    dureeReunionLabel.setPreferredSize(dim50);
	    String durLabels[] = { "0:30", "1:00", "1:30", "2:00", "2:30", "3:00", "3:30", "4:00", "4:30", "5:00", "5:30", "6:00", "6:30", "7:00", "7:30", "8:00", "8:30", "9:00"};
        dureeReunionCBox = new JComboBox(durLabels);
	    dureeReunionCBox.setPreferredSize(dim100);
	    
	    
	    // Choix du nombre de participants
        JLabel nombreParticipantsLabel = new JLabel("Nb de participants :");
        nombreParticipantsLabel.setPreferredSize(new Dimension(125,25));
        
	    // Configuration du JPinner pour le nombre d'occurences
	    Integer minParticipant = new Integer(2);
	    Integer maxParticipant = new Integer(50);
	    Integer stepParticipant = new Integer(1);
	    SpinnerNumberModel modelParticipant = new SpinnerNumberModel(minParticipant, minParticipant, maxParticipant, stepParticipant);
        nbParticipantsSpinner = new JSpinner(modelParticipant);
        nbParticipantsSpinner.setPreferredSize(dim50);
        nbParticipantsSpinner.setEditor(new JSpinner.NumberEditor(nbParticipantsSpinner));
        
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

        // listener boutons
        btLocal.addActionListener(this);
        btParticipants.addActionListener(this);
        btEquip.addActionListener(this);
        btFermer.addActionListener(this);
        btSave.addActionListener(this);
 	   	recurrenceCBox.addActionListener(this);

        // la fenetre connait la réunion pour la passer au controleur
        this.reunion = reunion;

        this.choixRecurrence = false;
    }
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
	    Object src = evt.getSource();
	    if (src == btLocal)
        {
	    	FenetreChoixLocal fenChoixLocal = new FenetreChoixLocal();
	    }
        else if (src == btParticipants)
        {
	    	ControleurParticipant.getInstance().afficherInviterParticipants(this.reunion);
	    }
        else if (src == btEquip)
        {
            ControleurEquipement.getInstance().choisirEquipement(this.reunion);
	    }
        else if (src == btFermer)
        {
	    	this.setVisible(false);
	    }
        else if (src == btSave)
        {
            try
            {
                // TODO faire les check des champs obligatoires, sujet, date, heure...

                // get les valeurs du formulaire et initialise l'objet reunion
                this.reunion.setSujet(this.sujetReunionField.getText());
                this.reunion.setEstRecurente(this.choixRecurrence);
                this.reunion.setNbParticipants((Integer) this.nbParticipantsSpinner.getValue());
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                this.reunion.setDateReunion(dateFormat.parse(this.dateReunionField.getText()));

                ControleurPlanifierReunion.getInstance().creerReunion(reunion);
                // TODO affichage d'une boite de confirmation ?
            }
            catch(ParseException ex)
            {
                System.out.println(ex.getMessage());
            }
	    }
        else if (src == recurrenceCBox)
        {
	    	Boolean cbox = recurrenceCBox.isSelected();
	    	if (cbox == false){
	    		recurrenceReunionSpinner.setEnabled(false);
                choixRecurrence = false;
	    	} else {
	    		recurrenceReunionSpinner.setEnabled(true);
                choixRecurrence = true;
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
