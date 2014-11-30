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

    public ReservationEquipement(){}

    public ReservationEquipement(Equipement equipement, Reunion reunion)
    {
        this.reunion = reunion;
        this.equipement = equipement;
    }

    public Reunion getReunion()
    {
        return this.reunion;
    }

    public Equipement getEquipement()
    {
        return this.equipement;
    }

    public void setReunion(Reunion reunion)
    {
        this.reunion = reunion;
    }

    public void setEquipement(Equipement equipement)
    {
        this.equipement = equipement;
    }
}
