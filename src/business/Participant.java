package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import conf.Configuration;

/**
 * Created by Rémy on 2014-11-19.
 */
@DatabaseTable(tableName = "participant")
public class Participant {
    @DatabaseField(canBeNull = false, useGetSet = true, id = true)
    private int idEmploye;
    @DatabaseField(canBeNull = false, useGetSet = true)
    private int idReunion;
    @DatabaseField(canBeNull = false, useGetSet = true)
    private int participeReunion; // 0 - no reponse; 1 - yes; 2 - no
    @DatabaseField(canBeNull = false, useGetSet = true)
    private String motif;

    public Participant()
    {
        this.idEmploye = -1;
        this.idReunion = -1;
        this.motif = "";
        this.participeReunion = Configuration.PARTICIPE_REUNION_NR;
    }

    public Participant(int idReunion)
    {
        this.idEmploye = -1;
        this.idReunion = idReunion;
        this.motif = "";
        this.participeReunion = Configuration.PARTICIPE_REUNION_NR;
    }

    public Participant(int idReunion, String nom, String prenom, String courriel, int idEmploye)
    {
        this.idEmploye = idEmploye;
        this.idReunion = idReunion;
        this.motif = "";
        this.participeReunion = Configuration.PARTICIPE_REUNION_NR;
    }

    public int getIdReunion()
    {
        return this.idReunion;
    }

    public int getParticipeReunion()
    {
        return this.participeReunion;
    }

    public String getMotif()
    {
        return this.motif;
    }

    public int getIdEmploye()
    {
        return this.idEmploye;
    }

    public void setIdReunion(int idReunion)
    {
        this.idReunion = idReunion;
    }

    public void setParticipeReunion(int reponse)
    {
        this.participeReunion = reponse;
    }

    public void setMotif(String motif)
    {
        this.motif = motif;
    }

    public void setIdEmploye(int idEmploye)
    {
        this.idEmploye = idEmploye;
    }

    public Employe getEmploye()
    {
        return SessionManager.getInstance().getAnnuaireEmployes().trouverEmploye(this.idEmploye);
    }
}
