package Commands;

import Application.Command;
import Application.Context;
import Shapes.Point;
import Shapes.Rectangle;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.FileInputStream;

public class Open extends Command {
    String fileName = null;
    StringBuilder data = null;

    public Open(Context context) {
        super(context);
        helpString = "closes currently opened file";
        cmdString = " <file>";
    }
    private void parseTree(Node doc) {
        if (doc == null) {
            return;
        }
        try {


            NamedNodeMap cl = doc.getAttributes();
            switch(doc.getNodeName()){
                case "rect":
                    Node x = cl.getNamedItem("x");
                    Node y = cl.getNamedItem("y");
                    Node width = cl.getNamedItem("width");
                    Node height = cl.getNamedItem("height");
                    Node fill = cl.getNamedItem("fill");
                    float xVal = Float.parseFloat(x.getNodeValue());
                    float yVal = Float.parseFloat(y.getNodeValue());
                    float widthVal = Float.parseFloat(width.getNodeValue());
                    float heightVal = Float.parseFloat(height.getNodeValue());
                    String fillRectVal = fill.getNodeValue();
                    Rectangle rectangle = new Rectangle(new Shapes.Point(xVal,yVal),widthVal,heightVal, fillRectVal,doc);
                    context.shapes.add(rectangle);
                case "circle":
                    Node cx = cl.getNamedItem("cx");
                    Node cy = cl.getNamedItem("cy");
                    Node fillCircle = cl.getNamedItem("fill");
                    Node r = cl.getNamedItem("r");
                    float cxVal = Float.parseFloat(cx.getNodeValue());
                    float cyVal = Float.parseFloat(cy.getNodeValue());
                    float rVal = Float.parseFloat(r.getNodeValue());
                    String fillCircleVal = fillCircle.getNodeValue();
                    Shapes.Circle circle = new Shapes.Circle(new Shapes.Point(cxVal,cyVal),rVal,fillCircleVal,doc);
                    context.shapes.add(circle);
                case "line":
                    Node x1 = cl.getNamedItem("x1");
                    Node y1 = cl.getNamedItem("y1");
                    Node x2 = cl.getNamedItem("x2");
                    Node y2 = cl.getNamedItem("y2");
                    Node fillLine = cl.getNamedItem("fill");
                    float x1Val = Float.parseFloat(x1.getNodeValue());
                    float y1Val = Float.parseFloat(y1.getNodeValue());
                    float x2Val = Float.parseFloat(x2.getNodeValue());
                    float y2Val = Float.parseFloat(y2.getNodeValue());
                    String fillLineVal = fillLine.getNodeValue();
                    Shapes.Line line = new Shapes.Line(new Shapes.Point(x1Val,y1Val),new Point(x2Val,y2Val), fillLineVal,doc);
                    context.shapes.add(line);
                    break;
                default:
            }
            if (cl != null) {
                for (int i = 0; i < cl.getLength(); i++) {
                    Node node = cl.item(i);


                }
            }
            NodeList nl = doc.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                parseTree(node);
            }
        } catch (Throwable e) {
        }
    }

    public String execute() {
        fileName = context.getCommandOptions()[1];
        System.out.println(fileName);
        try {
            FileInputStream myFile = new FileInputStream(fileName);
            context.setDoc(context.getDocumentBuilder().parse(myFile));
            context.setFileName(fileName);
            myFile.close();

            context.shapes.clear();
            parseTree(context.getDoc());
            return "The file was opened successfully";
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String getFileName() {
        return fileName;
    }
}

