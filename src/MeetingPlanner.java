import db.*;
import db.test.LocalDAO;

/**
 * Created by Rémy on 2014-11-12.
 */

public class MeetingPlanner {
    public static void main(String[] args){
        LocalDAO daoLocalTest = new LocalDAO();
        daoLocalTest.testDao();
    }
}
