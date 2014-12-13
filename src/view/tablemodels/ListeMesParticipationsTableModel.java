package view.tablemodels;

import business.Participant;
import business.Reunion;
import conf.Configuration;

import javax.swing.table.AbstractTableModel;

import java.util.List;

/**
 * Created by Rémy on 2014-12-02.
 */
public class ListeMesParticipationsTableModel extends AbstractTableModel {
    private List<Object[]> mesInvitations;

    public ListeMesParticipationsTableModel(List<Object[]> mesInvitations)
    {
        this.mesInvitations = mesInvitations;
    }

    @Override
    public int getRowCount() {
        return this.mesInvitations.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retVal = null;
        Participant tmpPart = (Participant)this.mesInvitations.get(rowIndex)[1];
        Reunion tmpReunion = (Reunion)this.mesInvitations.get(rowIndex)[0];
        switch (columnIndex)
        {
            case 0:
            	retVal = tmpPart.getIdEmploye();
                break;

            case 1:
                retVal = tmpReunion.getSujet();
                break;

            case 2:
                switch (tmpPart.getParticipeReunion())
                {
                    case Configuration.PARTICIPE_REUNION_NON:
                        retVal = "non";
                        break;

                    case Configuration.PARTICIPE_REUNION_NR:
                        retVal = "en attente";
                        break;

                    case Configuration.PARTICIPE_REUNION_OUI:
                        retVal = "oui";
                        break;
                }
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
                retVal = "ID Participant";
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
