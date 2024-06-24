package Commands;

import Application.Command;
import Application.Context;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.OutputKeys;

public class SaveAs extends Command {
    public SaveAs(Context context) {
        super(context);
        helpString = "saves the currently open file in <file>";
        cmdString = " <file>";
    }

    public String execute(){
        if (context.getFileName() == null || context.getDoc() == null){
            return "There isn't an opened file";
        }
        if (context.getCommandOptions().length<2){
            return "Missing file name";
        }
        try{
            for (int i=0;i< context.shapes.size();i++){
                context.getShapes().get(i).syncNode(context.getDoc());
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(context.getDoc());
            if (context.getDoc().getDoctype() != null) {
                transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, context.getDoc().getDoctype().getPublicId());
                transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, context.getDoc().getDoctype().getSystemId());
            }
            StreamResult result = new StreamResult(context.getCommandOptions()[1]);
            context.setFileName(context.getCommandOptions()[1]);
            transformer.transform(source, result);
            return "Successfully saved "+context.getFileName();
        } catch (Exception e) {
            return "Could not save file "+context.getFileName()+": "+e.toString();
        }
    }
}
