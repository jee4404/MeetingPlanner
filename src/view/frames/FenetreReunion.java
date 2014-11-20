package view.frames;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rémy on 2014-11-18.
 */
public class FenetreReunion extends JFrame {
    // Text fields
    private JTextField sujetReunionField;

    // Labels
    private JLabel sujetReunionLabel, dateReunionLabel,
        debutReunionLabel, recurrenceFoisLabel,
        nombreParticipantsLabel;

    // ComboBox
    private JComboBox debutReunionCBox;

    // Spinner
    private JSpinner nbParticipantsSpinner, recurrenceReunionSpinner;

    // JButton
    private JButton localButton, participantsButton, equipementButton;

    // JCheckbox
    private JCheckBox recurrenceCBox;

    public FenetreReunion()
    {
        super("Planifier une réunion");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(6,2,1,5));

        this.sujetReunionLabel = new JLabel("Sujet :");
        this.sujetReunionField = new JTextField();
        this.add(sujetReunionLabel);
        this.add(sujetReunionField);

        this.dateReunionLabel = new JLabel("Date :");
        this.add(dateReunionLabel);
        this.add(new JTextField());

        this.debutReunionLabel = new JLabel("Début :");
        this.debutReunionCBox = new JComboBox();
        this.add(debutReunionLabel);
        this.add(debutReunionCBox);

        this.recurrenceCBox = new JCheckBox("Rendre cette réunion récurrente ?");
        this.add(recurrenceCBox);
        // pour préserver la grille
        this.add(new JLabel(""));

        this.recurrenceFoisLabel = new JLabel("Nombre de récurrence :");
        this.recurrenceReunionSpinner = new JSpinner();
        this.recurrenceReunionSpinner.setEditor(new JSpinner.NumberEditor(this.recurrenceReunionSpinner));
        this.add(recurrenceFoisLabel);
        this.add(recurrenceReunionSpinner);

        this.nombreParticipantsLabel = new JLabel("Nombre de participants :");
        this.nbParticipantsSpinner = new JSpinner();
        this.nbParticipantsSpinner.setEditor(new JSpinner.NumberEditor(this.nbParticipantsSpinner));
        this.add(nombreParticipantsLabel);
        this.add(nbParticipantsSpinner);


        this.setVisible(true);
    }
}
