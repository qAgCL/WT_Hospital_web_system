package app.controller.command;

import java.util.HashMap;
import app.controller.command.commands.*;
import java.util.Map;

public class CommandRouter {

    private Map<CommandName, ICommand> commandsMap = new HashMap<CommandName, ICommand>();

    public CommandRouter(){
        commandsMap.put(CommandName.SIGNIN, new SignInCommand());
        commandsMap.put(CommandName.GO_TO_MAIN, new GoToMainPageCommand());
        commandsMap.put(CommandName.WRONG_REQUEST, new WrongRequestCommand());
        commandsMap.put(CommandName.GO_TO_SIGNIN, new GoToSignInPageCommand());
        commandsMap.put(CommandName.GO_TO_SIGNUP, new GoToSignUpPageCommand());
       // commandsMap.put(CommandName.SIGNUP, new SignUpCommand());
    }
    public ICommand getCommand(String name){

        CommandName commandName = null;
        ICommand command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commandsMap.get(commandName);
        }
        catch (Exception e) {
            if ((e instanceof IllegalArgumentException)||(e instanceof NullPointerException)){
                command = commandsMap.get(CommandName.WRONG_REQUEST);
            }
        }
        return command;

    }
}