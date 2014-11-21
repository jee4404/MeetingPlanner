package dbmanager;

import business.Organisateur;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Rémy on 2014-11-20.
 */
public class OrganisateurDBManager {
    private Dao<Organisateur, Integer> daoOrganisateur;
    private static OrganisateurDBManager instance;

    private OrganisateurDBManager()
    {
        try
        {
            // init le DAO pour orm lite
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            // cree la table sql employe si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, Organisateur.class);

            this.daoOrganisateur = DaoManager.createDao(connectionSrouce, Organisateur.class);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static OrganisateurDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new OrganisateurDBManager();
        }
        return instance;
    }

    public Organisateur trouverOrganisateur(Integer idOrganisateur) throws SQLException
    {
        Organisateur organisateur = this.daoOrganisateur.queryForId(idOrganisateur);
        return organisateur;
    }

    public void creerOrganisateur(Organisateur organisateur) throws SQLException
    {
        this.daoOrganisateur.create(organisateur);
    }

    public void supprimerOrganisateur(Organisateur organisateur) throws SQLException
    {
        this.daoOrganisateur.delete(organisateur);
    }

    public void actualiserOrganisateur(Organisateur organisateur) throws SQLException
    {
        this.daoOrganisateur.refresh(organisateur);
    }

    public void updateOrganisateur(Organisateur organisateur) throws SQLException
    {
        this.daoOrganisateur.update(organisateur);
    }
}
