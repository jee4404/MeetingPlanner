package controleurs;

import java.sql.SQLException;
import business.*;
import dbmanager.ParticipantDBManager;
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

    public void inviterParticipant(int idEmploye)
    {
        try {
            Employe employeParticipant = SessionManager.getInstance().getAnnuaireEmployes().trouverEmploye(idEmploye);

            if(employeParticipant == null)
                throw new RuntimeException("employé spécifié introuvable ("+idEmploye+")");

            // test si participation existe déja
            Participant participant = this.reunion.getListeParticipations().trouverParticipantParIDReunionIDEmploye(idEmploye, this.reunion.getId());

            // le id reunion du participant doit etre -1 car on a trouvé aucun participant donc on renvoit un participant
            // vide, qui par défaut à un id reunion à -1
            if( participant.getIdReunion() != -1 )
                throw new RuntimeException("cet employé a déjà été invité");

            // creer participant
            participant = new Participant(this.reunion.getId(), employeParticipant.getNom(), employeParticipant.getPrenom(), employeParticipant.getCourriel(), employeParticipant.getId() );

            // mettre liste participant à jour
            this.reunion.getListeParticipations().ajouterParticipant(participant);
        }
        catch (RuntimeException ex)
        {
            ex.printStackTrace();
        }
    }

    public void retirerParticipation(int idParticipant)
    {
        try
        {
            Participant participant = this.reunion.getListeParticipations().trouverParticipantParIDReunionIDEmploye(idParticipant, this.reunion.getId());

            // si participant non trouvé dans la liste, on renvoit un participant vide avec id = -1 par défaut
            if(participant.getIdEmploye() == -1)
                throw new RuntimeException("participation introuvable");

            // retirer la participation de la liste de participation
            this.reunion.getListeParticipations().enleverParticipant(participant);
        }
        catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void repondreInvitation(int idReunion, int idEmploye, int response, String motif)
    {
        try
        {
	        Participant participant = ParticipantDBManager.getInstance().trouverParticipantParReunionParticipant(idReunion, idEmploye);
            if( participant == null)
                throw new RuntimeException("Participant introuvable !");

            participant.setParticipeReunion(response);
            participant.setMotif(motif);
            ParticipantDBManager.getInstance().updateParticipant(participant);
    	} 
    	catch (SQLException ex) 
    	{
    		System.out.println(ex.getMessage());
		}
        catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
