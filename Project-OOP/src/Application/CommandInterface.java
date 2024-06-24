package Application;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

public interface CommandInterface {
    public String execute() throws TransformerException;
}
