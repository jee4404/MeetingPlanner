package dbmanager;

import business.Equipement;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Rémy on 2014-11-27.
 */
public class EquipementDBManager {
    private Dao<Equipement, Integer> classDao;
    private static EquipementDBManager instance;

    private EquipementDBManager()
    {
        try
        {
            // init le DAO pour orm lite
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.classDao = DaoManager.createDao(connectionSrouce, Equipement.class);

            // cree la table sql local si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, Equipement.class);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static EquipementDBManager getInstance()
    {
        if( instance == null )
        {
            instance = new EquipementDBManager();
        }
        return instance;
    }

    public void creerEquipement(Equipement equipement) throws SQLException
    {
        this.classDao.create(equipement);
    }

    public void supprimerEquipement(Equipement equipement) throws SQLException
    {
        this.classDao.delete(equipement);
    }

    public Equipement trouverEquipement(Integer idEquipement) throws SQLException
    {
        return this.classDao.queryForId(idEquipement);
    }

    public List<Equipement> trouverTousEquipements() throws SQLException
    {
        return this.classDao.queryForAll();
    }

    public void actualiserEquipement(Equipement equipement) throws SQLException
    {
        this.classDao.refresh(equipement);
    }

    public void updateEquipement(Equipement equipement) throws SQLException
    {
        this.classDao.update(equipement);
    }
}
