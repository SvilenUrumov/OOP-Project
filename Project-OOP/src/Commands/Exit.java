package Commands;

import Application.Command;
import Application.Context;

public class Exit extends Command {
    public Exit(Context context) {
        super(context);
        helpString = "exits the program";
        cmdString = "";
    }

    public String execute(){
        context.setDone(true);
        return "Exiting program";

    }
}
