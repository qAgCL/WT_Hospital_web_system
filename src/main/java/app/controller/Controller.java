package app.controller;

import app.controller.command.CommandRouter;
import app.controller.command.ICommand;
import app.constants.ConstantNameFromJsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller extends HttpServlet {

    public Controller() {
        super();
    }

    private final CommandRouter router = new CommandRouter();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processGetRequest(req, resp);
        return;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processPostRequest(req, resp);
        return;
    }

    private void processGetRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String commandName;
        ICommand executionCommand;

        commandName = req.getParameter(ConstantNameFromJsp.REQUEST_PARAMETER_COMMAND);
        executionCommand = router.getCommand(commandName);
        executionCommand.execute(req,resp);

        req.getSession(true).setAttribute(ConstantNameFromJsp.LAST_REQUEST_PARAM, req.getRequestURI() + "?" + req.getQueryString());
    }

    private void processPostRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String commandName;
        ICommand executionCommand;

        commandName = req.getParameter(ConstantNameFromJsp.REQUEST_PARAMETER_COMMAND);
        executionCommand = router.getCommand(commandName);

        executionCommand.execute(req,resp);
    }
}
