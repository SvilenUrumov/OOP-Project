package Commands;

import Application.Command;
import Application.Context;

import javax.xml.transform.TransformerException;

public class Print extends Command {
    public Print(Context context) {
        super(context);
        helpString = "prints out every shape";
        cmdString = "";
    }

    @Override
    public String execute() throws TransformerException {
        for (int i=0;i<(context.getShapes().size());i++){
            System.out.println(i+1+"."+" "+context.getShapes().get(i).stringBuilder());
        }
        return "Total shapes: "+context.getShapes().size();
    }
}
