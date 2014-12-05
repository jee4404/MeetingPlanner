package controleurs;

import business.Employe;
import business.Reunion;
import business.SessionManager;
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

    public void afficheCreerReunion()
    {
        try
        {
            Reunion reunion = new Reunion();
            // TODO cast employe -> organisateur plus élégant
            reunion.setOrganisateur(OrganisateurDBManager.getInstance().trouverOrganisateur(SessionManager.getInstance().getEmploye().getId()));
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
            // on persiste la reunion en base de données
            ReunionDBManager.getInstance().creerReunion(reunion);
            // on notifie la liste "mes reunions" qu'une nouvelle reunion est disponible
            // il faut ajouter la reunion a la liste sur laquelle est lié le table model
            // ensuite on notifie que la source de donnée a changée
            SessionManager.getInstance().getListeMesReunions().add(reunion);
            SessionManager.getInstance().getListeMesReunionsTableModel().fireTableDataChanged();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
