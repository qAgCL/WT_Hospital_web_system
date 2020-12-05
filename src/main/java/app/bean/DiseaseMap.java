package app.bean;

import java.util.Date;
import java.util.Objects;

public class DiseaseMap {
    private int idMap;
    private int idUser;
    private int idDoctor;
    private String diagnosis;
    private Date arrivaltime;
    private Date departuretime;
    private boolean discharged;

    public DiseaseMap(int idMap, int idUser, int idDoctor, String diagnosis, Date arrivaltime, Date departuretime, boolean discharged) {
        this.idMap = idMap;
        this.idUser = idUser;
        this.idDoctor = idDoctor;
        this.diagnosis = diagnosis;
        this.arrivaltime = arrivaltime;
        this.departuretime = departuretime;
        this.discharged = discharged;
    }

    @Override
    public String toString() {
        return "DiseaseMap{" +
                "idMap=" + idMap +
                ", idUser=" + idUser +
                ", idDoctor=" + idDoctor +
                ", diagnosis='" + diagnosis + '\'' +
                ", arrivaltime=" + arrivaltime +
                ", departuretime=" + departuretime +
                ", discharged=" + discharged +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiseaseMap that = (DiseaseMap) o;
        return idMap == that.idMap &&
                idUser == that.idUser &&
                idDoctor == that.idDoctor &&
                discharged == that.discharged &&
                Objects.equals(diagnosis, that.diagnosis) &&
                Objects.equals(arrivaltime, that.arrivaltime) &&
                Objects.equals(departuretime, that.departuretime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMap, idUser, idDoctor, diagnosis, arrivaltime, departuretime, discharged);
    }

    public int getIdMap() {
        return idMap;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(Date arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public Date getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Date departuretime) {
        this.departuretime = departuretime;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }
}
