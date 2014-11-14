package dbmanager;

import business.Employe;
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
public class EmployeDBManager {
    private Dao<Employe, Integer> daoEmploye;
    private static EmployeDBManager instance;

    private EmployeDBManager()
    {
        try
        {
            // init le DAO pour orm lite
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.daoEmploye = DaoManager.createDao(connectionSrouce, Employe.class);

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
        this.daoEmploye.create(employe);
    }

    public Employe trouverEmploye(Integer idEmploye) throws SQLException
    {
        Employe employe = this.daoEmploye.queryForId(idEmploye);
        return employe;
    }

    public void actualiserEmploye(Employe employe) throws SQLException
    {
        this.daoEmploye.refresh(employe);
    }

    public void supprimerEmploye(Employe employe) throws SQLException
    {
        this.daoEmploye.delete(employe);
    }

    public void updateEmploye(Employe employe) throws SQLException
    {
        this.daoEmploye.update(employe);
    }
}
