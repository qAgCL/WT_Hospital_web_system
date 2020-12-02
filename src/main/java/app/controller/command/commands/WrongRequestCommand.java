package app.controller.command.commands;

import app.controller.command.ICommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WrongRequestCommand implements ICommand {
    public void execute(HttpServletRequest req, HttpServletResponse resp) {

    }
}
