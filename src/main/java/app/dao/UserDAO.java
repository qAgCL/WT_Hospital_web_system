package app.dao;

import app.bean.User;
import app.dao.exception.DAOException;

import java.sql.Date;

public interface UserDAO {
    void registration(String name, String surname, String email, byte[] password, String phone, Date birthDate) throws DAOException;
    User signIn (String login, byte[] password) throws DAOException;
}
