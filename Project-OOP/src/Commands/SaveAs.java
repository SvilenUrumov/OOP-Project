package Commands;

import org.w3c.dom.DocumentType;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.transform.OutputKeys;

public class SaveAs extends Command {
    public SaveAs(Context context) {
        super(context);
    }

    public String execute(){
        if (context.getFileName() == null || context.getDoc() == null){
            return "There isn't an opened file";
        }
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(context.getDoc());
            if (context.getCommandOptions().length<2){
                return "Missing file name";
            }

            if (context.getDoc().getDoctype() != null) {
                transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, context.getDoc().getDoctype().getPublicId());
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, context.getDoc().getDoctype().getSystemId());
            }
            StreamResult result = new StreamResult(context.getCommandOptions()[1]);
            transformer.transform(source, result);
            context.setFileName(context.getCommandOptions()[1]);
            return "Successfully saved "+context.getFileName();
        } catch (Exception e) {
            return "Could not save file "+context.getFileName()+": "+e.toString();
        }
    }
}
