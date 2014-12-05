package view.tablemodels;

import business.Participation;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Rémy on 2014-12-02.
 */
public class ListeMesParticipationsTableModel extends AbstractTableModel {
    private List<Participation> participations;

    public ListeMesParticipationsTableModel(List<Participation> participations)
    {
        this.participations = participations;
    }

    @Override
    public int getRowCount() {
        return this.participations.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retVal = null;

        switch (columnIndex)
        {
            case 0:
                retVal = this.participations.get(rowIndex).getId();
                break;

            case 1:
                retVal = this.participations.get(rowIndex).getReunion().getSujet();
                break;

            case 2:
                if( this.participations.get(rowIndex).getParticipationConfirmee() )
                {
                    retVal = "oui";
                }
                else
                    retVal = "non";
                break;
        }

        return retVal;
    }

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
                retVal = "ID Participation";
                break;

            case 1:
                retVal = "Objet de la Réunion";
                break;

            case 2:
                retVal = "Participation";
                break;
        }
        return retVal;
    }
}
