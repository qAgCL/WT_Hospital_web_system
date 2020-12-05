package app.bean;

import java.util.Objects;

public class Medicine {
    private int idMedcine;
    private int idMap;
    private int idUser;
    private int idDoctor;
    private int idNurse;
    private String medicineName;
    private String frequencu;
    private int dayNumber;
    private boolean discharged;

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public Medicine(int idMedcine, int idMap, int idUser, int idDoctor, int idNurse, String medicineName, String frequencu, int dayNumber, boolean discharged) {
        this.idMedcine = idMedcine;
        this.idMap = idMap;
        this.idUser = idUser;
        this.idDoctor = idDoctor;
        this.idNurse = idNurse;
        this.medicineName = medicineName;
        this.frequencu = frequencu;
        this.dayNumber = dayNumber;
        this.discharged = discharged;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "idMedcine=" + idMedcine +
                ", idMap=" + idMap +
                ", idUser=" + idUser +
                ", idDoctor=" + idDoctor +
                ", idNurse=" + idNurse +
                ", medicineName='" + medicineName + '\'' +
                ", frequencu='" + frequencu + '\'' +
                ", dayNumber=" + dayNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return idMedcine == medicine.idMedcine &&
                idMap == medicine.idMap &&
                idUser == medicine.idUser &&
                idDoctor == medicine.idDoctor &&
                idNurse == medicine.idNurse &&
                dayNumber == medicine.dayNumber &&
                Objects.equals(medicineName, medicine.medicineName) &&
                Objects.equals(frequencu, medicine.frequencu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMedcine, idMap, idUser, idDoctor, idNurse, medicineName, frequencu, dayNumber);
    }

    public int getIdMedcine() {
        return idMedcine;
    }

    public void setIdMedcine(int idMedcine) {
        this.idMedcine = idMedcine;
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

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
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
}
