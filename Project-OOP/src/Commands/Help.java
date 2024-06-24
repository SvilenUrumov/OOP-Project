package Commands;

import Application.Command;
import Application.Context;

public class Help extends Command {
    public Help(Context context) {
        super(context);
        helpString = "displays this help string";
        cmdString = "";
    }

    public String execute(){
        context.menu.forEach((cmdName,command) ->
                System.out.format("%-20s %s \n",cmdName+command.cmdString,command.helpString));
        return "";
    }
}
