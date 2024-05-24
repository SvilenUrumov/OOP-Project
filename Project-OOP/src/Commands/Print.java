package Commands;

import javax.xml.transform.TransformerException;

public class Print extends Command{
    public Print(Context context) {
        super(context);
        helpString = "prints out every shape";
        cmdString = "";
    }

    @Override
    public String execute() throws TransformerException {
        for (int i=0;i<context.shapes.size();i++){
            System.out.println(i+1+"."+" "+context.shapes.get(i).stringBuilder());
        }
        return "Total shapes: "+context.shapes.size();
    }
}
