package Shapes;

import org.w3c.dom.*;

public class Circle extends Shape implements Within{
    public static final String SHAPE_NAME = "circle";
    private Point center;
    private float radius;

    public Circle(Point center, float radius, String color, Node SVGNode) {
        this.center = center;
        this.radius = radius;
        this.SVGNode = SVGNode;
        this.color = color;
    }

    @Override
    public void translate(float verticalShift, float horizontalShift) {
        center.translate(verticalShift,horizontalShift);
    }

    @Override
    public void syncNode(Document doc) {
        if (SVGNode == null){
            SVGNode = doc.createElement("circle");
            doc.getDocumentElement().appendChild(SVGNode);
            Attr a = doc.createAttribute("cx");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("cy");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("r");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("fill");
            ((Element)SVGNode).setAttributeNode(a);
        }

        NamedNodeMap nodeMap = SVGNode.getAttributes();
        nodeMap.getNamedItem("cx").setNodeValue(String.valueOf(center.getX()));
        nodeMap.getNamedItem("cy").setNodeValue(String.valueOf(center.getY()));
        nodeMap.getNamedItem("r").setNodeValue(String.valueOf(radius));
        nodeMap.getNamedItem("fill").setNodeValue(color);
    }

    @Override
    public String stringBuilder() {
        String str=SHAPE_NAME+" "+center.getX()+" "+center.getY()+" "+radius+" "+color;
        return str;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public boolean isWithin(Circle circle) {
        if ((Point.distance(circle.getCenter(),center)+radius)<=circle.getRadius()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isWithin(Rectangle rectangle) {
        if (center.isWithin(rectangle)&&
                //Top
                (radius< (center.getY()-rectangle.getTopLeft().getY())) &&
                //Right
                (radius< (center.getX()+(rectangle.getTopLeft().getX()+rectangle.getWidth()))) &&
                //Left
                (radius< (center.getX()-rectangle.getTopLeft().getX())) &&
                //Bottom
                (radius< (center.getY()+(rectangle.getTopLeft().getY()+ rectangle.getHeight()))))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
