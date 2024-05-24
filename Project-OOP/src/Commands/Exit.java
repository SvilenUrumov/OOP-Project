package Commands;

public class Exit extends Command {
    public Exit(Context context) {
        super(context);
        helpString = "exits the program";
        cmdString = "";
    }

    public String execute(){
        context.done = true;
        return "Exiting program";

    }
}
