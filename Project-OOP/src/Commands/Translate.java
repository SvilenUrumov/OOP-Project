package Commands;

import Application.Command;
import Application.Context;

import javax.xml.transform.TransformerException;

public class Translate extends Command {
    public Translate(Context context) {
        super(context);
        helpString = "translates the selected figure ";
        cmdString = "";
    }

    @Override
    public String execute() throws TransformerException {
        int verticalShift = 0;
        int horizontalShift = 0;
        if (context.getCommandOptions()[1].chars().allMatch( Character::isDigit )&& context.getCommandOptions().length==4){
            System.out.println(context.getCommandOptions()[1]);
            Shapes.Shape s = context.shapes.get(Integer.parseInt(context.getCommandOptions()[1])-1);
            for (int i=2;i<4;i++){
                String[] strArr1 = context.getCommandOptions()[i].split("=",2);
                switch (strArr1[0]){
                    case    "vertical":
                        verticalShift = Integer.parseInt(strArr1[1]);
                        break;
                    case "horizontal":
                        horizontalShift = Integer.parseInt(strArr1[1]);
                        break;
                    default:
                        break;
                }
            }
            s.translate(verticalShift,horizontalShift);
            return "Translated the chosen shape";
        }
        else if (context.getCommandOptions().length==3){
            for (int i=1;i<3;i++){
                String[] strArr1 = context.getCommandOptions()[i].split("=",2);
                switch (strArr1[0]){
                    case    "vertical":
                        verticalShift = Integer.parseInt(strArr1[1]);
                        break;
                    case "horizontal":
                        horizontalShift = Integer.parseInt(strArr1[1]);
                        break;
                    default:
                        break;
                }
            }
            for (int i=0;i<context.shapes.size();i++){
                context.shapes.get(i).translate(verticalShift,horizontalShift);
            }
            return "Translated all figures";
        }
        return null;
    }
}
