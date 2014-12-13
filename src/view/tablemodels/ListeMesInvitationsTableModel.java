package view.tablemodels;

import business.ListeParticipants;
import business.Participant;
import business.Reunion;
import business.SessionManager;
import conf.Configuration;

import javax.swing.table.AbstractTableModel;

import java.util.List;

/**
 * Created by Rémy on 2014-12-02.
 */
public class ListeMesInvitationsTableModel extends AbstractTableModel {
    private List<Reunion> mesInvitations;

    public ListeMesInvitationsTableModel(List<Reunion> mesInvitations)
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
        Reunion reunionSelectionnee = this.mesInvitations.get(rowIndex);
        Participant participant = reunionSelectionnee.getListeParticipants().trouverParticipantParIDEmploye(SessionManager.getInstance().getEmploye().getId());
        switch (columnIndex)
        {
            case 0:
            	retVal = reunionSelectionnee.getId();
                break;

            case 1:
                retVal = reunionSelectionnee.getSujet();
                break;

            case 2:
                switch (participant.getParticipeReunion())
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
                retVal = "ID Réunion";
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
