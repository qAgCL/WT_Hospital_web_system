package app.service;

import app.bean.User;
import app.service.exception.ServiceExcep;


import java.util.Date;

public interface UserService {
    void registration(String name, String surname, String email, String password, String phone, Date birthDate) throws ServiceExcep;
    User signIn (String login, String password) throws ServiceExcep;
}
