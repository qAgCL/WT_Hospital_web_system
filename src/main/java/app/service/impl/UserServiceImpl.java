package app.service.impl;

import app.bean.User;
import app.dao.UserDAO;
import app.dao.exception.DAOException;
import app.dao.exception.DAOUserExistExp;
import app.dao.factory.DAOFactory;
import app.service.UserService;
import app.service.exception.ServiceAlwExcExcep;
import app.service.exception.ServiceExcep;

import java.sql.Date;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        super();
    }

    @Override
    public boolean registration(String name, String surname, String email, byte[] password, String phone, Date birthDate) throws ServiceExcep {
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        try {
            userDAO.registration(name,surname,email,password,phone,birthDate);
        }
        catch (DAOUserExistExp e) {
            throw new ServiceAlwExcExcep("User already exists", e);
        }
        catch (DAOException e) {
            throw new ServiceExcep("SignUp error", e);
        }

        return true;
    }

    @Override
    public User signIn(String login, byte[] password) throws ServiceExcep {
        DAOFactory factory = DAOFactory.getInstance();

        UserDAO userDAO = factory.getUserDAO();

        try {
            return userDAO.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceExcep("SignIn error", e);
        }
    }
}
