package dbmanager;

import business.Reservation;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rémy on 2014-11-27.
 */
public class ReservationDBManager {
    private Dao<Reservation, Integer> classDao;
    private static ReservationDBManager instance;

    private ReservationDBManager()
    {
        try
        {
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.classDao = DaoManager.createDao(connectionSrouce, Reservation.class);

            // cree la table sql reservation si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, Reservation.class);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static ReservationDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new ReservationDBManager();
        }
        return instance;
    }

    public Reservation trouverReservation(Integer idReservation) throws SQLException
    {
        return this.classDao.queryForId(idReservation);
    }

    public void creerReservation(Reservation reservation) throws SQLException
    {
        this.classDao.create(reservation);
    }

    public void updateReservation(Reservation reservation) throws SQLException
    {
        this.classDao.update(reservation);
    }

    public void actualiserReservation(Reservation reservation) throws SQLException
    {
        this.classDao.refresh(reservation);
    }

    public void supprimerReservation(Reservation reservation) throws SQLException
    {
        this.classDao.delete(reservation);
    }

    public List<Reservation> trouverEquipementsParReunion(Integer idReunion) throws SQLException
    {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("reunion_id", idReunion);
        return this.classDao.queryForFieldValues(queryParams);
    }
}
