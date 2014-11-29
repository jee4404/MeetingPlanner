package business;

import dbmanager.ReservationEquipementDBManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rémy on 2014-11-27.
 */
public class ListeEquipement {
    private List<ReservationEquipement> reservationEquipements;
    private Reunion reunion;

    public ListeEquipement(){}

    public ListeEquipement(Reunion reunion) throws SQLException
    {
        this.reunion = reunion;
        this.reservationEquipements = null;
    }

    public ListeEquipement(Reunion reunion, List<ReservationEquipement> reservationEquipements)
    {
        this.reunion = reunion;
        this.reservationEquipements = reservationEquipements;
    }

    // TODO : il faut ajouter la ligne en base, mais ou ? :)
    // TODO : dans le controleur, monsieur
    public void ajouterReservation(ReservationEquipement reservationEquipement)
    {
        this.reservationEquipements.add(reservationEquipement);
    }

    // TODO : il faut supprimer la ligne en base, mais ou ? :)
    // TODO : dans le controleur, monsieur
    public void enleverReservation(ReservationEquipement reservationEquipement)
    {
        this.reservationEquipements.remove(reservationEquipement);
    }

    public Reunion getReunion()
    {
        return this.reunion;
    }

    public List<ReservationEquipement> getReservationEquipements()
    {
        return this.reservationEquipements;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void setReservationEquipements(List<ReservationEquipement> reservationEquipements)
    {
        this.reservationEquipements = reservationEquipements;
    }
}
