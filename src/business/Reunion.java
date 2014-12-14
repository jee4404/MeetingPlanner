package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;

/**
 * Created by Rémy on 2014-11-13.
 */
@DatabaseTable(tableName = "reunion")
public class Reunion {
    @DatabaseField(generatedId = true, canBeNull = false)
    private int id;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private Date dateReunion;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private Date heureReunion;
    
    @DatabaseField(useGetSet = true, canBeNull = false)
    private Date dureeReunion;
    
    @DatabaseField(useGetSet = true, canBeNull = false)
    private int nbParticipants;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private boolean estRecurente;

    @DatabaseField(canBeNull = true, foreign = true, useGetSet = true, foreignAutoRefresh = true)
    private Local local;

    @DatabaseField(canBeNull = true, foreign = true, useGetSet = true, foreignAutoRefresh = true)
    private Organisateur organisateur;
    
    @DatabaseField(canBeNull = false, useGetSet = true)
    private String sujet;

    private ListeParticipants listeParticipants;

    private ListeEquipement listeEquipement;
    
    //private Calendrier calendrier;
    
    /*
        orm-lite a besoin d'un constructeur
        sans paramêtre de visibilité package au min
    * */
    public Reunion()
    {
        this.id = -1;
        this.listeEquipement = new ListeEquipement();
        this.listeParticipants = new ListeParticipants();
    }

    public Reunion(String sujet, Date dateReunion, Date heureReunion, Date dureeReunion,int nbParticipants, boolean estRecurente, Organisateur organisateur)
    {
        this.id = -1;
    	this.sujet = sujet;
        this.dateReunion = dateReunion;
        this.heureReunion = heureReunion;
        this.dureeReunion = dureeReunion;
        this.nbParticipants = nbParticipants;
        this.estRecurente = estRecurente;
        this.local = null;
        this.organisateur = organisateur;
        this.listeEquipement = new ListeEquipement();
        this.listeParticipants = new ListeParticipants();
        //this.calendrier = new Calendrier();
        //this.setCalendrier(dateReunion, heureReunion, dureeReunion);
    }

    public Reunion(String sujet, Date dateReunion,  Date heureReunion, Date dureeReunion,int nbParticipants, boolean estRecurente, Local local, Organisateur organisateur)
    {
        this.id = -1;
    	this.sujet = sujet;
        this.dateReunion = dateReunion;
        this.heureReunion = heureReunion;
        this.dureeReunion = dureeReunion;
        this.nbParticipants = nbParticipants;
        this.estRecurente = estRecurente;
        this.local = local;
        this.organisateur = organisateur;
        this.listeEquipement = new ListeEquipement();
        this.listeParticipants = new ListeParticipants();
        //this.setCalendrier(dateReunion, heureReunion, dureeReunion);
    }

    public int getId()
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
    
    public Date getHeureReunion()
    {
    	return this.heureReunion;
    }
    
    public Date getDureeReunion()
    {
    	return this.dureeReunion;
    }
    
   /* public Calendrier getCalendrier(Date date, Date heure, Date duree){
    	return calendrier;
    }*/

    public Local getLocal()
    {
        return this.local;
    }

    public Organisateur getOrganisateur()
    {
        return this.organisateur;
    }

    public String getSujet()
    {
    	return this.sujet;
    }

    public ListeParticipants getListeParticipants()
    {
        return this.listeParticipants;
    }

    public ListeEquipement getListeEquipement()
    {
        return this.listeEquipement;
    }

    public void setDateReunion(Date dateReunion)
    {
        this.dateReunion = dateReunion;
    }

    public void setHeureReunion(Date heureReunion)
    {
        this.heureReunion = heureReunion;
    }
    
    public void setDureeReunion(Date dureeReunion)
    {
        this.dureeReunion = dureeReunion;
    }
    
    /*public void setCalendrier(Date dateReunion, Date heureReunion, Date dureeReunion){
    	this.calendrier = new Calendrier();
    	calendrier.setLstPlageHoraire(dateReunion, heureReunion, dureeReunion);
    }*/
    
    public void setNbParticipants(int nbParticipants)
    {
        this.nbParticipants = nbParticipants;
    }

    public void setEstRecurente(boolean estRecurente)
    {
        this.estRecurente = estRecurente;
    }

    public void setLocal(Local local)
    {
        this.local = local;
    }

    public void setOrganisateur(Organisateur organisateur)
    {
        this.organisateur = organisateur;
    }
    
    public void setSujet(String sujet)
    {
    	this.sujet = sujet;
    }

    public void setListeEquipement(ListeEquipement listeEquipement)
    {
        this.listeEquipement = listeEquipement;
    }

    public void setListeParticipants(ListeParticipants listeParticipants)
    {
        this.listeParticipants = listeParticipants;
    }
}
