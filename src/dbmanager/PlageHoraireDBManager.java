package dbmanager;

import java.sql.SQLException;
import java.util.List;
import business.PlageHoraire;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class PlageHoraireDBManager {
	private Dao<PlageHoraire, Integer> classDao;
	private static PlageHoraireDBManager instance;
	
    private PlageHoraireDBManager()
    {
        try
        {
            ConnectionSource connectionSource = DBConnectionSource.getInstance().getConnectionSource();
            this.classDao = DaoManager.createDao(connectionSource, PlageHoraire.class);

            // cree la table sql participant si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSource, PlageHoraire.class);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
	
    public static PlageHoraireDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new PlageHoraireDBManager();
        }
        return instance;
    }
    
    public void creerPlageHoraire(PlageHoraire plageHoraire) throws SQLException
    {
        this.classDao.create(plageHoraire);
    }
    
    public void updatePlageHoraire(PlageHoraire plageHoraire) throws SQLException
    {
        this.classDao.update(plageHoraire);
    }
    
    public List<PlageHoraire> trouverPlageHoraireParLocal(String codeLocal) throws SQLException
    {
        return this.classDao.queryBuilder().where().eq("codeLocal", codeLocal).query();
    }
}
