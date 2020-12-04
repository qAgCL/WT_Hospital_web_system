package app.dao.factory;

import app.dao.UserDAO;
import app.dao.impl.UserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance;

    static {
        instance = new DAOFactory();
    }

    private final UserDAO sqlUserImpl = new UserDAOImpl();
    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return sqlUserImpl;
    }


}
