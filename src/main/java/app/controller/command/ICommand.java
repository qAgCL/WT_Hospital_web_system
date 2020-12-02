package app.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ICommand {
     void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
