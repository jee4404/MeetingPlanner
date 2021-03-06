package dbmanager;

import business.Reunion;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by Rémy on 2014-11-13.
 * Les DBManager permettent les opérations CRUD sur les objets
 * du type donné via l'orm ormlite
 */
public class ReunionDBManager {
    private Dao<Reunion, Integer> daoReunion;
    private static ReunionDBManager instance;

    private ReunionDBManager()
    {
        try
        {
            // init le DAO pour orm lite
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.daoReunion = DaoManager.createDao(connectionSrouce, Reunion.class);

            // cree la table sql reunion si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, Reunion.class);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static ReunionDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new ReunionDBManager();
        }
        return instance;
    }

    public void creerReunion(Reunion reunion) throws SQLException
    {
        this.daoReunion.create(reunion);
    }

    public Reunion trouverReunion(int idReunion) throws SQLException
    {
        return this.daoReunion.queryForId(idReunion);
    }

    public void actualiserReunion(Reunion reunion) throws SQLException
    {
        this.daoReunion.refresh(reunion);
    }

    public void supprimerReunion(Reunion reunion) throws SQLException
    {
        this.daoReunion.delete(reunion);
    }
    
    public List<Reunion> trouverReunionParOrganisateur(int idOrganisateur) throws SQLException
    {
    	return this.daoReunion.queryBuilder().where().eq("organisateur_id", idOrganisateur).query();
    }

    public void updateReunion(Reunion reunion) throws SQLException
    {
        this.daoReunion.update(reunion);
    }
}
