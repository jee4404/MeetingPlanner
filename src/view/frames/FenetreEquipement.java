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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import business.Employe;
import business.Equipement;
import business.ListeEquipement;
import controleurs.ControleurEquipement;
import controleurs.ControleurParticipant;
import view.components.*;
import view.tablemodels.ListeEquipementReserveTableModel;
import view.tablemodels.ListeEquipementTableModel;

/**
 * @author Marie Desaulniers
 */
public class FenetreEquipement extends JFrame implements ActionListener,TableModelListener {
    private JPanel pan = new JPanel();
    private Bouton btAjouter,btRetirer,btFermer;
    private JTable tblEquipDispo,tblEquipReserve;
    private JScrollPane spListeEquipementReserve,spListeEquipmentDispo;
    private JLabel lbEquipment,lbEquipmentDispo;
    // table model
    private ListeEquipementTableModel equipementTableModel;
    private ListeEquipementReserveTableModel equipementReserveTableModel;
	  
    public FenetreEquipement(ListeEquipement listeEquipement)
    {
        this.setTitle("Équipement");
        this.setSize(580, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pan);
        this.pan.setLayout(new GridBagLayout());
        GridBagConstraints gcEqp = new GridBagConstraints();

        //Création des composants
        this.btAjouter = new Bouton("Ajouter <<", 100, 25);
        this.btRetirer = new Bouton("Retirer >>", 100, 25);
        this.btFermer = new Bouton("Fermer", 100, 25);
        this.lbEquipment = new JLabel("Équipement requis");
        this.lbEquipmentDispo = new JLabel("Équipement disponible");

        //Le tableau des équipement réservés
        this.tblEquipReserve = this.getTableEquipementReserve(listeEquipement);
        this.spListeEquipementReserve = new ListeDeroulante(tblEquipReserve,200,150);

        //Le tableau des équipements disponibles
        this.tblEquipDispo= getTableEquipement();
        this.spListeEquipmentDispo = new ListeDeroulante(tblEquipDispo,200,150);

        // Positionnement des composants sur la grille (boutons et tableau)
        gcEqp.insets = new Insets(5, 5, 3, 3);
        gcEqp.gridx=0;		gcEqp.gridy=0;
        pan.add(lbEquipment, gcEqp);
        gcEqp.gridx=2;		gcEqp.gridy=0;
        pan.add(lbEquipmentDispo, gcEqp);
        gcEqp.gridx=1;		gcEqp.gridy=1;
        pan.add(btAjouter, gcEqp);
        gcEqp.gridx=1;		gcEqp.gridy=2;
        pan.add(btRetirer, gcEqp);
        gcEqp.gridx=1;		gcEqp.gridy=4;
        gcEqp.anchor = GridBagConstraints.PAGE_END;
        pan.add(btFermer, gcEqp);
        gcEqp.gridx=0;		gcEqp.gridy=1;
        gcEqp.gridheight = 4;
        pan.add(spListeEquipementReserve,gcEqp);
        gcEqp.gridx=2; gcEqp.gridy=1;
        gcEqp.gridheight = 4;
        pan.add(spListeEquipmentDispo, gcEqp);
        this.setVisible(true);

        this.btAjouter.addActionListener(this);
        this.btRetirer.addActionListener(this);
        this.btFermer.addActionListener(this);
        this.tblEquipReserve.getModel().addTableModelListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();
        if (src == btAjouter) {
            Object[] possibleQt = {"1", "2", "3", "4","5"};
            String qt = (String) JOptionPane.showInputDialog(this, "Quantité requise", "Quantité", JOptionPane.INFORMATION_MESSAGE, null, possibleQt, possibleQt[0] );
            Object idEquipement = this.tblEquipDispo.getValueAt(this.tblEquipDispo.getSelectionModel().getMinSelectionIndex(), 0);
            ControleurEquipement.getInstance().reserverEquipement( (Integer)idEquipement, Integer.parseInt(qt));
            this.equipementReserveTableModel.fireTableDataChanged();
        }
        else if (src == btRetirer) {
            Object idEquipement = this.tblEquipReserve.getValueAt(this.tblEquipReserve.getSelectionModel().getMinSelectionIndex(), 1);
            ControleurEquipement.getInstance().retirerEquipement( (Integer)idEquipement );
            this.equipementReserveTableModel.fireTableDataChanged();
        }
        else if (src == btFermer) {
            this.setVisible(false);
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        // Lire la nouvelle quantité
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object quantite = model.getValueAt(row, column);
        JOptionPane msg = new JOptionPane(quantite);
    }

    private JTable getTableEquipement(){
        this.equipementTableModel = new ListeEquipementTableModel();
        JTable table = new JTable(this.equipementTableModel);
        // colonne du equipementID invisible
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setWidth(0);
        return table;
    }

    private JTable getTableEquipementReserve(ListeEquipement listeEquipement){
        this.equipementReserveTableModel = new ListeEquipementReserveTableModel(listeEquipement);
        JTable table = new JTable(this.equipementReserveTableModel);
        // colonnes de equipementId et reservationId invisibles
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setWidth(0);
        table.getColumnModel().getColumn(1).setMinWidth(0);
        table.getColumnModel().getColumn(1).setMaxWidth(0);
        table.getColumnModel().getColumn(1).setWidth(0);
        // largeur de la colonne quantité
        table.getColumnModel().getColumn(3).setMinWidth(20);
        table.getColumnModel().getColumn(3).setMaxWidth(40);
        return table;
    }
}
