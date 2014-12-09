package business;

import java.util.List;

/**
 * Created by Rémy on 2014-11-19.
 */
public class ListeParticipations {
    private List<Participation> participations;
    private Reunion reunion;

    public ListeParticipations(){}

    public ListeParticipations(Reunion reunion)
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
    public void enleverParticipation(int idParticipation)
    {
        for(int i = 0; i < this.participations.size(); i++)
        {
            int tmpParticipationId = this.participations.get(i).getId();
            if( idParticipation == tmpParticipationId )
            {
                this.participations.remove(i);
                break;
            }
        }
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

    public Participation trouverParticipationParID(int idParticipation)
    {
        Participation retVal = null;
        for(int i = 0; i < this.participations.size(); i++)
        {
            int tmpParticipationId = this.participations.get(i).getId();
            if( idParticipation == tmpParticipationId )
            {
                retVal = this.participations.get(i);
                break;
            }
        }
        return retVal;
    }

    public Participation trouverParticipationParIDParticipant(int idParticipant)
    {
        Participation retVal = null;
        for(int i = 0; i < this.participations.size(); i++)
        {
            int tmpParticipantID = this.participations.get(i).getParticipant().getId();
            if( idParticipant == tmpParticipantID )
            {
                retVal = this.participations.get(i);
                break;
            }
        }
        return retVal;
    }


}
