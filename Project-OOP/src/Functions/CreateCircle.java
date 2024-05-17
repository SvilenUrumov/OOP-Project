package Functions;

import Commands.Command;
import Commands.Context;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

public class CreateCircle extends Command {

    public CreateCircle(Context context) {
        super(context);
    }

    @Override
    public String execute() {
        Element circle = context.getDoc().createElement("circle");

        Attr attr1 = context.getDoc().createAttribute("x=");
        attr1.setValue(context.getCommandOptions()[2]);
        circle.setAttributeNode(attr1);
        Attr attr2 = context.getDoc().createAttribute("y=");
        attr2.setValue(context.getCommandOptions()[3]);
        circle.setAttributeNode(attr2);
        Attr attr3 = context.getDoc().createAttribute("r=");
        attr3.setValue(context.getCommandOptions()[4]);
        circle.setAttributeNode(attr3);
        Attr attr4 = context.getDoc().createAttribute("fill=");
        attr4.setValue(context.getCommandOptions()[5]);
        circle.setAttributeNode(attr4);
        return null;
    }
}
