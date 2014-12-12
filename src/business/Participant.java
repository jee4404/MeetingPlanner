package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-19.
 */

@DatabaseTable(tableName = "employe")
public class Participant extends Employe {
    public Participant(){}

    public Participant(Employe employe)
    {
        this.setPrenom(employe.getPrenom());
        this.setCourriel(employe.getCourriel());
        this.setNom(employe.getNom());
        this.setId(employe.getId());
    }
}
