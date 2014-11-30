package view.frames;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import business.ListeParticipations;
import controleurs.ControleurParticipant;
import view.components.*;
import view.tablemodels.ListeEmployeTableModel;
import view.tablemodels.ListeParticipationsTableModel;

/**
 * @author Marie Desaulniers
 */
public class FenetreParticipants extends JFrame implements ActionListener {
    private JPanel pan;
    private Bouton btAjouter, btRetirer, btFermer;
    private JTable lstParticipants, lstEmployes;
    private JScrollPane listeParticipants, listeEmployes;
    private Object[][] tableEmployes;

    // table model
    private ListeParticipationsTableModel participationsTableModel;
    private ListeEmployeTableModel employeTableModel;

    public FenetreParticipants(ListeParticipations listeParticipations)
    {
        this.setTitle("Participants");
        this.setSize(580, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pan = new JPanel();
        this.setContentPane(pan);
        this.pan.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Création des composants
        this.btAjouter = new Bouton("Ajouter <<", 100, 25);
        this.btRetirer = new Bouton("Retirer >>", 100, 25);
        this.btFermer = new Bouton("Fermer", 100, 25);
        JLabel lbParticipants = new JLabel("Participants");
        JLabel lbEmployes = new JLabel("Employés");

        //Le tableau des participants
        this.lstParticipants = this.getTableParticipants(listeParticipations);
        this.listeParticipants = new ListeDeroulante(lstParticipants, 200, 150);

        // le tableau des employes
        this.lstEmployes = this.getTableEmployes();
        this.listeEmployes = new ListeDeroulante(lstEmployes,200,150);

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
    public void actionPerformed(ActionEvent evt)
    {
        Object src = evt.getSource();
        if (src == btAjouter)
        {
            Object id_employe = this.lstEmployes.getValueAt(this.lstEmployes.getSelectionModel().getMinSelectionIndex(), 0);
            ControleurParticipant.getInstance().inviterParticipant( (Integer)id_employe );
            this.participationsTableModel.fireTableDataChanged();
        }
        else if (src == btRetirer)
        {

        }
        else if (src == btFermer)
        {
            this.setVisible(false);
        }
    }

    private JTable getTableEmployes(){
        this.employeTableModel = new ListeEmployeTableModel();
        JTable table = new JTable(this.employeTableModel);
        return table;
    }

    private JTable getTableParticipants(ListeParticipations listeParticipations)
    {
        this.participationsTableModel = new ListeParticipationsTableModel(listeParticipations);
        JTable table = new JTable(this.participationsTableModel);
        table.setCellSelectionEnabled(true);
        return table;
    }
}
