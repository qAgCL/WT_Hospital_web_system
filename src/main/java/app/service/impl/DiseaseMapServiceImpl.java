package app.service.impl;

import app.bean.DiseaseMap;
import app.dao.DiseaseMapDAO;
import app.dao.exception.DAOException;
import app.dao.factory.DAOFactory;
import app.service.DiseaseMapService;
import app.service.exception.ServiceExcep;

import java.util.Date;
import java.util.List;

public class DiseaseMapServiceImpl implements DiseaseMapService {
    @Override
    public List<DiseaseMap> getUserMaps(int UserID) throws ServiceExcep {
        DAOFactory factory = DAOFactory.getInstance();
        DiseaseMapDAO mapDAO = factory.getDiseaseMapDAO();
        if (UserID < 1) {
            return null;
        }
        try {
            return mapDAO.getUserMaps(UserID);
        } catch (DAOException e) {
            throw new ServiceExcep("Error while find user maps", e);
        }
    }

    @Override
    public List<DiseaseMap> getDoctorTasks(int DoctorID) throws ServiceExcep {
        DAOFactory factory = DAOFactory.getInstance();
        DiseaseMapDAO mapDAO = factory.getDiseaseMapDAO();
        if (DoctorID < 1) {
            return null;
        }
        try {
            return mapDAO.getDoctorTasks(DoctorID);
        } catch (DAOException e) {
            throw new ServiceExcep("Error while find doctor tasks", e);
        }
    }

    @Override
    public boolean DischargePatient(int MapID) throws ServiceExcep {
        DAOFactory factory = DAOFactory.getInstance();
        DiseaseMapDAO mapDAO = factory.getDiseaseMapDAO();
        if (MapID < 1) {
            return false;
        }
        try {
            mapDAO.DischargePatient(MapID);
            return true;
        } catch (DAOException e) {
            throw new ServiceExcep("Error while find doctor tasks", e);
        }
    }

    @Override
    public boolean createDiseaseMap(int UserID, int DoctorID, String diagnosis, Date arrivaltime,Date departuretime) throws ServiceExcep {
        DAOFactory factory = DAOFactory.getInstance();
        DiseaseMapDAO mapDAO = factory.getDiseaseMapDAO();
        if (DoctorID<1 || UserID<1) {
            return false;
        }
        try {
            mapDAO.createDiseaseMap(UserID,DoctorID,diagnosis,arrivaltime,departuretime);
            return true;
        } catch (DAOException e) {
            throw new ServiceExcep("Error while find doctor tasks", e);
        }
    }
}
