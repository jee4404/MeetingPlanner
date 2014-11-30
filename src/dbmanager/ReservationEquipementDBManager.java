package dbmanager;

import business.Participation;
import business.ReservationEquipement;

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
public class ReservationEquipementDBManager {
    private Dao<ReservationEquipement, Integer> classDao;
    private static ReservationEquipementDBManager instance;

    private ReservationEquipementDBManager()
    {
        try
        {
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.classDao = DaoManager.createDao(connectionSrouce, ReservationEquipement.class);

            // cree la table sql reservation si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, ReservationEquipement.class);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static ReservationEquipementDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new ReservationEquipementDBManager();
        }
        return instance;
    }

    public ReservationEquipement trouverReservation(Integer idReservation) throws SQLException
    {
        return this.classDao.queryForId(idReservation);
    }

    public void creerReservation(ReservationEquipement reservationEquipement) throws SQLException
    {
        this.classDao.create(reservationEquipement);
    }

    public void updateReservation(ReservationEquipement reservationEquipement) throws SQLException
    {
        this.classDao.update(reservationEquipement);
    }

    public void actualiserReservation(ReservationEquipement reservationEquipement) throws SQLException
    {
        this.classDao.refresh(reservationEquipement);
    }

    public void supprimerReservation(ReservationEquipement reservationEquipement) throws SQLException
    {
        this.classDao.delete(reservationEquipement);
    }

    public List<ReservationEquipement> trouverEquipementsParReunion(Integer idReunion) throws SQLException
    {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("reunion_id", idReunion);
        return this.classDao.queryForFieldValues(queryParams);
    }
    
    public ReservationEquipement trouverReservationParReunionEquipement(int idReunion, int idEquipement) throws SQLException
    {
        return this.classDao.queryBuilder().where().eq("reunion_id", idReunion).and().eq("equipement_id", idEquipement).queryForFirst();
    }
}
