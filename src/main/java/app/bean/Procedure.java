package app.bean;

import java.util.Date;
import java.util.Objects;

public class Procedure {
    private int idProcedure;
    private int idMap;
    private int idUser;
    private int idDoctor;
    private int idNurse;
    private String procedureName;
    private String frequencu;
    private int dayNumber;

    @Override
    public String toString() {
        return "Procedure{" +
                "idProcedure=" + idProcedure +
                ", idMap=" + idMap +
                ", idUser=" + idUser +
                ", idDoctor=" + idDoctor +
                ", idNurse=" + idNurse +
                ", procedureName='" + procedureName + '\'' +
                ", frequencu='" + frequencu + '\'' +
                ", dayNumber=" + dayNumber +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Procedure procedure = (Procedure) o;
        return idProcedure == procedure.idProcedure &&
                idMap == procedure.idMap &&
                idUser == procedure.idUser &&
                idDoctor == procedure.idDoctor &&
                idNurse == procedure.idNurse &&
                dayNumber == procedure.dayNumber &&
                completed == procedure.completed &&
                Objects.equals(procedureName, procedure.procedureName) &&
                Objects.equals(frequencu, procedure.frequencu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProcedure, idMap, idUser, idDoctor, idNurse, procedureName, frequencu, dayNumber, completed);
    }

    public int getIdProcedure() {
        return idProcedure;
    }

    public void setIdProcedure(int idProcedure) {
        this.idProcedure = idProcedure;
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

    public int getIdNurse() {
        return idNurse;
    }

    public void setIdNurse(int idNurse) {
        this.idNurse = idNurse;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getFrequencu() {
        return frequencu;
    }

    public void setFrequencu(String frequencu) {
        this.frequencu = frequencu;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Procedure(int idProcedure, int idMap, int idUser, int idDoctor, int idNurse, String procedureName, String frequencu, int dayNumber, boolean completed) {
        this.idProcedure = idProcedure;
        this.idMap = idMap;
        this.idUser = idUser;
        this.idDoctor = idDoctor;
        this.idNurse = idNurse;
        this.procedureName = procedureName;
        this.frequencu = frequencu;
        this.dayNumber = dayNumber;
        this.completed = completed;
    }

    private boolean completed;
}
