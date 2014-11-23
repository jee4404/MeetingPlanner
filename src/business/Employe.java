package business;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

/**
 * Created by Rémy on 2014-11-13.
 */
public class Employe {
    @DatabaseField(generatedId = true, canBeNull = false)
    private Integer id;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private String nom;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private String prenom;

    @DatabaseField(useGetSet = true, canBeNull = false)
    private String courriel;

    @ForeignCollectionField
    private ForeignCollection<Participation> participationsReunion;

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

    public ForeignCollection<Participation> getParticipationsReunion()
    {
        return this.participationsReunion;
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

    public void setParticipationsReunion(ForeignCollection<Participation> participations)
    {
        this.participationsReunion = participations;
    }
}
