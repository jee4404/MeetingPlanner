package view.tablemodels;

import business.AnnuaireEmployes;
import business.SessionManager;

import javax.swing.table.AbstractTableModel;



/**
 * Created by Rémy on 2014-11-29
 */
public class ListeEmployeTableModel extends AbstractTableModel {
    private AnnuaireEmployes annuaireEmployes;

    public ListeEmployeTableModel()
    {
			this.annuaireEmployes = SessionManager.getInstance().getAnnuaireEmployes();
    }

    // la taille de la liste des employes
    // on fait un count(*) sur la table employes
    @Override
    public int getRowCount()
    {
        return this.annuaireEmployes.getLstEmploye().size();
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
                retVal = this.annuaireEmployes.getLstEmploye().get(rowIndex);
            break;

            case 0:
                retVal = this.annuaireEmployes.getLstEmploye().get(rowIndex).getId();
            break;

            case 1:
                retVal = this.annuaireEmployes.getLstEmploye().get(rowIndex).getNomComplet();
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
                retVal = "Code Employé";
            break;

            case 1:
                retVal = "Nom";
            break;
        }
        return retVal;
    }
}
