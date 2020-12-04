package app.dao.impl;

import app.bean.User;
import app.dao.UserDAO;
import app.dao.exception.DAOException;
import app.dao.exception.DAOUserExistExp;
import app.dao.impl.connection.ConnectionPool;
import app.dao.impl.connection.ConnectionPoolException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.Date;

public class UserDAOImpl implements UserDAO {
    public UserDAOImpl() {
        super();
    }

    private static final String TBL_COLUMN_NAME = "name";
    private static final String TBL_COLUMN_SURNAME = "surname";
    private static final String TBL_COLUMN_EMAIL = "email";
    private static final String TBL_COLUMN_ROLE = "roleName";
    private static final String TBL_COLUMN_ID = "idUser";
    private static final String TBL_COLUMN_PHONE = "phonenumber";
    private static final String TBL_COLUMN_BIRTH = "birthdate";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_USER_SQL = "INSERT INTO `users` (`idUser`, `name`, `surname`, `email`, `passHash`, `idRole`, `birthdate`, `phonenumber`) VALUES (NULL, ?, ?, ?, ?, '1', ?, ?)";
    private static final String SIGN_IN_SQL = "SELECT u.*, r.roleName as roleName FROM hospital.users u INNER JOIN hospital.roles r ON u.idRole = r.idRole where u.email = ? and u.passHash = ?";

    @Override
    public void registration(String name, String surname, String email, byte[] password, String phone, Date birthDate) throws DAOException {

        PreparedStatement ps = null;
        Connection connection = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(INSERT_USER_SQL);
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, email);
            ps.setString(4, getMD5Hash(password));
            ps.setDate(5, birthDate);
            ps.setString(6, phone);

            ps.executeUpdate();
        }
        catch (ConnectionPoolException e) {
            throw new DAOException("Error in connection pool while registering a new user", e);
        }
        catch (SQLIntegrityConstraintViolationException e) {
            throw new DAOUserExistExp("Login already exists", e);
        }
        catch (SQLException e) {
            throw new DAOException("Error while registering a new user", e);
        }
        catch (NoSuchAlgorithmException e) {
            throw new DAOException("Password hashing error", e);
        }
        finally {
            connectionPool.closeConnection(connection,ps);
        }
    }

    @Override
    public User signIn(String login, byte[] password) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(SIGN_IN_SQL);
            ps.setString(1, login);
            ps.setString(2, getMD5Hash(password));
            rs = ps.executeQuery();
            if (rs == null) {
                return null;
            }
            rs.next();
            if (rs.getRow() == 1) {
                return new User(rs.getInt(TBL_COLUMN_ID),rs.getString(TBL_COLUMN_NAME),rs.getString(TBL_COLUMN_SURNAME),rs.getString(TBL_COLUMN_EMAIL),rs.getString(TBL_COLUMN_PHONE),rs.getDate(TBL_COLUMN_BIRTH),rs.getString(TBL_COLUMN_ROLE));
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while authorize User", e);
        } catch (SQLException e) {
            throw new DAOException("Error while authorize User", e);
        } catch (NoSuchAlgorithmException e) {
            throw new DAOException("Password hashing error", e);
        } finally {
            connectionPool.closeConnection(con, ps, rs);
        }
        return null;
    }

    private static String getMD5Hash(byte[] password) throws NoSuchAlgorithmException {
        byte[] passwordToHash = password;
        String generatedPassword = null;

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passwordToHash);
        //Get the hash's bytes
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
        return generatedPassword;
    }
}
