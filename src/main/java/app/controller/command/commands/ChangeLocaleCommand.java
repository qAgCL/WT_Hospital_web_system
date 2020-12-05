package app.controller.command.commands;

import app.constants.ConstantNameFromJsp;
import app.controller.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLocaleCommand implements ICommand {
    private static final String REDIRECT_COMMAND = "Controller?command=go_to_start";
    private static final String LOCAL_SESSION_ATTR = "local";
    private static final String LOCAL_REQ_ATTR = "local";

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(true);
        session.setAttribute(LOCAL_SESSION_ATTR, req.getParameter(LOCAL_REQ_ATTR));

        if (session.getAttribute(ConstantNameFromJsp.LAST_REQUEST_PARAM) != null)
        {
            resp.sendRedirect(session.getAttribute(ConstantNameFromJsp.LAST_REQUEST_PARAM).toString());
        }
        else {
            resp.sendRedirect(REDIRECT_COMMAND);
        }
    }
}
