package controleurs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import business.Employe;
import business.Equipement;
import dbmanager.EmployeDBManager;
import dbmanager.EquipementDBManager;

public class ControleurEquipement {

	   private static ControleurEquipement controleurEquipement = new ControleurEquipement( );
	   
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private ControleurEquipement(){ }
	   
	   /* Static 'instance' method */
	   public static ControleurEquipement getInstance( ) {
	      return controleurEquipement;
	   }
	   /* Other methods protected by singleton-ness */
	   protected static void demoMethod( ) {
	      System.out.println("demoMethod for ControleurEquipement"); 
	   }
	   /* Obtenir les équipements de la base de donnée.*/
	   public List<Equipement> getListEquipement(){
		EquipementDBManager instanceDBEquipement = EquipementDBManager.getInstance();
		List<Equipement> lstEquipement = new ArrayList<Equipement>();
		try {
			lstEquipement = instanceDBEquipement.trouverTousEquipements();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstEquipement;
	}
	   
	   
	}
