package app.dao.exception;

public class DAOUserExistExp extends DAOException {
    public DAOUserExistExp() {
        super();
    }

    public DAOUserExistExp(String message) {
        super(message);
    }

    public DAOUserExistExp(String message, Throwable cause) {
        super(message, (Exception) cause);
    }

    public DAOUserExistExp(Throwable cause) {
        super(cause);
    }
}
