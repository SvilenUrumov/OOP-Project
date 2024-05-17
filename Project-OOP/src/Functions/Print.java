package Functions;

import Commands.Command;
import Commands.Context;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class Print extends Command {
    public Print(Context context) {
        super(context);
    }

    @Override
    public String execute() throws TransformerException {
        Element docElement = context.getDoc().getDocumentElement();
        NodeList nodeList = docElement.getChildNodes();
        int length = nodeList.getLength();

        return null;
    }
}
