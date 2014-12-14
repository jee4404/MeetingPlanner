package dbmanager;

import business.Calendrier;
import business.Local;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémy on 2014-11-13.
 * Les DBManager permettent les opérations CRUD sur les objets
 * du type donné via l'orm ormlite
 */
public class LocalDBManager {
    private Dao<Local, String> daoLocal;
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

    public Local trouverLocal(String codeLocal) throws SQLException
    {
        Local local = this.daoLocal.queryForId(codeLocal);
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

    public List<Local> trouverTousLocaux() throws SQLException
    {
    	List<Local> lstLocaux = new ArrayList<Local>();
        //return this.daoLocal.queryForAll();
        for(Local local : this.daoLocal.queryForAll())
        {
        	local.setCalendrier(new Calendrier(PlageHoraireDBManager.getInstance().trouverPlageHoraireParLocal(local.getCode())));
        	lstLocaux.add(local);
        }
        return lstLocaux;
    }
}
