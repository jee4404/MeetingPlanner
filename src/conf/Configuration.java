package conf;

/**
 * Created by Rémy on 2014-11-13.
 * Classe de configuration - seulement des attributs publics et statiques
 */
public class Configuration {
    // cet attribut doit pointer vers le répertoire db à la racine de votre projet
    public static final String dbLocation = "C:\\Users\\Marie\\Workspace\\MeetingPlanner\\db";
    // cet attribut est le même pour tout le monde
    public static final String dbURL = "jdbc:sqlite:"+dbLocation+"\\meetingplanner";
}
