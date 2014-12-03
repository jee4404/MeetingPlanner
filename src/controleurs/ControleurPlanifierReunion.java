package controleurs;

import business.Employe;
import business.Reunion;
import dbmanager.OrganisateurDBManager;
import dbmanager.ReunionDBManager;
import view.frames.FenetreReunion;
import java.sql.SQLException;

public class ControleurPlanifierReunion {
    private static ControleurPlanifierReunion controleurPlanifierReunion = new ControleurPlanifierReunion( );
    /* A private Constructor prevents any other
    * class from instantiating.
    */
	private ControleurPlanifierReunion(){}

    public static ControleurPlanifierReunion getInstance( ) {
	      return controleurPlanifierReunion;
	   }

    public void afficheCreerReunion(Employe employeConnecte)
    {
        try
        {
            Reunion reunion = new Reunion();
            // TODO cast employe -> organisateur plus élégant
            reunion.setOrganisateur(OrganisateurDBManager.getInstance().trouverOrganisateur(employeConnecte.getId()));
            FenetreReunion fenetreReunion = new FenetreReunion(reunion);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void creerReunion(Reunion reunion)
    {
        try
        {
            ReunionDBManager.getInstance().creerReunion(reunion);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
