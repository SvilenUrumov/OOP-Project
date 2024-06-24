package Shapes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public abstract class Shape implements Within{
    protected Node SVGNode;
    protected String color;
    public abstract void translate(float verticalShift,float horizontalShift);
    public void removeNODE(){
        if (SVGNode != null){
            Node parent = SVGNode.getParentNode();
            parent.removeChild(SVGNode);
            SVGNode = null;
        }
    }

    public abstract void syncNode(Document doc);
    public abstract String stringBuilder();


}
