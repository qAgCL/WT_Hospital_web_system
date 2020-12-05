package app.bean;

import java.util.Date;
import java.util.Objects;

public class Operation {
    private int idOperation;
    private int idMap;
    private int idUser;
    private int idDoctor;
    private String name;
    private Date operationDate;
    private boolean completed;

    public Operation(int idOperation, int idMap, int idUser, int idDoctor, String name, Date operationDate, boolean completed) {
        this.idOperation = idOperation;
        this.idMap = idMap;
        this.idUser = idUser;
        this.idDoctor = idDoctor;
        this.name = name;
        this.operationDate = operationDate;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "idOperation=" + idOperation +
                ", idMap=" + idMap +
                ", idUser=" + idUser +
                ", idDoctor=" + idDoctor +
                ", name='" + name + '\'' +
                ", operationDate=" + operationDate +
                ", completed=" + completed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return idOperation == operation.idOperation &&
                idMap == operation.idMap &&
                idUser == operation.idUser &&
                idDoctor == operation.idDoctor &&
                completed == operation.completed &&
                Objects.equals(name, operation.name) &&
                Objects.equals(operationDate, operation.operationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOperation, idMap, idUser, idDoctor, name, operationDate, completed);
    }

    public int getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(int idOperation) {
        this.idOperation = idOperation;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
