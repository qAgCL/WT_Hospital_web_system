package app.dao;

import app.bean.User;
import app.dao.exception.DAOException;

import java.util.Date;

public interface UserDAO {
    void registration(String name, String surname, String email, String password, String phone, Date birthDate) throws DAOException;
    User signIn (String login, String password) throws DAOException;
}
