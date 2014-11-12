package db.test;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

/**
 * Created by Rémy on 2014-11-12.
 */
public class LocalDAO {
    public LocalDAO()
    {

    }

    public void testDao(){
        try {
            Class.forName("org.sqlite.JDBC");

            String databaseLocation = "C:\\Users\\Rémy\\IdeaProjects\\MeetingPlanner\\db";
            String databaseUrl = "jdbc:sqlite:"+databaseLocation+"\\meetingplanner";
            ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

            Dao<Local, String> localDao = DaoManager.createDao(connectionSource, Local.class);

            TableUtils.createTableIfNotExists(connectionSource, Local.class);
            // nouvel objet local
            Local localTest = new Local("088ECC", 20);

            // sauvegarde objet dans db
            localDao.create(localTest); 

            connectionSource.close();
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
