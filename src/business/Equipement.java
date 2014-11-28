package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-27.
 */
@DatabaseTable(tableName = "equipement")
public class Equipement {
    @DatabaseField(generatedId = true)
    private Integer id;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private String typeEquipement;

    @DatabaseField(useGetSet = true, canBeNull = true)
    private String desciption;

    public Equipement(){}

    public Integer getId()
    {
        return this.id;
    }

    public String getTypeEquipement()
    {
        return this.typeEquipement;
    }

    public String getDesciption()
    {
        return this.desciption;
    }

    public void setTypeEquipement(String typeEquipement)
    {
        this.typeEquipement = typeEquipement;
    }

    public void setDesciption(String desciption)
    {
        this.desciption = desciption;
    }
}
