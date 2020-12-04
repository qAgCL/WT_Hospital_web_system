package app.controller.command.commands;

import app.bean.User;
import app.constants.ConstantNameFromJsp;
import app.controller.command.ICommand;
import app.service.UserService;
import app.service.exception.ServiceExcep;
import app.service.factory.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInCommand implements ICommand {

    private static final String REDIRECT_COMMAND_SUCCESS = "Controller?command=go_to_main";
    private static final String REDIRECT_COMMAND_ERROR = "Controller?command=go_to_signin&signin=error";
    private static final String USER_SESSION_ATTR = "user";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String login = req.getParameter(ConstantNameFromJsp.REQUEST_PARAMETER_USERNAME);
        String password = req.getParameter(ConstantNameFromJsp.REQUEST_PARAMETER_LOGIN);

        User user;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        HttpSession session = req.getSession(true);


        try {
            user = userService.signIn(login, password);

            if (user == null) {
                resp.sendRedirect(REDIRECT_COMMAND_ERROR);
                return;
            }
            session.setAttribute(USER_SESSION_ATTR, user);
            resp.sendRedirect(REDIRECT_COMMAND_SUCCESS);
        } catch (ServiceExcep e) {
            // log
            resp.sendRedirect(REDIRECT_COMMAND_ERROR);
        }

    }
}
