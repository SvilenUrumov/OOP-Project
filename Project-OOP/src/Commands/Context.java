package Commands;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

public class Context {
    private String fileName;
    private String[] commandOptions;
    private Object currentFile;
    private DocumentBuilder documentBuilder;
    private Document doc;
    public Boolean done;

    private DocumentBuilder prepareBuilder() throws ParserConfigurationException {
        //TODO-Add try catch
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true);
        dbFactory.setValidating(true);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        return dBuilder;
    }

    public Context() throws ParserConfigurationException {
       this.documentBuilder= prepareBuilder();
       this.done = false;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[] getCommandOptions() {
        return commandOptions;
    }

    public void setCommandOptions(String[] commandOptions) {
        this.commandOptions = commandOptions;
    }

    public DocumentBuilder getDocumentBuilder() {
        return documentBuilder;
    }

    public void setDocumentBuilder(DocumentBuilder documentBuilder) {
        this.documentBuilder = documentBuilder;
    }

    public Object getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(Object currentFile) {
        this.currentFile = currentFile;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }
}
