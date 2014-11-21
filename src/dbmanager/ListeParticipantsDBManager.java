package dbmanager;

import business.ListeParticipants;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Rémy on 2014-11-19.
 */
public class ListeParticipantsDBManager {
    private Dao<ListeParticipants, Integer> daoListeParticipants;
    private static ListeParticipantsDBManager instance;

    private ListeParticipantsDBManager()
    {
        try
        {
            // init le DAO pour orm lite
            ConnectionSource connectionSrouce = DBConnectionSource.getInstance().getConnectionSource();
            this.daoListeParticipants = DaoManager.createDao(connectionSrouce, ListeParticipants.class);

            // cree la table sql reunion si elle n'existe pas deja
            TableUtils.createTableIfNotExists(connectionSrouce, ListeParticipants.class);
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    public static ListeParticipantsDBManager getInstance()
    {
        if(instance == null)
        {
            instance = new ListeParticipantsDBManager();
        }
        return instance;
    }

    public void creerListe(ListeParticipants listeParticipants) throws SQLException
    {
        this.daoListeParticipants.create(listeParticipants);
    }

    public ListeParticipants trouverListe(Integer idReunion) throws SQLException
    {
        ListeParticipants liste = this.daoListeParticipants.queryForId(idReunion);
        return liste;
    }

    public void actualiserListe(ListeParticipants listeParticipants) throws SQLException
    {
        this.daoListeParticipants.refresh(listeParticipants);
    }

    public void supprimerListe(ListeParticipants listeParticipants) throws SQLException
    {
        this.daoListeParticipants.delete(listeParticipants);
    }
}
