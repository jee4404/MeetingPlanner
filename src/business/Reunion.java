package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Rémy on 2014-11-13.
 */
@DatabaseTable(tableName = "reunion")
public class Reunion {
    @DatabaseField(generatedId = true, canBeNull = false)
    private Integer id;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private Date dateReunion;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private int nbParticipants;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private boolean estRecurente;

    @ForeignCollectionField()
    private Collection<Employe> participants;

    @DatabaseField(canBeNull = true, foreign = true, useGetSet = true)
    private Local local;

    @DatabaseField(canBeNull = true, foreign = true, useGetSet = true)
    private Employe organisateur;

    /*
        orm-lite a besoin d'un constructeur
        sans paramêtre de visibilité package au min
    * */
    public Reunion()
    {
        this.participants = new ArrayList<Employe>();
    }

    public Reunion(Date dateReunion, int nbParticipants, boolean estRecurente, Employe organisateur)
    {
        this.dateReunion = dateReunion;
        this.nbParticipants = nbParticipants;
        this.estRecurente = estRecurente;
        this.participants = new ArrayList<Employe>();
        this.local = null;
        this.organisateur = organisateur;
    }

    public Reunion(Date dateReunion, int nbParticipants, boolean estRecurente, Local local, Employe organisateur)
    {
        this.dateReunion = dateReunion;
        this.nbParticipants = nbParticipants;
        this.estRecurente = estRecurente;
        this.participants = new ArrayList<Employe>();
        this.local = local;
        this.organisateur = organisateur;
    }

    public Integer getId()
    {
        return this.id;
    }

    public int getNbParticipants()
    {
        return this.nbParticipants;
    }

    /*
        utiliser estRecurente()
        cette fonction est utilse a l'orm seulement
     */
    public boolean getEstRecurente()
    {
        return this.estRecurente;
    }

    public boolean estRecurente()
    {
        return this.estRecurente;
    }

    public Date getDateReunion()
    {
        return this.dateReunion;
    }

    public Collection<Employe> getParticipants()
    {
        return this.participants;
    }

    public Local getLocal()
    {
        return this.local;
    }

    public Employe getOrganisateur()
    {
        return this.organisateur;
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

    public void setLocal(Local local)
    {
        this.local = local;
    }

    public void setParticipants(List<Employe> participants)
    {
        this.participants = participants;
    }

    public void setOrganisateur(Employe organisateur)
    {
        this.organisateur = organisateur;
    }
}
