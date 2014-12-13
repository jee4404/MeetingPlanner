package business;
import java.util.List;

/**
 * Created by Rémy on 2014-11-27.
 */
public class ListeEquipement {
    private List<ReservationEquipement> reservationEquipements;

    public ListeEquipement()
    {
        this.reservationEquipements = null;
    }

    public ListeEquipement(List<ReservationEquipement> reservationEquipements)
    {
        this.reservationEquipements = reservationEquipements;
    }

    public void ajouterReservation(ReservationEquipement reservationEquipement)
    {
        this.reservationEquipements.add(reservationEquipement);
    }

    public void enleverReservation(int idReservation)
    {
        for(int i = 0; i < this.reservationEquipements.size(); i++)
        {
            int tmpReservationId = this.reservationEquipements.get(i).getId();
            if( idReservation == tmpReservationId )
            {
                this.reservationEquipements.remove(i);
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
}
