package Commands;

import Application.Command;
import Application.Context;
import Shapes.Circle;
import Shapes.Line;
import Shapes.Point;
import Shapes.Rectangle;

import javax.xml.transform.TransformerException;

public class Create extends Command {
    public Create(Context context) {
        super(context);
        helpString = "Creates a shape";
        cmdString = "";
    }

    @Override
    public String execute() throws TransformerException {
        switch (context.getCommandOptions()[1]){
            case "rectangle":
                if (context.getCommandOptions().length<7){
                    return "Not enough parameters";
                }
                float x = Float.parseFloat(context.getCommandOptions()[2]);
                float y = Float.parseFloat(context.getCommandOptions()[3]);
                float width = Float.parseFloat(context.getCommandOptions()[4]);
                float height = Float.parseFloat(context.getCommandOptions()[5]);
                String rectangleColor = context.getCommandOptions()[6];
                Rectangle rectangle = new Rectangle(new Point(x,y),width,height,rectangleColor, null);
                context.getShapes().add(rectangle);
                break;

            case "circle":
                if (context.getCommandOptions().length<6){
                    return "Not enough parameters";
                }
                float cx = Float.parseFloat(context.getCommandOptions()[2]);
                float cy = Float.parseFloat(context.getCommandOptions()[3]);
                float r = Float.parseFloat(context.getCommandOptions()[4]);
                String circleColor = context.getCommandOptions()[5];
                Circle circle = new Circle(new Point(cx,cy),r,circleColor, null);
                context.getShapes().add(circle);
                break;
            case "line":
                if (context.getCommandOptions().length<7){
                    return "Not enough parameters";
                }
                float x1 = Float.parseFloat(context.getCommandOptions()[2]);
                float y1 = Float.parseFloat(context.getCommandOptions()[3]);
                float x2 = Float.parseFloat(context.getCommandOptions()[4]);
                float y2 = Float.parseFloat(context.getCommandOptions()[5]);
                String lineColor = context.getCommandOptions()[6];
                Line line = new Line(new Point(x1,y1),new Point(x2,y2),lineColor, null);
                context.getShapes().add(line);
                break;
            default:
                return "Unknown shape";
        }
        return "OK";
    }
}
