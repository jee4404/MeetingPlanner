package business;

import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

/**
 * Created by Rémy on 2014-11-19.
 */
public class ListeParticipants {
    private List<Participation> participations;
    private Reunion reunion;

    public ListeParticipants(){}

    public ListeParticipants(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void ajouterParticipant(Participant participant)
    {
        this.participations.add(participant);
    }

    public void enleverParticipant(Participant participant)
    {
        this.participations.remove(participant);
    }

    // orm get-set
    public Reunion getReunion()
    {
        return this.reunion;
    }

    public List<Participation> getParticipants()
    {
        return this.participations;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void setParticipants(List<Employe> participants)
    {
        this.participations = participants;
    }
}
