package dbmanager;

import business.Participation;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rémy on 2014-11-23.
 */
public class ParticipationDBManager {
    private Dao<Participation, Integer> daoParticipations;
    private static ParticipationDBManager instance;

    private ParticipationDBManager()
    {
        try
        {
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.daoParticipations = DaoManager.createDao(connectionSrouce, Participation.class);

            // cree la table sql employe si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, Participation.class);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static ParticipationDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new ParticipationDBManager();
        }
        return instance;
    }

    public Participation trouverParticipantion(Integer idParticipation) throws SQLException
    {
        Participation participation = this.daoParticipations.queryForId(idParticipation);
        return participation;
    }

    public void creerParticipation(Participation participation) throws SQLException
    {
        this.daoParticipations.create(participation);
    }

    public void updateParticipation(Participation participation) throws SQLException
    {
        this.daoParticipations.update(participation);
    }

    public void actualiserParticipation(Participation participation) throws SQLException
    {
        this.daoParticipations.refresh(participation);
    }

    public void supprimerParticipation(Participation participation) throws SQLException
    {
        this.daoParticipations.delete(participation);
    }

    public List<Participation> trouverParticipationParReunion(Integer idReunion) throws SQLException
    {
        HashMap<String, Object> queryParams = new HashMap<String, Object>();
        queryParams.put("reunion_id", idReunion);
        return this.daoParticipations.queryForFieldValues(queryParams);
    }
}