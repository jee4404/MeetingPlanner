package controleurs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import view.frames.FenetreEquipement;
import view.frames.FenetreParticipants;
import business.Equipement;
import business.ListeEquipement;
import business.ListeParticipations;
import business.Participant;
import business.Participation;
import business.ReservationEquipement;
import business.Reunion;
import dbmanager.EquipementDBManager;
import dbmanager.ParticipantDBManager;
import dbmanager.ParticipationDBManager;
import dbmanager.ReservationEquipementDBManager;

public class ControleurEquipement {

	   private static ControleurEquipement controleurEquipement = new ControleurEquipement();
	    private ListeEquipement listeEquipReserve;
	    private Reunion reunion;
	    private FenetreEquipement fenetreEquipement;
	   /* A private Constructor prevents any other 
	    * class from instantiating.
	    */
	   private ControleurEquipement(){
	        this.listeEquipReserve = null;
	        this.reunion = null;
	        this.fenetreEquipement = null;
	   }
	   
	   /* Static 'instance' method */
	   public static ControleurEquipement getInstance() {
	      return controleurEquipement;
	   }
	    public void setListeEquipement(ListeEquipement listeEquipement)
	    {
	        this.listeEquipReserve = listeEquipement;
	    }

	    public void setReunion(Reunion reunion)
	    {
	        this.reunion = reunion;
	    }
	   
	    public void choisirEquipement(Reunion reunion)

	    {
	        try {
	            this.setReunion(reunion);
	            this.setListeEquipement(new ListeEquipement(reunion));
	            this.listeEquipReserve.setReservationEquipements(ReservationEquipementDBManager.getInstance().trouverEquipementsParReunion((int)reunion.getId()));
	            this.fenetreEquipement = new FenetreEquipement(this.listeEquipReserve);
	        }
	        catch(SQLException ex)
	        {
	            System.out.println(ex.getMessage());
	        }
	    }
	    public void reserverEquipement(int idEquipement)
	    {
	        try {
	            // fetcher equipement
	            Equipement equipement = EquipementDBManager.getInstance().trouverEquipement(idEquipement);
	            if(equipement == null)
	                throw new RuntimeException("équipement spécifié introuvable ("+idEquipement+")");

	            // test si reservation existe déja
	            ReservationEquipement reservationEquip = ReservationEquipementDBManager.getInstance().trouverReservationParReunionEquipement((int)this.reunion.getId(), idEquipement);

	            if( reservationEquip != null)
	                throw new RuntimeException("cet équipement a déjà été réservé");

	            // creer réservation
	            reservationEquip = new ReservationEquipement(equipement, this.reunion,1);

	            // persister participation
	            ReservationEquipementDBManager.getInstance().creerReservation(reservationEquip);

	            // mettre liste participation à jour
	            this.listeEquipReserve.ajouterReservation(reservationEquip);
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
	    
	    public void retirerEquipement(int idReservation)
	    {
	        try {
	            ReservationEquipement reservation = ReservationEquipementDBManager.getInstance().trouverReservation(idReservation);
	            if(reservation == null)
	                throw new RuntimeException("reservation introuvable");

	            // retirer la participation de la liste de participation
	            this.listeEquipReserve.enleverReservation(reservation.getId());

	            // retirer la participation de la base de donnée
	            ReservationEquipementDBManager.getInstance().supprimerReservation(reservation);
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

	   /* Obtenir les équipements de la base de donnée.
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
	   }*/
	   
	   /*public void choisirEquipement(Reunion reunion){
		   List<Equipement> listeEquipement = new ArrayList<Equipement>();
		   listeEquipement = this.getListEquipement();
		   
		   
	   }*/
	}
