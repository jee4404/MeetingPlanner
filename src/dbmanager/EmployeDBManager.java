package dbmanager;

import business.Employe;

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
public class EmployeDBManager {
    private Dao<Employe, Integer> classDao;
    private static EmployeDBManager instance;

    private EmployeDBManager()
    {
        try
        {
            // init le DAO pour orm lite
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.classDao = DaoManager.createDao(connectionSrouce, Employe.class);

            // cree la table sql employe si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, Employe.class);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static EmployeDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new EmployeDBManager();
        }
        return instance;
    }

    public void creerEmploye(Employe employe) throws SQLException
    {
        this.classDao.create(employe);
    }

    public Employe trouverEmploye(int idEmploye) throws SQLException
    {
        Employe employe = this.classDao.queryForId(idEmploye);
        return employe;
    }

    public void actualiserEmploye(Employe employe) throws SQLException
    {
        this.classDao.refresh(employe);
    }

    public void supprimerEmploye(Employe employe) throws SQLException
    {
        this.classDao.delete(employe);
    }

    public void updateEmploye(Employe employe) throws SQLException
    {
        this.classDao.update(employe);
    }
    
    public List<Employe> trouverTousEmployes()throws SQLException
    {
       return this.classDao.queryForAll();

    }
    
    public Employe trouverEmployeParCourriel(String courriel) throws SQLException
    {
    	return this.classDao.queryBuilder().where().eq("courriel", courriel).queryForFirst();
    }
}
