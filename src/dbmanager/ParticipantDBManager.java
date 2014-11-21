package dbmanager;

import business.Participant;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Rémy on 2014-11-20.
 */
public class ParticipantDBManager {
    private Dao<Participant, Integer> daoParticipant;
    private static ParticipantDBManager instance;

    private ParticipantDBManager()
    {
        try
        {
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.daoParticipant = DaoManager.createDao(connectionSrouce, Participant.class);

            // cree la table sql employe si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, Participant.class);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static ParticipantDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new ParticipantDBManager();
        }
        return instance;
    }

    public Participant trouverParticipant(Integer idParticipant) throws SQLException
    {
        Participant participant = this.daoParticipant.queryForId(idParticipant);
        return participant;
    }

    public void creerParticipant(Participant participant) throws SQLException
    {
        this.daoParticipant.create(participant);
    }

    public void updateParticipant(Participant participant) throws SQLException
    {
        this.daoParticipant.update(participant);
    }

    public void actualiserParticipant(Participant participant) throws SQLException
    {
        this.daoParticipant.refresh(participant);
    }

    public void supprimerParticipant(Participant participant) throws SQLException
    {
        this.daoParticipant.delete(participant);
    }
}
