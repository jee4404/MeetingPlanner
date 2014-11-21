package business;

import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-19.
 */
@DatabaseTable(tableName = "listeparticipant")
public class ListeParticipants {
    @DatabaseField(generatedId = true, useGetSet = true)
    private Integer id;

    @ForeignCollectionField()
    private ForeignCollection<Participant> participants;

    @DatabaseField(foreign = true, useGetSet = true, canBeNull = true)
    private Reunion reunion;

    public ListeParticipants(){}

    public ListeParticipants(Reunion reunion)
    {
        this.reunion = reunion;
    }

    // orm get-set
    public Integer getId()
    {
        return this.id;
    }

    public Reunion getReunion()
    {
        return this.reunion;
    }

    public ForeignCollection<Participant> getParticipants()
    {
        return this.participants;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }
}
