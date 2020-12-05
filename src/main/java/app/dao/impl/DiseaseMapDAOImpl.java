package app.dao.impl;

import app.bean.DiseaseMap;
import app.dao.DiseaseMapDAO;
import app.dao.exception.DAOException;
import app.dao.exception.DAOUserExistExp;
import app.dao.impl.connection.ConnectionPool;
import app.dao.impl.connection.ConnectionPoolException;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiseaseMapDAOImpl implements DiseaseMapDAO {
    private static final String TBL_COLUMN_IDMAP="idMap";
    private static final String TBL_COLUMN_IDUSER="idUser";
    private static final String TBL_COLUMN_IDDOC ="idDoctor";
    private static final String TBL_COLUMN_DIAGNOSIS = "diagnosis";
    private static final String TBL_COLUMN_ARRIVAL= "arrivaltime";
    private static final String TBL_COLUMN_DEPARTURE="departuretime";
    private static final String TBL_COLUMN_DISCHARGED="discharged";

    private static final String CREATEMAP_SQL = "INSERT INTO `diseasemap` (`idMap`, `idUser`, `idDoctor`, `diagnosis`, `arrivaltime`, `departuretime`, `discharged`) VALUES (NULL, ?, ?, ?, ?, ?, '0')";
    private static final String DOCTORTASKS_SQL = "SELECT * FROM diseasemap WHERE idDoctor = ?";
    private static final String USERMAPS_SQL = "SELECT * FROM diseasemap WHERE idUser = ?";
    private static final String DISHARGE_PATIENT_SQL = "UPDATE diseasemap SET discharged = 1 WHERE diseasemap.idMap = ?";
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    @Override
    public void DischargePatient(int MapID) throws DAOException {
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(DISHARGE_PATIENT_SQL);
            ps.setInt(1, MapID);
            ps.executeUpdate();
        }
        catch (ConnectionPoolException e) {
            throw new DAOException("Error in connection", e);
        }
        catch (SQLException e) {
            throw new DAOException("Error while DischargePatient", e);
        }
        finally {
            connectionPool.closeConnection(connection,ps);
        }
    }

    @Override
    public List<DiseaseMap> getUserMaps(int UserID) throws DAOException {
        PreparedStatement ps = null;
        Connection connection = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(USERMAPS_SQL);
            ps.setInt(1, UserID);
            rs = ps.executeQuery();
            if (rs == null) {
                return null;
            }
            List<DiseaseMap> diseaseMapList = new ArrayList<>();

            while (rs.next()) {
                diseaseMapList.add(new DiseaseMap(
                        rs.getInt(TBL_COLUMN_IDMAP),
                        rs.getInt(TBL_COLUMN_IDUSER),
                        rs.getInt(TBL_COLUMN_IDDOC),
                        rs.getString(TBL_COLUMN_DIAGNOSIS),
                        rs.getDate(TBL_COLUMN_ARRIVAL),
                        rs.getDate(TBL_COLUMN_DEPARTURE),
                        rs.getBoolean(TBL_COLUMN_DISCHARGED)
                ));
            }
            return diseaseMapList;
        }
        catch (ConnectionPoolException e) {
            throw new DAOException("Error in connection", e);
        }
        catch (SQLException e) {
            throw new DAOException("Error while getUserMaps", e);
        }
        finally {
            connectionPool.closeConnection(connection,ps,rs);
        }
    }
    @Override
    public List<DiseaseMap> getDoctorTasks(int DoctorID) throws DAOException {
        PreparedStatement ps = null;
        Connection connection = null;
        ResultSet rs = null;

        try {
            connection = connectionPool.takeConnection();
            ps = connection.prepareStatement(DOCTORTASKS_SQL);
            ps.setInt(1, DoctorID);
            rs = ps.executeQuery();
            if (rs == null) {
                return null;
            }
            List<DiseaseMap> doctorTasksList = new ArrayList<>();

            while (rs.next()) {
                doctorTasksList.add(new DiseaseMap(
                        rs.getInt(TBL_COLUMN_IDMAP),
                        rs.getInt(TBL_COLUMN_IDUSER),
                        rs.getInt(TBL_COLUMN_IDDOC),
                        rs.getString(TBL_COLUMN_DIAGNOSIS),
                        rs.getDate(TBL_COLUMN_ARRIVAL),
                        rs.getDate(TBL_COLUMN_DEPARTURE),
                        rs.getBoolean(TBL_COLUMN_DISCHARGED)
                ));
            }
            return doctorTasksList;
        }
        catch (ConnectionPoolException e) {
            throw new DAOException("Error in connection", e);
        }
        catch (SQLException e) {
            throw new DAOException("Error while getDoctorTasks", e);
        }
        finally {
            connectionPool.closeConnection(connection,ps,rs);
        }
    }
    @Override
    public void createDiseaseMap(int UserID, int DoctorID, String diagnosis, Date arrivaltime, Date departuretime) throws DAOException {
        PreparedStatement ps = null;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(CREATEMAP_SQL);
            ps.setInt(1, UserID);
            ps.setInt(2, DoctorID);
            ps.setString(3, diagnosis);
            ps.setDate(4, new java.sql.Date(arrivaltime.getTime()));
            ps.setDate(5,new  java.sql.Date(departuretime.getTime()));
            ps.executeUpdate();
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in connection", e);
        } catch (SQLException e) {
            throw new DAOException("Error while createDiseaseMap", e);
        } finally {
            connectionPool.closeConnection(con, ps);
        }
    }
}
