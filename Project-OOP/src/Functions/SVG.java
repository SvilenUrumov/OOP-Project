package Functions;

import Commands.Command;
import Commands.Context;
import org.w3c.dom.Element;

public class SVG extends Command {

    public SVG(Context context) {
        super(context);
    }

    @Override
    public String execute() {
        Element rootElement = context.getDoc().createElement("svg");
        context.getDoc().appendChild(rootElement);
        return null;
    }
}
