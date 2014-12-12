package business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémy on 2014-11-19.
 */
public class ListeParticipations {
    private List<Participation> participations;

    public ListeParticipations()
    {
        this.participations = new ArrayList<Participation>();
    }

    public ListeParticipations(List<Participation> participations)
    {
        this.participations = participations;
    }

    public void ajouterParticipation(Participation participation)
    {
        this.participations.add(participation);
    }

    public void enleverParticipation(int idParticipation)
    {
        //this.participations.stream().filter( p -> p.getId() == idParticipation).peek(this.participations::remove);
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

    public List<Participation> getParticipations()
    {
        return this.participations;
    }

    // ne devrait pas être utilié
    public void setParticipations(List<Participation> participations)
    {
        this.participations = participations;
    }

    public Participation trouverParticipationParID(int idParticipation)
    {
        return this.participations.stream().filter( p -> p.getId() == idParticipation).findFirst().orElse(new Participation());
    }

    public Participation trouverParticipationParIDParticipant(int idParticipant)
    {
        return this.participations.stream().filter( p -> p.getParticipant().getId() == idParticipant).findFirst().orElse(new Participation());
    }


}
