package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rémy on 2014-11-13.
 */
@DatabaseTable(tableName = "reunion")
public class Reunion {
    @DatabaseField(id = true, useGetSet = true, generatedId = true, canBeNull = false)
    private Integer id;
    @DatabaseField(useGetSet = true, canBeNull = false)
    private Date dateReunion;
    @DatabaseField(useGetSet = true, canBeNull = false)
    private int nbParticipants;
    @DatabaseField(useGetSet = true, canBeNull = false)
    private boolean estRecurente;
    @ForeignCollectionField()
    private List<Employe> participants;

    /*
        orm-lite a besoin d'un constructeur
        sans paramêtre de visibilité package
    * */
    Reunion(){}

    public Reunion(Date dateReunion, int nbParticipants, boolean estRecurente)
    {
        this.dateReunion = dateReunion;
        this.nbParticipants = nbParticipants;
        this.estRecurente = estRecurente;
        this.participants = new ArrayList<Employe>();
    }

    public Integer getId()
    {
        return this.id;
    }

    public int getNbParticipants()
    {
        return this.nbParticipants;
    }

    public boolean estRecurente()
    {
        return this.estRecurente;
    }

    public Date getDateReunion()
    {
        return this.dateReunion;
    }

    public List<Employe> getParticipants()
    {
        return this.participants;
    }

    public void setDateReunion(Date dateReunion)
    {
        this.dateReunion = dateReunion;
    }

    public void setNbParticipants(int nbParticipants)
    {
        this.nbParticipants = nbParticipants;
    }

    public void setEstRecurente(boolean estRecurente)
    {
        this.estRecurente = estRecurente;
    }

    public void ajouterParticipant(Employe employe)
    {
        this.participants.add(employe);
    }

    public void retirerParticipant(Employe employe)
    {
        this.participants.remove(employe);
    }

}
