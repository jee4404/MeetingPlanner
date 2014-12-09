package controleurs;

import java.sql.SQLException;
import business.*;
import dbmanager.ParticipantDBManager;
import dbmanager.ParticipationDBManager;
import view.frames.FenetreParticipants;

public class ControleurParticipant {
    private static ControleurParticipant controleurParticipant = new ControleurParticipant();
    private ListeParticipations listeParticipations;
    private Reunion reunion;

    /* A private Constructor prevents any other
    * class from instantiating.
    */
    private ControleurParticipant()
    {
        this.listeParticipations = null;
        this.reunion = null;
    }

    /* Static 'instance' method */
    public static ControleurParticipant getInstance( )
    {
        return controleurParticipant;
    }

    public void setListeParticipations(ListeParticipations listeParticipations)
    {
        this.listeParticipations = listeParticipations;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void afficherInviterParticipants(Reunion reunion)
    {
        try {
            this.setReunion(reunion);
            this.setListeParticipations(new ListeParticipations(reunion));
            this.listeParticipations.setParticipations(ParticipationDBManager.getInstance().trouverParticipationParReunion(reunion.getId()));
            FenetreParticipants fenetreParticipants = new FenetreParticipants(this.listeParticipations);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void inviterParticipant(int idEmploye)
    {
        try {
            // fetcher participant
            Participant participant = ParticipantDBManager.getInstance().trouverParticipant(idEmploye);

            if(participant == null)
                throw new RuntimeException("employé spécifié introuvable ("+idEmploye+")");

            // test si participation existe déja
            Participation participation = this.listeParticipations.trouverParticipationParIDParticipant(idEmploye);

            if( participation != null)
                throw new RuntimeException("cet employé a déjà été invité");

            // creer participation
            participation = new Participation(participant, this.reunion.getId() );

            // mettre liste participation à jour
            this.listeParticipations.ajouterParticipation(participation);
        }
        catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void retirerParticipation(int idParticipation)
    {
        try {
            Participation participation = this.listeParticipations.trouverParticipationParID(idParticipation);
            if(participation == null)
                throw new RuntimeException("participation introuvable");

            // retirer la participation de la liste de participation
            this.listeParticipations.enleverParticipation(participation.getId());
        }
        catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void repondreInvitation(int idReunion, int idEmploye, boolean rep, String motif){
    	  try {
			Participation participation = ParticipationDBManager.getInstance().trouverParticipantionParReunionParticipant(idReunion, idEmploye);
			participation.setParticipationConfirmee(rep);
			participation.setMotif(motif);
			ParticipationDBManager.getInstance().actualiserParticipation(participation);
    	} 
    	catch (SQLException ex) 
    	{
    		System.out.println(ex.getMessage());
		};
    	
    }
}
