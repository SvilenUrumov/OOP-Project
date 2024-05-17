package Functions;

import Commands.Command;
import Commands.Context;

import java.util.Objects;

public class Create extends Command {
    public Create(Context context) {
        super(context);
    }

    @Override
    public String execute(){
      /*  if (Objects.equals(context.getCommandOptions()[1], "rectangle")){
            CreateRectangle createRectangle = new CreateRectangle();
            createRectangle.execute();

        }
        else if (Objects.equals(context.getCommandOptions()[1], "line")){
            CreateLine createLine = new CreateLine();
            createLine.execute();
        }
        else if (Objects.equals(context.getCommandOptions()[1], "circle")){
           CreateCircle createCircle = new CreateCircle();
            createCircle.execute();
        }
        else{
            System.out.println("The chosen shape could not be created");
        }*/

        return null;
    }
}
