package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-27.
 */
@DatabaseTable(tableName = "reservation")
public class ReservationEquipement {
    @DatabaseField(generatedId = true, canBeNull = false )
    private Integer id;

    @DatabaseField(foreign = true, useGetSet = true)
    private Reunion reunion;

    @DatabaseField(foreign = true, useGetSet = true)
    private Equipement equipement;
    
    private int qtReserve;

    public ReservationEquipement(){}

    public ReservationEquipement(Equipement equipement, Reunion reunion, int qtReserve)
    {
        this.reunion = reunion;
        this.equipement = equipement;
        this.qtReserve = qtReserve;
    }
    public Integer getId()
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
    	return this.qtReserve;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void setEquipement(Equipement equipement)
    {
        this.equipement = equipement;
    }
    public void setQuantite(int qt){
    	this.qtReserve = qt;
    }
}
