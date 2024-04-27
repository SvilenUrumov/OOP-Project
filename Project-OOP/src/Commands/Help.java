package Commands;

public class Help extends Command {
    public Help(Context context) {
        super(context);
    }

    public String execute(){
        System.out.println("The following commands are supported:");
        System.out.println("open <file>         opens <file>");
        System.out.println("close               closes currently opened file");
        System.out.println("save                saves the currently open file");
        System.out.println("saveas <file>       saves the currently open file in <file>");
        System.out.println("help                prints this information");
        System.out.println("print               prints out all shapes");
        System.out.println("create              creates a new shape");
        System.out.println("erase <n>           erases shapes with the number <n>");
        System.out.println("translate [<n>]     ");
        System.out.println("within <option>     ");
        System.out.println("exit                exists the program");
        return null;
    }
}
