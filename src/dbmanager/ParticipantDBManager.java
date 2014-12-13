package dbmanager;

import business.ListeParticipants;
import business.Participant;
import business.Reunion;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rémy on 2014-11-20.
 */
public class ParticipantDBManager {
    private Dao<Participant, Integer> classDao;
    private static ParticipantDBManager instance;

    private ParticipantDBManager()
    {
        try
        {
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.classDao = DaoManager.createDao(connectionSrouce, Participant.class);

            // cree la table sql participant si elle n'existe pas deja
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
        return this.classDao.queryForId(idParticipant);
    }

    public void creerParticipant(Participant participant) throws SQLException
    {
        this.classDao.create(participant);
    }

    public void updateParticipant(Participant participant) throws SQLException
    {
        this.classDao.update(participant);
    }

    public void actualiserParticipant(Participant participant) throws SQLException
    {
        this.classDao.refresh(participant);
    }

    public void supprimerParticipant(Participant participant) throws SQLException
    {
        this.classDao.delete(participant);
    }

    public List<Participant> trouverParticipantParReunion(int idReunion) throws SQLException
    {
        return this.classDao.queryBuilder().where().eq("idReunion", idReunion).query();
    }

    public List<Participant> trouverParticipantParParticipant(int idParticipant) throws SQLException
    {
        return this.classDao.queryBuilder().where().eq("idEmploye", idParticipant).query();
    }

    public Participant trouverParticipantParReunionParticipant(int idReunion, int idParticipant) throws SQLException
    {
        return this.classDao.queryBuilder().where().eq("idReunion", idReunion).and().eq("idEmploye", idParticipant).queryForFirst();
    }

    public List<Reunion> trouverMesInvitations(int idEmploye) throws SQLException
    {
        List<Reunion> mesInvitations = new ArrayList<Reunion>();
        List<Participant> mesParticipations = this.classDao.queryBuilder().where().eq("idEmploye", idEmploye).query();
        for (Participant participation : mesParticipations)
        {
            Reunion reunionInvitee = ReunionDBManager.getInstance().trouverReunion(participation.getIdReunion());
            if( reunionInvitee == null )
                throw new SQLException("impossible de trouver l'invitation pour la reunion "+participation.getIdEmploye());

            // initialise les liste de participants de chaque reunion - c'est utile pour ajouter / refuser une invitation
            reunionInvitee.setListeParticipants(new ListeParticipants(getInstance().trouverParticipantParReunion(reunionInvitee.getId())));

            mesInvitations.add(reunionInvitee);
        }
        return mesInvitations;
    }
}
