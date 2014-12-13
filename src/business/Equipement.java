package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-27.
 */
@DatabaseTable(tableName = "equipement")
public class Equipement {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private String typeEquipement;

    @DatabaseField(useGetSet = true, canBeNull = true)
    private String description;

    public Equipement()
    {
        this.id = -1;
    }

    public int getId()
    {
        return this.id;
    }

    public String getTypeEquipement()
    {
        return this.typeEquipement;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setTypeEquipement(String typeEquipement)
    {
        this.typeEquipement = typeEquipement;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
