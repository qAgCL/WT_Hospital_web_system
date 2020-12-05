package app.dao;

import app.bean.DiseaseMap;
import app.dao.exception.DAOException;
import app.service.exception.ServiceExcep;

import java.util.Date;
import java.util.List;

public interface DiseaseMapDAO {
    List<DiseaseMap> getUserMaps(int UserID) throws DAOException;
    List<DiseaseMap> getDoctorTasks(int DoctorID) throws DAOException;
    void DischargePatient(int MapID) throws DAOException;
    void createDiseaseMap(int UserID, int DoctorID, String diagnosis,Date arrivaltime, Date departuretime) throws  DAOException;
}
