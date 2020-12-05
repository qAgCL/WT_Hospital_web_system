package app.service.factory;


import app.service.DiseaseMapService;
import app.service.UserService;
import app.service.impl.DiseaseMapServiceImpl;
import app.service.impl.UserServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final DiseaseMapService diseaseMapService = new DiseaseMapServiceImpl() ;

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

}
