package controleurs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.Employe;
import dbmanager.EmployeDBManager;

public class ControleurParticipant {

	   private static ControleurParticipant controleurParticipant = new ControleurParticipant( );
	   
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private ControleurParticipant(){ }
	   
	   /* Static 'instance' method */
	   public static ControleurParticipant getInstance( ) {
	      return controleurParticipant;
	   }
	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for ControleurParticipant"); 
	   }
	   
	   /* Obtenir les employés de la base de donnée.*/
	   public List<Employe> getListEmploye(){
		EmployeDBManager instanceDBEmploye = EmployeDBManager.getInstance();
		List<Employe> lstEmploye = new ArrayList<Employe>();
		try {
			lstEmploye = instanceDBEmploye.trouverTousEmployes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstEmploye;
	}
}
