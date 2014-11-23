package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-23.
 */
@DatabaseTable(tableName = "participation")
public class Participation {
    @DatabaseField(generatedId = true, canBeNull = false )
    private Integer id;

    @DatabaseField(foreign = true, useGetSet = true)
    private Participant participant;

    @DatabaseField(foreign = true, useGetSet = true)
    private Reunion reunion;

    @DatabaseField
    private boolean participationConfirmee;

    public Participation()
    {
        this.id = 0;
        this.participant = null;
        this.reunion = null;
        this.participationConfirmee = false;
    }

    public Participation(Participant participant, Reunion reunion, boolean participationConfirmee)
    {
        this.id = 0;
        this.participant = participant;
        this.reunion = reunion;
        this.participationConfirmee = participationConfirmee;
    }

    public Participant getParticipant()
    {
        return this.participant;
    }

    public Reunion getReunion()
    {
        return this.reunion;
    }

    public boolean getParticipationConfirmee()
    {
        return this.participationConfirmee;
    }

    public void setParticipant(Participant participant)
    {
        this.participant = participant;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void setParticipationConfirmee(boolean participationConfirmee)
    {
        this.participationConfirmee = participationConfirmee;
    }
}
