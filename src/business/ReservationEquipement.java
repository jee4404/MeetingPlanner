package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-27.
 */
@DatabaseTable(tableName = "reservation")
public class ReservationEquipement {
    @DatabaseField(generatedId = true, canBeNull = false )
    private int id;

    @DatabaseField(foreign = true, useGetSet = true, foreignAutoRefresh = true)
    private Reunion reunion;

    @DatabaseField(foreign = true, useGetSet = true, foreignAutoRefresh = true)
    private Equipement equipement;
    
    @DatabaseField(canBeNull = false, useGetSet = true)
    private int quantite;

    public ReservationEquipement()
    {
        this.id = -1;
    }

    public ReservationEquipement(Equipement equipement, Reunion reunion, int quantite)
    {
        this.id = -1;
        this.reunion = reunion;
        this.equipement = equipement;
        this.quantite = quantite;
    }

    public int getId()
    {
        return this.id;
    }

    public Reunion getReunion()
    {
        return this.reunion;
    }

    public Equipement getEquipement()
    {
        return this.equipement;
    }
    
    public int getQuantite(){
    	return this.quantite;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void setEquipement(Equipement equipement)
    {
        this.equipement = equipement;
    }

    public void setQuantite(int quantite){
    	this.quantite = quantite;
    }
}
