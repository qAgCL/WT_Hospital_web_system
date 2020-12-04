package app.controller.command.commands;

import app.controller.command.ICommand;
import app.service.UserService;
import app.service.exception.ServiceAlwExcExcep;
import app.service.exception.ServiceExcep;
import app.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class SignUpCommand implements ICommand {

    private static final String REQUEST_PARAMETER_PASSWORD = "password";
    private static final String REQUEST_PARAMETER_NAME = "name";
    private static final String REQUEST_PARAMETER_SURNAME = "surname";
    private static final String REQUEST_PARAMETER_EMAIL = "email";
    private static final String REQUEST_PARAMETER_PHONE = "phone";
    private static final String REQUEST_PARAMETER_DATE_OF_BIRTH = "birth";
    private static final String REDIRECT_COMMAND_SUCCESS = "Controller?command=go_to_signin&signup=success";
    private static final String REDIRECT_COMMAND_ERROR = "Controller?command=go_to_signup&signup=error";
    private static final String REDIRECT_COMMAND_ERROR_DUPLICATE = "Controller?command=go_to_signup&signup=unique";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        byte[] password = req.getParameter(REQUEST_PARAMETER_PASSWORD).getBytes();
        String name = req.getParameter(REQUEST_PARAMETER_NAME);
        String surname = req.getParameter(REQUEST_PARAMETER_SURNAME);
        String email = req.getParameter(REQUEST_PARAMETER_EMAIL);
        String phone = req.getParameter(REQUEST_PARAMETER_PHONE);
        String birth = req.getParameter(REQUEST_PARAMETER_DATE_OF_BIRTH);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        boolean registrationResult;
        try {

            Date dateBirth = Date.valueOf(birth);
            registrationResult = userService.registration(name,surname,email,password,phone,dateBirth);

            if (registrationResult) {
                resp.sendRedirect(REDIRECT_COMMAND_SUCCESS);
            } else {
                resp.sendRedirect(REDIRECT_COMMAND_ERROR);
            }
        } catch (ServiceAlwExcExcep e) {
            resp.sendRedirect(REDIRECT_COMMAND_ERROR_DUPLICATE);
        } catch (ServiceExcep e) {
            resp.sendRedirect(REDIRECT_COMMAND_ERROR);
        }
    }
}
