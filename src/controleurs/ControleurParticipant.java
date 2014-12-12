package controleurs;

import java.sql.SQLException;
import business.*;
import dbmanager.ParticipantDBManager;
import dbmanager.ParticipationDBManager;
import view.frames.FenetreParticipants;

public class ControleurParticipant {
    private static ControleurParticipant controleurParticipant = new ControleurParticipant();
    private Reunion reunion;

    /* A private Constructor prevents any other
    * class from instantiating.
    */
    private ControleurParticipant()
    {
        this.reunion = null;
    }

    /* Static 'instance' method */
    public static ControleurParticipant getInstance( )
    {
        return controleurParticipant;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void afficherInviterParticipants(Reunion reunion)
    {
        this.setReunion(reunion);
        FenetreParticipants fenetreParticipants = new FenetreParticipants(reunion.getListeParticipations());
    }

    public void inviterParticipant(Integer idEmploye)
    {
        try {
            // fetcher participant
            // TODO il faut le trouver dans le catalogue pour éviter un select sql
            //Participant participant = ParticipantDBManager.getInstance().trouverParticipant(idEmploye);
            Participant participant = SessionManager.getInstance().getAnnuaireEmployes().getParticipant(idEmploye);

            if(participant == null)
                throw new RuntimeException("employé spécifié introuvable ("+idEmploye+")");

            // test si participation existe déja
            Participation participation = this.reunion.getListeParticipations().trouverParticipationParIDParticipant(idEmploye);

            if( participation != null)
                throw new RuntimeException("cet employé a déjà été invité");

            // creer participation
            participation = new Participation(participant, this.reunion.getId() );

            // mettre liste participation à jour
            this.reunion.getListeParticipations().ajouterParticipation(participation);
        }
        catch (RuntimeException ex)
        {
            ex.printStackTrace();
        }
    }

    public void retirerParticipation(int idParticipation)
    {
        try {
            Participation participation = this.reunion.getListeParticipations().trouverParticipationParID(idParticipation);
            if(participation == null)
                throw new RuntimeException("participation introuvable");

            // retirer la participation de la liste de participation
            this.reunion.getListeParticipations().enleverParticipation(participation.getId());
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
