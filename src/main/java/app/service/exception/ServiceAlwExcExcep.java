package app.service.exception;

public class ServiceAlwExcExcep extends ServiceExcep {
    public ServiceAlwExcExcep() {
        super();
    }

    public ServiceAlwExcExcep(String message) {
        super(message);
    }

    public ServiceAlwExcExcep(String message, Throwable cause) {
        super(message, (Exception) cause);
    }

    public ServiceAlwExcExcep(Throwable cause) {
        super(cause);
    }
}
