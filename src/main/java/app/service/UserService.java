package app.service;

import app.bean.User;
import app.service.exception.ServiceExcep;


import java.sql.Date;

public interface UserService {
    boolean registration(String name, String surname, String email, byte[] password, String phone, Date birthDate) throws ServiceExcep;
    User signIn (String login, byte[] password) throws ServiceExcep;
}
