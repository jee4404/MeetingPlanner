package business;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-13.
 */
@DatabaseTable(tableName = "local")
public class Local {
    @DatabaseField(id = true, useGetSet =  true, canBeNull = false)
    private String code;
    @DatabaseField(useGetSet = true, canBeNull = false)
    private int capacite;
    
    private Calendrier calendrier;
    /*
        orm-lite a besoin d'un constructeur
        sans paramêtre de visibilité package au min
    * */
    public Local()
    {
        this.calendrier = new Calendrier();
    }

    public Local(String code, int capacite)
    {
        this.code = code;
        this.capacite = capacite;
        this.calendrier = new Calendrier();
    }

    public String getCode()
    {
        return this.code;
    }

    public int getCapacite()
    {
        return this.capacite;
    }

    public Calendrier getCalendrier()
    {
    	return this.calendrier;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public void setCapacite(int capacite)
    {
        this.capacite = capacite;
    }
    public void addLstPlageHoraire (Date date, Date heure, Date duree)
    {
    	this.calendrier.addLstPlageHoraire(date, heure, duree,this.code);
    }
    
    public void setCalendrier(Calendrier calendrier)
    {
    	this.calendrier = calendrier;
    }
}
