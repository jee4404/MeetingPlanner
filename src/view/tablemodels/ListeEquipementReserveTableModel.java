package view.tablemodels;

import javax.swing.table.AbstractTableModel;
import business.ListeEquipement;

public class ListeEquipementReserveTableModel extends AbstractTableModel {
	private ListeEquipement listeEquipementReserve;
	
	public ListeEquipementReserveTableModel(ListeEquipement listeEquipementReserve)
    {
        this.listeEquipementReserve = listeEquipementReserve;
    }
	@Override
	public int getColumnCount() {
		return 4;
	}
	@Override
	public int getRowCount() {
		return this.listeEquipementReserve.getReservationEquipements().size();
	}
	
    @Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
	    Object retVal = null;

	    switch (columnIndex){
	        // id equipement
	        case 0:
	            retVal = this.listeEquipementReserve.getReservationEquipements().get(rowIndex).getId();
	            break;
            // id equipement
            case 1:
                retVal = this.listeEquipementReserve.getReservationEquipements().get(rowIndex).getEquipement().getId();
                break;
            // type équipement
	                
            case 2:
                retVal = this.listeEquipementReserve.getReservationEquipements().get(rowIndex).getEquipement().getTypeEquipement();
                break;

            case 3:
                retVal = this.listeEquipementReserve.getReservationEquipements().get(rowIndex).getQuantite();
        }
        return retVal;
    }

    // aucune cellule n'est editable
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        if (columnIndex == 3){
            return true;
        } else {
        return false;
        }
    }

	public String getColumnName(int columnIndex)
    {
        String retVal = "";
        switch (columnIndex){
            case 0:
                retVal = "CodeRsv";
                break;

            case 1:
                retVal = "CodeEqp";
                break;

            case 2:
                retVal = "Type";
                break;

            case 3:
                retVal = "Qt";
                break;
        }
        return retVal;
    }
}
