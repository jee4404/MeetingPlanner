package business;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémy on 2014-11-27.
 */
public class ListeEquipement {
    private List<ReservationEquipement> reservationEquipements;

    public ListeEquipement()
    {
        this.reservationEquipements = new ArrayList<ReservationEquipement>();
    }

    public ListeEquipement(List<ReservationEquipement> reservationEquipements)
    {
        this.reservationEquipements = reservationEquipements;
    }

    public void ajouterReservation(ReservationEquipement reservationEquipement)
    {
        this.reservationEquipements.add(reservationEquipement);
    }

    public void enleverReservation(int idEquipement)
    {
        for(ReservationEquipement reservationEquipement : this.reservationEquipements)
        {
            if(reservationEquipement.getEquipement().getId() == idEquipement)
            {
                this.reservationEquipements.remove(reservationEquipement);
                break;
            }
        }
    }

    public List<ReservationEquipement> getReservationEquipements()
    {
        return this.reservationEquipements;
    }

    public void setReservationEquipements(List<ReservationEquipement> reservationEquipements)
    {
        this.reservationEquipements = reservationEquipements;
    }

    public ReservationEquipement trouverReservationParIdEquipement(int idEquipement)
    {
        return this.reservationEquipements.stream().filter(res -> res.getEquipement().getId() == idEquipement).findFirst().orElse(null);
    }

    public ReservationEquipement trouverReservationParID(int idReservation)
    {
        return this.reservationEquipements.stream().filter(res -> res.getId() == idReservation).findFirst().orElse(null);
    }
}
