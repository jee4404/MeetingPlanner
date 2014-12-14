package view.tablemodels;


import javax.swing.table.AbstractTableModel;
import business.InventaireEquipement;
import business.SessionManager;

public class ListeEquipementTableModel extends AbstractTableModel  {
	private InventaireEquipement inventaireEquipement;
	
	public ListeEquipementTableModel()
	{
		 this.inventaireEquipement = SessionManager.getInstance().getInventaireEquipement();
	}
	 
	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return this.inventaireEquipement.getLstEquipement().size();
	}

	  @Override
	    public Object getValueAt(int rowIndex, int columnIndex)
	    {
	        Object retVal = null;
	        switch (columnIndex){
	            default:
	                retVal = this.inventaireEquipement.getLstEquipement().get(rowIndex);
	            break;

	            case 0:
	                retVal = this.inventaireEquipement.getLstEquipement().get(rowIndex).getId();
	            break;

	            case 1:
	                retVal = this.inventaireEquipement.getLstEquipement().get(rowIndex).getTypeEquipement();
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
