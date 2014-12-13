package controleurs;

import java.sql.SQLException;

import business.SessionManager;
import view.frames.FenetrePlanificateurReunion;
import dbmanager.EmployeDBManager;
import business.Employe;

public class ControleurAcceuil {
    private static ControleurAcceuil controleurAcceuil = new ControleurAcceuil( );

    /* A private Constructor prevents any other
    * class from instantiating.
    */
    private ControleurAcceuil(){ }

    /* Static 'instance' method */
    public static ControleurAcceuil getInstance( ) {
      return controleurAcceuil;
    }

    public void login(String courriel)
    {
        try
        {
            Employe employe = EmployeDBManager.getInstance().trouverEmployeParCourriel(courriel);

            // teste si employe trouve
            if(employe == null)
               throw new RuntimeException("Cette adresse courriel n'existe pas");

            SessionManager.getInstance().initManager(employe);
            FenetrePlanificateurReunion planificateurReunion = new FenetrePlanificateurReunion();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (RuntimeException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void exitApplication()
    {
        System.exit(0);
    }
}