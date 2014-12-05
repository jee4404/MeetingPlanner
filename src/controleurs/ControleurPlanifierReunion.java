package controleurs;

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

    public void afficheCreerReunion() throws SQLException
    {
        Reunion reunion = new Reunion();
        // TODO cast employe -> organisateur plus élégant
        reunion.setOrganisateur(OrganisateurDBManager.getInstance().trouverOrganisateur(SessionManager.getInstance().getEmploye().getId()));
        FenetreReunion fenetreReunion = new FenetreReunion(reunion);
    }

    public void creerReunion(Reunion reunion) throws SQLException
    {
        //teste si la reunion existe en base, on update
        if(reunion.getId() != null )
        {
            ReunionDBManager.getInstance().updateReunion(reunion);
        }
        else // sinon on crée
        {
            // on persiste la reunion en base de données
            ReunionDBManager.getInstance().creerReunion(reunion);
            // on notifie la liste "mes reunions" qu'une nouvelle reunion est disponible
            // il faut ajouter la reunion a la liste sur laquelle est lié le table model
            // ensuite on notifie que la source de donnée a changée
            SessionManager.getInstance().getListeMesReunions().add(reunion);
            SessionManager.getInstance().getListeMesReunionsTableModel().fireTableDataChanged();
        }
    }

    public void afficheModifierReunion(int idReunion) throws SQLException, RuntimeException
    {
        Reunion reunion = ReunionDBManager.getInstance().trouverReunion(idReunion);

        if(reunion == null)
            throw new RuntimeException("reunion introuvable");

        FenetreReunion fenetreReunion = new FenetreReunion(reunion);
    }
}
