package dbmanager;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import conf.Configuration;

import java.sql.SQLException;

/**
 * Created by Rémy on 2014-11-13.
 * objet connection source pour faire le lien avec
 * la base de donnée - Singleton car une connectionSource pour l'app
 * suffit
 */
public class DBConnectionSource {
    private ConnectionSource connectionSource;
    private static DBConnectionSource instance;

    private DBConnectionSource()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            this.connectionSource = new JdbcConnectionSource(Configuration.dbLocation + Configuration.dbURL);
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public static DBConnectionSource getInstance()
    {
        if(instance == null)
        {
            instance = new DBConnectionSource();
        }
        return instance;
    }

    public ConnectionSource getConnectionSource()
    {
        return this.connectionSource;
    }

    public static void closeConnectionSource()
    {
        try
        {
            getInstance().getConnectionSource().close();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
