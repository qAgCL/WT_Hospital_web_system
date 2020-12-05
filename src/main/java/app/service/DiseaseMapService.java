package app.service;

import app.bean.DiseaseMap;
import app.bean.Medicine;
import app.bean.Operation;
import app.bean.Procedure;
import app.service.exception.ServiceExcep;

import java.util.Date;
import java.util.List;

public interface DiseaseMapService {
    List<DiseaseMap> getUserMaps(int UserID) throws ServiceExcep;
    List<DiseaseMap> getDoctorTasks(int DoctorID) throws ServiceExcep;
    boolean DischargePatient(int MapID) throws ServiceExcep;
    boolean createDiseaseMap(int UserID, int DoctorID, String diagnosis,Date arrivaltime,Date departuretime) throws  ServiceExcep;
}
