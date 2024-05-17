package Commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Save extends Command {
    public Save(Context context) {
        super(context);
        helpString = "saves the currently open file";
    }

    public String execute(){
        if (context.getFileName() == null || context.getDoc() == null){
          return "There isn't an opened file";
        }
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(context.getDoc());
            if (context.getDoc().getDoctype() != null) {
                transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, context.getDoc().getDoctype().getPublicId());
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, context.getDoc().getDoctype().getSystemId());
            }
            StreamResult result = new StreamResult(context.getFileName());
            transformer.transform(source, result);
            //The transformer closes the file
            return "Successfully saved "+context.getFileName();
        } catch (Exception e) {
            return "Could not save file "+context.getFileName()+": "+e.toString();
        }
    }
}
