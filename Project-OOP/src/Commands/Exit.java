package Commands;

public class Exit extends Command {
    public Exit(Context context) {
        super(context);
    }

    public String execute(){
        context.done = true;
        return "Exiting program";

    }
}
