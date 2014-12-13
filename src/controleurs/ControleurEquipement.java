package controleurs;

import java.sql.SQLException;

import business.*;
import view.frames.FenetreEquipement;
import dbmanager.ReservationEquipementDBManager;

public class ControleurEquipement {
    private static ControleurEquipement controleurEquipement = new ControleurEquipement();
    private Reunion reunion;

    private ControleurEquipement()
    {
        this.reunion = null;
    }

    public static ControleurEquipement getInstance()
    {
        return controleurEquipement;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void choisirEquipement(Reunion reunion)
    {
        try
        {
            this.setReunion(reunion);
            this.reunion.setListeEquipement(new ListeEquipement( ReservationEquipementDBManager.getInstance().trouverEquipementsParReunion(this.reunion.getId())));
            FenetreEquipement fenetreEquipement = new FenetreEquipement(reunion.getListeEquipement());
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void reserverEquipement(int idEquipement, int qtEquipement)
    {
        try
        {
            Equipement equipement = SessionManager.getInstance().getInventaireEquipement().trouverEquipementParID(idEquipement);

            if(equipement.getId() == -1)
                throw new RuntimeException("equipement introuvable pour id #"+idEquipement);

            // check si eqt déja ajouté a la liste de reservation
            ReservationEquipement reservationEquipement = this.reunion.getListeEquipement().trouverReservationParIdEquipement(idEquipement);

            if( reservationEquipement != null ) // on a trouvé un doublon de réservation, exception
                throw new RuntimeException("cet équipement à déja été réservé : "+reservationEquipement.getEquipement().getTypeEquipement());

            reservationEquipement = new ReservationEquipement(equipement, this.reunion, qtEquipement);

            // ajout reservation a la liste de réservation de la réunion en cours d'édition
            this.reunion.getListeEquipement().ajouterReservation(reservationEquipement);
        }
        catch (RuntimeException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public void retirerEquipement(int idReservation)
    {
        try
        {
            ReservationEquipement reservation = ReservationEquipementDBManager.getInstance().trouverReservation(idReservation);
            if(reservation == null)
            throw new RuntimeException("reservation introuvable");

            // retirer la participation de la liste de participation
            //this.listeEquipReserve.enleverReservation(reservation.getId());

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
}
