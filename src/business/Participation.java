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

    @DatabaseField(foreign = true, useGetSet = true, foreignAutoRefresh = true)
    private Participant participant;

    @DatabaseField(useGetSet = true)
    private int idReunion;

    @DatabaseField
    private boolean participationConfirmee;
    
    @DatabaseField
    private String motif;

    public Participation()
    {
        this.participant = null;
        this.idReunion = 0;
        this.participationConfirmee = false;
        this.motif = "";
    }

    public Participation(Participant participant, int idReunion, boolean participationConfirmee)
    {
        this.participant = participant;
        this.idReunion = idReunion;
        this.participationConfirmee = participationConfirmee;
    }

    public Participation(Participant participant, int idReunion)
    {
        this.participant = participant;
        this.idReunion = idReunion;
    }
    public Integer getId()
    {
        return this.id;
    }

    public Participant getParticipant()
    {
        return this.participant;
    }

    public int getReunion()
    {
        return this.idReunion;
    }

    public boolean getParticipationConfirmee()
    {
        return this.participationConfirmee;
    }

    public void setParticipant(Participant participant)
    {
        this.participant = participant;
    }

    public void setReunion(int idReunion)
    {
        this.idReunion = idReunion;
    }

    public void setParticipationConfirmee(boolean participationConfirmee)
    {
        this.participationConfirmee = participationConfirmee;
    }
    
    public void setMotif(String motif)
    {
    	this.motif = motif;
    }
}
