package app.dao.factory;

import app.dao.DiseaseMapDAO;
import app.dao.UserDAO;
import app.dao.impl.DiseaseMapDAOImpl;
import app.dao.impl.UserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance;

    static {
        instance = new DAOFactory();
    }

    private final UserDAO sqlUserImpl = new UserDAOImpl();
    private final DiseaseMapDAO diseaseMapImp = new DiseaseMapDAOImpl();
    private DAOFactory() {}

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return sqlUserImpl;
    }

    public DiseaseMapDAO getDiseaseMapDAO(){
        return diseaseMapImp;
    }
}
