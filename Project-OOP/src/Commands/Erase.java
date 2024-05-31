package Commands;

import Application.Command;
import Application.Context;

import javax.xml.transform.TransformerException;

public class Erase extends Command {
    public Erase(Context context) {
        super(context);
        helpString = "deletes the chosen figure";
        cmdString = "<n>";
    }

    @Override
    public String execute() throws TransformerException {
        if (context.getCommandOptions().length<2){
            return "Missing figure number";
        }
        try {
            if (context.getCommandOptions()[1].chars().allMatch(Character::isDigit)) {
                context.shapes.get(Integer.parseInt(context.getCommandOptions()[1]) - 1).removeNODE();
                context.shapes.remove(Integer.parseInt(context.getCommandOptions()[1]) - 1);
                return "Deleted figure " + context.getCommandOptions()[1];
            }
        }
        catch(Exception e){
            return "There is no figure number " + context.getCommandOptions()[1];
        }
        return "Wrong parameters";
    }
}
