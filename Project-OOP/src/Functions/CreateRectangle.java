package Functions;

import Commands.Command;
import Commands.Context;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;
import java.util.Objects;

public class CreateRectangle extends Command {


    public CreateRectangle(Context context) {
        super(context);
    }

    @Override
    public String execute() {
        Element rectangle = context.getDoc().createElement("rect");

        rectangle.setAttribute("x=",context.getCommandOptions()[2]);
        rectangle.setAttribute("y=",context.getCommandOptions()[3]);
        rectangle.setAttribute("width=",context.getCommandOptions()[4]);
        rectangle.setAttribute("height=",context.getCommandOptions()[5]);

        Attr attr1 = context.getDoc().createAttribute("x=");
        attr1.setValue(context.getCommandOptions()[2]);
        rectangle.setAttributeNode(attr1);
        Attr attr2 = context.getDoc().createAttribute("y=");
        attr2.setValue(context.getCommandOptions()[3]);
        rectangle.setAttributeNode(attr2);
        Attr attr3 = context.getDoc().createAttribute("width=");
        attr3.setValue(context.getCommandOptions()[4]);
        rectangle.setAttributeNode(attr3);
        Attr attr4 = context.getDoc().createAttribute("height=");
        attr4.setValue(context.getCommandOptions()[5]);
        rectangle.setAttributeNode(attr4);
        Attr attr5 = context.getDoc().createAttribute("fill=");
        attr5.setValue(context.getCommandOptions()[6]);
        rectangle.setAttributeNode(attr5);
        return null;
    }
}
