package business;

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

    /*
        orm-lite a besoin d'un constructeur
        sans paramêtre de visibilité package
    * */
    Local(){}

    public Local(String code, int capacite)
    {
        this.code = code;
        this.capacite = capacite;
    }

    public String getCode()
    {
        return this.code;
    }

    public int getCapacite()
    {
        return this.capacite;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public void setCapacite(int capacite)
    {
        this.capacite = capacite;
    }

}
