package app.dao.impl;

import app.bean.User;
import app.dao.UserDAO;
import app.dao.exception.DAOException;
import app.dao.impl.connection.ConnectionPool;
import app.dao.impl.connection.ConnectionPoolException;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserDAOImpl implements UserDAO {
    public UserDAOImpl() {
        super();
    }

    private static final String TBL_COLUMN_NAME = "name";
    private static final String TBL_COLUMN_SURNAME = "surname";
    private static final String TBL_COLUMN_EMAIL = "email";
    private static final String TBL_COLUMN_ROLE = "idRole";
    private static final String TBL_COLUMN_ID = "idUser";
    private static final String TBL_COLUMN_PHONE = "phone";
    private static final String TBL_COLUMN_BIRTH = "birthdate";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_USER_SQL = "INSERT INTO `users` (`idUser`, `name`, `surname`, `email`, `password`, `idRole`, `birthdate`, `phonenumber`) VALUES (NULL, '', '', '', '', '', '', '')";
    private static final String SIGN_IN_SQL = "SELECT * as users FROM `users` WHERE `email`= ? and `password` = ?";
    @Override
    public void registration(String name, String surname, String email, String password, String phone, Date birthDate) throws DAOException {

    }

    @Override
    public User signIn(String login, String password) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(SIGN_IN_SQL);
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs == null) {
                return null;
            }
            rs.last();
            if (rs.getRow() == 1) {
                return new User(rs.getInt(TBL_COLUMN_ID),rs.getString(TBL_COLUMN_NAME),rs.getString(TBL_COLUMN_SURNAME),rs.getString(TBL_COLUMN_EMAIL),rs.getString(TBL_COLUMN_PHONE),rs.getDate(TBL_COLUMN_BIRTH),rs.getString(TBL_COLUMN_ROLE));
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while authorize User", e);
        } catch (SQLException e) {
            throw new DAOException("Error while authorize User", e);
        } finally {
            connectionPool.closeConnection(con, ps, rs);
        }
        return null;
    }
}
