package business;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Rémy on 2014-11-13.
 */
@DatabaseTable(tableName = "employe")
public class Employe {
    @DatabaseField(generatedId = true, canBeNull = false)
    private Integer id;
    @DatabaseField(useGetSet = true, canBeNull = false)
    private String nom;
    @DatabaseField(useGetSet = true, canBeNull = false)
    private String prenom;
    @DatabaseField(useGetSet = true, canBeNull = false)
    private String courriel;

    /*
        orm-lite a besoin d'un constructeur
        sans paramêtre de visibilité package au min
    * */
    public Employe(){}

    public Employe(String nom, String prenom, String courriel)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
    }

    public String getNom()
    {
       return this.nom;
    }

    public String getPrenom()
    {
        return this.prenom;
    }

    public String getCourriel()
    {
        return this.courriel;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
    public void setCourriel(String courriel)
    {
        this.courriel = courriel;
    }
}
