package view.tablemodels;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dbmanager.EquipementDBManager;
import business.Equipement;

public class ListeEquipementTableModel extends AbstractTableModel  {
	private List<Equipement> listeEquipement;
	
	 public ListeEquipementTableModel()
	    {
	        try {
				this.listeEquipement = EquipementDBManager.getInstance().trouverTousEquipements();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.listeEquipement.size();
	}

	  @Override
	    public Object getValueAt(int rowIndex, int columnIndex)
	    {
	        Object retVal = null;
	        switch (columnIndex){
	            default:
	                retVal = this.listeEquipement.get(rowIndex);
	            break;

	            case 0:
	                retVal = this.listeEquipement.get(rowIndex).getId();
	            break;

	            case 1:
	                retVal = this.listeEquipement.get(rowIndex).getTypeEquipement();
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
                retVal = "Code";
            break;

            case 1:
                retVal = "Type";
            break;
        }
        return retVal;
    }
}
