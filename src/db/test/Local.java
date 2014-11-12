package db.test;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-11.
 */
@DatabaseTable(tableName = "local")
public class Local {
    @DatabaseField(id = true, useGetSet = true)
    private String code;
    @DatabaseField(useGetSet = true)
    private int capacite;

    Local(){
        //required by orm lite - no-arg construct
    }

    public Local(String code, int capacite){
        this.code = code;
        this.capacite = capacite;
    }

    public String getCode(){
        return this.code;
    }

    public int getCapacite(){
        return this.capacite;
    }

    public void setCode(String code){
        this.code = code;
    }

    public void setCapacite(int capacite){
        this.capacite = capacite;
    }
}
