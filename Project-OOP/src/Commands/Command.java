package Commands;

public abstract class Command implements CommandInterface{
    protected Context context;
    protected String helpString;

    public Command(Context context) {
        this.context = context;
    }


}
