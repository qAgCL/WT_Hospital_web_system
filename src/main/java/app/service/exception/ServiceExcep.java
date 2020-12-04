package app.service.exception;

public class ServiceExcep extends Exception {
    public ServiceExcep(String message, Exception e)  {
        super(message, e);
    }

    public ServiceExcep() {
        super();
    }

    public ServiceExcep(String message) {
        super(message);
    }

    public ServiceExcep(Throwable cause) {
        super(cause);
    }

    protected ServiceExcep(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}