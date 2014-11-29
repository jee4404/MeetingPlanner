package business;

import com.j256.ormlite.dao.EagerForeignCollection;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import dbmanager.ParticipationDBManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rémy on 2014-11-19.
 */
public class ListeParticipations {
    private List<Participation> participations;
    private Reunion reunion;

    public ListeParticipations(){}

    public ListeParticipations(Reunion reunion) throws SQLException
    {
        this.reunion = reunion;
        this.participations = null;
    }

    public ListeParticipations(Reunion reunion, List<Participation> participations)
    {
        this.reunion = reunion;
        this.participations = participations;
    }

    // TODO : il faut ajouter la ligne de participation en base
    // TODO : a faire dans le controleur
    public void ajouterParticipation(Participation participation)
    {
        this.participations.add(participation);
    }

    // TODO : il faut supprimer la ligne de participation en base
    // TODO : a faire dans le controleur
    public void enleverParticipation(Participation participation)
    {
        this.participations.remove(participation);
    }

    public Reunion getReunion()
    {
        return this.reunion;
    }

    public List<Participation> getParticipations()
    {
        return this.participations;
    }

    // TODO : il faut mettre la ligne de participation en base à jour
    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    // ne devrait pas être utilié
    public void setParticipations(List<Participation> participations)
    {
        this.participations = participations;
    }
}