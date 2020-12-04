package app.dao.impl.connection;

import java.util.ResourceBundle;

public class DBResourseManager {
    private final static DBResourseManager instance = new DBResourseManager();

    private ResourceBundle bundle = ResourceBundle.getBundle("db");

    public static DBResourseManager getInstance() {
        return  instance;
    }

    public String getValue(String key) {
        return bundle.getString(key);
    }
}
