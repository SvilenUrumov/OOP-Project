package Commands;

public class Exit extends Command {
    public Exit(Context context) {
        super(context);
        helpString = "exists the program";
    }

    public String execute(){
        context.done = true;
        return "Exiting program";

    }
}
