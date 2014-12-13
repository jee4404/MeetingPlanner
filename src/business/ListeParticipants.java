package business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémy on 2014-11-19.
 */
public class ListeParticipants {
    private List<Participant> participants;

    public ListeParticipants()
    {
        this.participants = new ArrayList<Participant>();
    }

    public ListeParticipants(List<Participant> participants)
    {
        this.participants = participants;
    }

    public void ajouterParticipant(Participant participants)
    {
        this.participants.add(participants);
    }

    public void enleverParticipant(Participant participant)
    {
        //this.participants.stream().filter( p -> p.getId() == participant.getId()).peek(this.participants::remove);
        for(int i = 0; i < this.participants.size(); i++)
        {
            int tmpParticipantID = this.participants.get(i).getIdEmploye();
            if( participant.getIdEmploye() == tmpParticipantID )
            {
                this.participants.remove(i);
                break;
            }
        }
    }

    public List<Participant> getParticipants()
    {
        return this.participants;
    }

    public void setParticipations(List<Participant> participant)
    {
        this.participants = participant;
    }

    public Participant trouverParticipantParIDEmploye(int idEmploye)
    {
        return this.participants.stream().filter( p -> p.getIdEmploye() == idEmploye).findFirst().orElse(new Participant());
    }

    public Participant trouverParticipantParIDReunionIDEmploye(int idEmploye, int idReunion)
    {
        return this.participants.stream().filter( p -> p.getIdEmploye() == idEmploye && p.getIdReunion() == idReunion).findFirst().orElse(new Participant());
    }


}
