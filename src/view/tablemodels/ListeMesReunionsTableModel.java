package view.tablemodels;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import business.Reunion;

public class ListeMesReunionsTableModel extends AbstractTableModel {
	private List<Reunion> reunionsOrganisees;
	
	public ListeMesReunionsTableModel(List<Reunion> reunionsOrganisees)
	{
		this.reunionsOrganisees = reunionsOrganisees;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.reunionsOrganisees.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		Object retVal = null;
		switch(colIndex)
		{
			case 0:
				retVal = this.reunionsOrganisees.get(rowIndex).getId();
				break;
				
			case 1:
				retVal = this.reunionsOrganisees.get(rowIndex).getSujet();
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
                retVal = "ID réunion";
            break;

            case 1:
                retVal = "Objet Reunion";
            break;
        }
        return retVal;
    }

}
