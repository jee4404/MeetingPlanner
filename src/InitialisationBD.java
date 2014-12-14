import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import business.Employe;
import business.Equipement;
import business.Local;
import business.Organisateur;
import business.Reunion;
import dbmanager.EmployeDBManager;
import dbmanager.EquipementDBManager;
import dbmanager.LocalDBManager;
import dbmanager.OrganisateurDBManager;
import dbmanager.ReunionDBManager;



public class InitialisationBD {
	
	public static void remplirDBOrganisateur(){
		try {
			Organisateur organisateur1 = OrganisateurDBManager.getInstance().trouverOrganisateur(1);
			Organisateur organisateur5 = OrganisateurDBManager.getInstance().trouverOrganisateur(3);
			Organisateur organisateur8 = OrganisateurDBManager.getInstance().trouverOrganisateur(8);
			OrganisateurDBManager.getInstance().creerOrganisateur(organisateur1);
			OrganisateurDBManager.getInstance().creerOrganisateur(organisateur5);
			OrganisateurDBManager.getInstance().creerOrganisateur(organisateur8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void creerReunion1(){
		Date date1 = new Date();
		Date heure1 = new Date();
		Date duree1 = new Date();
		String heure2;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat heureFormat = new SimpleDateFormat("K:mm");
		try {
			date1 = dateFormat.parse("12/12/2014");
			heure1 = heureFormat.parse("13:00");
			heure2 = heureFormat.format(heure1);
			duree1 = heureFormat.parse("1:30");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Reunion reunion1 = new Reunion();
		try {
			//Organisateur organisateur = new Organisateur(EmployeDBManager.getInstance().trouverEmploye(1));
			reunion1.setOrganisateur(OrganisateurDBManager.getInstance().trouverOrganisateur(1));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reunion1.setDateReunion(date1);
		reunion1.setHeureReunion(heure1);
		reunion1.setDureeReunion(duree1);
		reunion1.setEstRecurente(false);
		reunion1.setNbParticipants(10);
		reunion1.setSujet("Revue projet xyz");
		try {
			ReunionDBManager.getInstance().creerReunion(reunion1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void remplirDBEmploye(){
		try {
	        // test orm lite - methode 1, creation objet par constructeur
	        EmployeDBManager employeDBManager = EmployeDBManager.getInstance();
	        Employe testEmploye = new Employe("foo", "bar", "foo@bar.com");
	        Employe testEmploye1 = new Employe("Jean","Auger","AugerJ12@uqo.ca" );
	        Employe testEmploye2 = new Employe("Mireille","Bédard","BedardM19@uqo.ca");
	        Employe testEmploye3 = new Employe("Chang","Choi","ChoiC1@uqo.ca");
	        Employe testEmploye4 = new Employe("Marie","Dion","DionM34@uqo.ca");
	        Employe testEmploye5 = new Employe("Timothy","Eaton", "EatonT1@uqo.ca");
	        Employe testEmploye6 = new Employe("Hans","Faust", "FaustH1@uqo.ca");
	        Employe testEmploye7 = new Employe("Jimmy","Giacona", "GiaconaJ2@uqo.ca");
	        Employe testEmploye8 = new Employe("Noëlla","Hétu","HetuN4@uqo.ca");
	        Employe testEmploye9 = new Employe("Zhuang","Ing", "IngZ1@uqo.ca");
            employeDBManager.creerEmploye(testEmploye);
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
	        LocalDBManager localDBManager = LocalDBManager.getInstance();
	        Local testLocal = new Local();
	        testLocal.setCapacite(20);
	        testLocal.setCode("0E3C");
	        localDBManager.creerLocal(testLocal);
	        Local testLocal1 = new Local();
	        testLocal1.setCapacite(10);
	        testLocal1.setCode("A0304");
	        localDBManager.creerLocal(testLocal1);
	        Local testLocal2 = new Local();
	        testLocal2.setCapacite(5);
	        testLocal2.setCode("B0432");
	        localDBManager.creerLocal(testLocal2);
	        Local testLocal3 = new Local();
	        testLocal3.setCapacite(10);
	        testLocal3.setCode("B5232");
	        localDBManager.creerLocal(testLocal3);
	        Local testLocal4 = new Local();
	        testLocal4.setCapacite(15);
	        testLocal4.setCode("A1265");
	        localDBManager.creerLocal(testLocal4);
	        
	        
		}
		 catch (SQLException ex)
	    {
	        System.out.println(ex.getMessage());
	    }
	}

    public static void remplirDBEquipement(){
    	try {
			EquipementDBManager instanceDBEquipement = EquipementDBManager.getInstance();
	        Equipement testEquip1 = new Equipement();
	        testEquip1.setTypeEquipement("Projecteur");
	        testEquip1.setDescription("Projecteur portable");
	        instanceDBEquipement.creerEquipement(testEquip1);
	        Equipement testEquip2 = new Equipement();
	        testEquip2.setTypeEquipement("Retro-projecteur");
	        testEquip2.setDescription("Projecteur portable");
	        instanceDBEquipement.creerEquipement(testEquip2);
	        Equipement testEquip3 = new Equipement();
	        testEquip3.setTypeEquipement("Ordinateur portable");
	        testEquip3.setDescription("Système exploitation W7");
	        instanceDBEquipement.creerEquipement(testEquip3);
	        Equipement testEquip4 = new Equipement();
	        testEquip4.setTypeEquipement("Tableau blanc");
	        testEquip4.setDescription("Portable 60cm x 90cm");
	        instanceDBEquipement.creerEquipement(testEquip4);
	        Equipement testEquip5 = new Equipement();
	        testEquip5.setTypeEquipement("Tableau feuille");
	        testEquip5.setDescription("Portable 60cm x 90cm");
	        instanceDBEquipement.creerEquipement(testEquip5);
	        Equipement testEquip6 = new Equipement();
	        testEquip6.setTypeEquipement("Écran");
	        testEquip6.setDescription("Fixe");
	        instanceDBEquipement.creerEquipement(testEquip6);
	        Equipement testEquip7 = new Equipement();
	        testEquip7.setTypeEquipement("Micro");
	        testEquip7.setDescription("Portable");
	        instanceDBEquipement.creerEquipement(testEquip7);
		}
		 catch (SQLException ex)
	    {
	        System.out.println(ex.getMessage());
	    }
    	
    }
}
