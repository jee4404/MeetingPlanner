package business;

import dbmanager.EquipementDBManager;
import dbmanager.ReservationDBManager;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rémy on 2014-11-27.
 */
public class ListeEquipement {
    private List<Reservation> reservations;
    private Reunion reunion;

    public ListeEquipement(){}

    public ListeEquipement(Reunion reunion) throws SQLException
    {
        this.reunion = reunion;

        // init liste des réservations
        this.reservations = ReservationDBManager.getInstance().trouverEquipementsParReunion(reunion.getId());
    }

    // TODO : il faut ajouter la ligne en base, mais ou ? :)
    public void ajouterReservation(Reservation reservation)
    {
        this.reservations.add(reservation);
    }

    // TODO : il faut supprimer la ligne en base, mais ou ? :)
    public void enleverReservation(Reservation reservation)
    {
        this.reservations.remove(reservation);
    }

    public Reunion getReunion()
    {
        return this.reunion;
    }

    public List<Reservation> getReservations()
    {
        return this.reservations;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void setReservations(List<Reservation> reservations)
    {
        this.reservations = reservations;
    }
}
