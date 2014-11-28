import java.sql.SQLException;

import business.Employe;
import business.Equipement;
import business.Local;
import dbmanager.EmployeDBManager;
import dbmanager.EquipementDBManager;
import dbmanager.LocalDBManager;


public class InitialisationBD {
	
	public static void remplirDBEmploye(){
		try {
			if(false)
				throw new SQLException("bouh");
	        // test orm lite - methode 1, creation objet par constructeur
	        EmployeDBManager employeDBManager = EmployeDBManager.getInstance();
	        Employe testEmploye = new Employe("foo", "bar", "foo@bar.com");
	        employeDBManager.creerEmploye(testEmploye);
	        Employe testEmploye1 = new Employe("Jean","Auger","AugerJ12@uqo.ca" );
	        Employe testEmploye2 = new Employe("Mireille","Bédard","BedardM19@uqo.ca");
	        Employe testEmploye3 = new Employe("Chang","Choi","ChoiC1@uqo.ca");
	        Employe testEmploye4 = new Employe("Marie","Dion","DionM34@uqo.ca");
	        Employe testEmploye5 = new Employe("Timothy","Eaton", "EatonT1@uqo.ca");
	        Employe testEmploye6 = new Employe("Hans","Faust", "FaustH1@uqo.ca");
	        Employe testEmploye7 = new Employe("Jimmy","Giacona", "GiaconaJ2@uqo.ca");
	        Employe testEmploye8 = new Employe("Noëlla","Hétu","HetuN4@uqo.ca");
	        Employe testEmploye9 = new Employe("Zhuang","Ing", "IngZ1@uqo.ca");
	        employeDBManager.creerEmploye(testEmploye1);
	        employeDBManager.creerEmploye(testEmploye2);
	        employeDBManager.creerEmploye(testEmploye3);
	        employeDBManager.creerEmploye(testEmploye4);
	        employeDBManager.creerEmploye(testEmploye5);
	        employeDBManager.creerEmploye(testEmploye6);
	        employeDBManager.creerEmploye(testEmploye7);
	        employeDBManager.creerEmploye(testEmploye8);
	        employeDBManager.creerEmploye(testEmploye9);
	        
		 }
	    catch (SQLException ex)
	    {
	        System.out.println(ex.getMessage());
	    }
	}
		
	public static void remplirDBLocal(){
		try {
			if(false)
				throw new SQLException("bouh");
			// test avec classe local
	        LocalDBManager localDBManager = LocalDBManager.getInstance();
	        Local testLocal = new Local("0E3C", 20);
	        localDBManager.creerLocal(testLocal);
	      
		}
		 catch (SQLException ex)
	    {
	        System.out.println(ex.getMessage());
	    }
	}

    public static void remplirDBEquipement(){
    	try {
			if(false)
				throw new SQLException("bouh");
			// test avec classe local
			EquipementDBManager instanceDBEquipement = EquipementDBManager.getInstance();
	        Equipement testEquip1 = new Equipement();
	        testEquip1.setTypeEquipement("Projecteur");
	        testEquip1.setDesiption("Projecteur portable");
	        instanceDBEquipement.creerEquipement(testEquip1);
	        Equipement testEquip2 = new Equipement();
	        testEquip2.setTypeEquipement("Retro-projecteur");
	        testEquip2.setDesiption("Projecteur portable");
	        instanceDBEquipement.creerEquipement(testEquip2);
	        Equipement testEquip3 = new Equipement();
	        testEquip3.setTypeEquipement("Ordinateur portable");
	        testEquip3.setDesiption("Système exploitation W7");
	        instanceDBEquipement.creerEquipement(testEquip3);
	        Equipement testEquip4 = new Equipement();
	        testEquip4.setTypeEquipement("Tableau blanc");
	        testEquip4.setDesiption("Portable 60cm x 90cm");
	        instanceDBEquipement.creerEquipement(testEquip4);
	        Equipement testEquip5 = new Equipement();
	        testEquip5.setTypeEquipement("Tableau feuille");
	        testEquip5.setDesiption("Portable 60cm x 90cm");
	        instanceDBEquipement.creerEquipement(testEquip5);
	        Equipement testEquip6 = new Equipement();
	        testEquip6.setTypeEquipement("Écran");
	        testEquip6.setDesiption("Fixe");
	        instanceDBEquipement.creerEquipement(testEquip6);
	        Equipement testEquip7 = new Equipement();
	        testEquip7.setTypeEquipement("Micro");
	        testEquip7.setDesiption("Portable");
	        instanceDBEquipement.creerEquipement(testEquip7);
		}
		 catch (SQLException ex)
	    {
	        System.out.println(ex.getMessage());
	    }
    	
    }
}
