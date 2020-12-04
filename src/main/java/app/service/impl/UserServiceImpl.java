package app.service.impl;

import app.bean.User;
import app.dao.UserDAO;
import app.dao.exception.DAOException;
import app.dao.factory.DAOFactory;
import app.service.UserService;
import app.service.exception.ServiceExcep;

import java.util.Date;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
        super();
    }

    @Override
    public void registration(String name, String surname, String email, String password, String phone, Date birthDate) throws ServiceExcep {

    }

    @Override
    public User signIn(String login, String password) throws ServiceExcep {
        DAOFactory factory = DAOFactory.getInstance();

        if (login.equals("") || password.equals("")) {
            return null;
        }

        UserDAO userDAO = factory.getUserDAO();

        try {
            return userDAO.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceExcep("Error while signIn User", e);
        }
    }
}
