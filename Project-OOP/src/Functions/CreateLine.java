package Functions;

import Commands.Command;
import Commands.Context;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

public class CreateLine extends Command {
    public CreateLine(Context context) {
        super(context);
    }

    @Override
    public String execute() {
        Element line = context.getDoc().createElement("line");

        Attr attr1 = context.getDoc().createAttribute("x1=");
        attr1.setValue(context.getCommandOptions()[2]);
        line.setAttributeNode(attr1);
        Attr attr2 = context.getDoc().createAttribute("y1=");
        attr2.setValue(context.getCommandOptions()[3]);
        line.setAttributeNode(attr2);
        Attr attr3 = context.getDoc().createAttribute("x2=");
        attr3.setValue(context.getCommandOptions()[4]);
        line.setAttributeNode(attr3);
        Attr attr4 = context.getDoc().createAttribute("y2=");
        attr4.setValue(context.getCommandOptions()[5]);
        line.setAttributeNode(attr4);
        Attr attr5 = context.getDoc().createAttribute("fill=");
        attr5.setValue(context.getCommandOptions()[6]);
        line.setAttributeNode(attr5);
        return null;
    }
}
