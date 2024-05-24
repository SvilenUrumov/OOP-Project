package Commands;

public abstract class Command implements CommandInterface{
    protected Context context;
    public String helpString;
    public String cmdString;

    public Command(Context context) {
        this.context = context;
    }


}
