package view.tablemodels;

import business.Employe;
import dbmanager.EmployeDBManager;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Rémy on 2014-11-29.
 */
public class ListeEmployeTableModel extends AbstractTableModel {
    private List<Employe> listeEmployes;

    public ListeEmployeTableModel()
    {
        this.listeEmployes = EmployeDBManager.getInstance().trouverTousEmployes();
    }

    // la taille de la liste des employes
    // on fait un count(*) sur la table employes
    @Override
    public int getRowCount()
    {
        return this.listeEmployes.size();
    }

    // les listes employes contiennent 2 colonnes :
    // id_employe, nom prenom
    @Override
    public int getColumnCount()
    {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Object retVal = null;
        switch (columnIndex){
            default:
                retVal = this.listeEmployes.get(rowIndex);
            break;

            case 0:
                retVal = this.listeEmployes.get(rowIndex).getId();
            break;

            case 1:
                retVal = this.listeEmployes.get(rowIndex).getNomComplet();
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
                retVal = "id employé";
            break;

            case 1:
                retVal = "Nom";
            break;
        }
        return retVal;
    }
}
