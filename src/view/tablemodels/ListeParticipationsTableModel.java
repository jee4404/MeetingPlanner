package view.tablemodels;

import business.ListeParticipations;

import javax.swing.table.AbstractTableModel;

/**
 * Created by Rémy on 2014-11-29.
 */
public class ListeParticipationsTableModel extends AbstractTableModel {
    private ListeParticipations listeParticipations;

    public ListeParticipationsTableModel(ListeParticipations listeParticipations)
    {
        this.listeParticipations = listeParticipations;
    }

    @Override
    public int getRowCount()
    {
        return this.listeParticipations.getParticipants().size();
    }

    // on affiche id_participationm id_employé et nom employé
    @Override
    public int getColumnCount()
    {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Object retVal = null;

        switch (columnIndex){
            // id reunion
            case 0:
                retVal = this.listeParticipations.getParticipants().get(rowIndex).getIdReunion();
                break;
            // id employé
            case 1:
                retVal = this.listeParticipations.getParticipants().get(rowIndex).getIdEmploye();
                break;
            // nom employé
            case 2:
                retVal = this.listeParticipations.getParticipants().get(rowIndex).getEmploye().getNomComplet();
                break;
        }
        return retVal;
    }

    // aucune cellule n'est editable
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String retVal = "";
        switch (columnIndex){
            case 0:
                retVal = "id reunion";
                break;

            case 1:
                retVal = "id employé";
                break;

            case 2:
                retVal = "Nom";
                break;
        }
        return retVal;
    }
}
