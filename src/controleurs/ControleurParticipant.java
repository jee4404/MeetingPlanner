package controleurs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.Employe;
import business.ListeParticipations;
import business.Reunion;
import dbmanager.EmployeDBManager;
import dbmanager.ParticipationDBManager;
import view.frames.FenetreParticipants;

public class ControleurParticipant {
    private static ControleurParticipant controleurParticipant = new ControleurParticipant();
	   
    /* A private Constructor prevents any other
    * class from instantiating.
    */
    private ControleurParticipant(){ }

    /* Static 'instance' method */
    public static ControleurParticipant getInstance( )
    {
        return controleurParticipant;
    }

    public void afficherInviterParticipants(Reunion reunion)
    {
        try {
            ListeParticipations listeParticipations = new ListeParticipations(reunion);
            listeParticipations.setParticipations(ParticipationDBManager.getInstance().trouverParticipationParReunion(reunion.getId()));
            FenetreParticipants fenetreParticipants = new FenetreParticipants(listeParticipations);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void inviterParticipant(int id_employe)
    {

    }
}
