package dbmanager;

import business.Local;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
/**
 * Created by Rémy on 2014-11-13.
 * Les DBManager permettent les opérations CRUD sur les objets
 * du type donné via l'orm ormlite
 */
public class LocalDBManager {
    private Dao<Local, Integer> daoLocal;
    private static LocalDBManager instance;

    private LocalDBManager()
    {
        try
        {
            // init le DAO pour orm lite
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.daoLocal = DaoManager.createDao(connectionSrouce, Local.class);

            // cree la table sql local si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, Local.class);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static LocalDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new LocalDBManager();
        }
        return instance;
    }

    public void creerLocal(Local local) throws SQLException
    {
        this.daoLocal.create(local);
    }

    public Local trouverLocal(Integer idLocal) throws SQLException
    {
        Local local = this.daoLocal.queryForId(idLocal);
        return local;
    }

    public void actualiserLocal(Local local) throws SQLException
    {
        this.daoLocal.refresh(local);
    }

    public void supprimerLocal(Local local) throws SQLException
    {
        this.daoLocal.delete(local);
    }

    public void updateLocal(Local local) throws SQLException
    {
        this.daoLocal.update(local);
    }

}
