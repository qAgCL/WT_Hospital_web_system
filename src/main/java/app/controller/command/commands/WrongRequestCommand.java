package app.controller.command.commands;

import app.constants.ConstantNameFromJsp;
import app.controller.command.ICommand;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WrongRequestCommand implements ICommand {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(ConstantNameFromJsp.ERROR_PAGE_URI);
        dispatcher.forward(req, resp);
    }
}
