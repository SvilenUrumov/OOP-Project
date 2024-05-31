package Commands;

import Application.Command;
import Application.Context;
import Shapes.Circle;
import Shapes.Point;
import Shapes.Rectangle;

import javax.xml.transform.TransformerException;

public class Within extends Command {

    public Within(Context context) {
        super(context);
        helpString = "checks if there are any figures withing the chosen shape circle/rectangle";
        cmdString = "<option>";
    }

    @Override
    public String execute() throws TransformerException {
        int count = 0;
        if (context.getCommandOptions().length<5){
            System.out.println("There are missing parameters");
        }
        else{
            switch (context.getCommandOptions()[1]){
                case "circle":
                    float cx = Float.parseFloat(context.getCommandOptions()[2]);
                    float cy = Float.parseFloat(context.getCommandOptions()[3]);
                    float r = Float.parseFloat(context.getCommandOptions()[4]);
                    Circle circle = new Circle(new Point(cx,cy),r,null, null);
                    for (int i=0;i< context.shapes.size();i++){
                       if (context.shapes.get(i).isWithin(circle)){
                           System.out.println(i+1+"."+" "+context.shapes.get(i).stringBuilder());
                           count++;
                       }

                    }
                    System.out.println("The number of shapes within the circle is "+count);

                    break;
                case "rectangle":
                    float x = Float.parseFloat(context.getCommandOptions()[2]);
                    float y = Float.parseFloat(context.getCommandOptions()[3]);
                    float width = Float.parseFloat(context.getCommandOptions()[4]);
                    float height = Float.parseFloat(context.getCommandOptions()[5]);
                    Rectangle rectangle = new Rectangle(new Point(x,y),width,height,null,null);
                    for (int i=0;i< context.shapes.size();i++){
                        if (context.shapes.get(i).isWithin(rectangle)){
                            System.out.println(i+1+"."+" "+context.shapes.get(i).stringBuilder());
                            count++;
                        }

                    }
                    System.out.println("The number of shapes within the rectangle is "+count);
                    break;
                default:
                    break;
            }
        }
        return "OK";
    }
}
