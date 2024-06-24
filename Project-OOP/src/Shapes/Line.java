package Shapes;

import org.w3c.dom.*;

public class Line extends Shape implements Within{
    public static final String SHAPE_NAME = "line";
    private Point start;
    private Point end;

    public Line(Point start, Point end, String color, Node SVGnode) {
        this.start = start;
        this.end = end;
        this.SVGNode = SVGnode;
        this.color = color;
    }
    @Override
    public String stringBuilder() {
        String str=SHAPE_NAME+" "+start.getX()+" "+start.getY()+" "+end.getX()+" "+end.getY()+" "+color;
        return str;
    }

    @Override
    public void translate(float verticalShift, float horizontalShift) {
        start.translate(verticalShift,horizontalShift);
        end.translate(verticalShift,horizontalShift);
    }

    @Override
    public void syncNode(Document doc) {
        if (SVGNode == null){
            SVGNode = doc.createElement("line");
            doc.getDocumentElement().appendChild(SVGNode);
            Attr a = doc.createAttribute("x1");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("y1");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("x2");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("y2");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("stroke");
            ((Element)SVGNode).setAttributeNode(a);
        }

        NamedNodeMap nodeMap = SVGNode.getAttributes();
        nodeMap.getNamedItem("x1").setNodeValue(String.valueOf(start.getX()));
        nodeMap.getNamedItem("y1").setNodeValue(String.valueOf(start.getY()));
        nodeMap.getNamedItem("x2").setNodeValue(String.valueOf(end.getX()));
        nodeMap.getNamedItem("y2").setNodeValue(String.valueOf(end.getY()));
        nodeMap.getNamedItem("stroke").setNodeValue(color);
    }

    @Override
    public boolean isWithin(Circle circle) {
        if (start.isWithin(circle)&&end.isWithin(circle)){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public boolean isWithin(Rectangle rectangle) {
        if (start.isWithin(rectangle)&& end.isWithin(rectangle)){
            return true;
        }
        else{
            return false;
        }
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
