package Commands;

import javax.xml.transform.TransformerException;

public class Erase extends Command{
    public Erase(Context context) {
        super(context);
        helpString = "deletes the chosen figure";
        cmdString = "<n>";
    }

    @Override
    public String execute() throws TransformerException {
        if (context.getCommandOptions().length<2){
            System.out.println("Please choose a figure to erase");
        }
        else if(context.getCommandOptions()[1].chars().allMatch( Character::isDigit )&&context.getCommandOptions().length == 2){
            for (int i=0;i<context.shapes.size();i++){
                if (Integer.parseInt(context.getCommandOptions()[1]) == (context.shapes.indexOf(context.shapes.get(i)))+1){
                    context.shapes.remove(context.shapes.get(i));
                }
            }
        }
        return "Deleted the chosen figure";
    }
}
