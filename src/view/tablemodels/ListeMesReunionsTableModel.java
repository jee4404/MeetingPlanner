package view.tablemodels;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import dbmanager.OrganisateurDBManager;
import dbmanager.ReunionDBManager;
import business.Employe;
import business.Reunion;
import business.Organisateur;

public class ListeMesReunionsTableModel extends AbstractTableModel {
	private Organisateur organisateur;
	private List<Reunion> reunionsOrganisees;
	
	public ListeMesReunionsTableModel(Employe employe)
	{
		try {
			this.organisateur = OrganisateurDBManager.getInstance().trouverOrganisateur(employe.getId());
			this.reunionsOrganisees = ReunionDBManager.getInstance().trouverReunionParOrganisateur(organisateur.getId());
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
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
