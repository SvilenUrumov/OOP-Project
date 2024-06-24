package Shapes;

import org.w3c.dom.*;

public class Rectangle extends Shape implements Within{
    public static final String SHAPE_NAME = "rectangle";

    private Point topLeft;
    private float width;
    private float height;
    public Rectangle(Point topLeft, float width, float height, String color, Node SVGnode) {
        //Конструктра дефинира правоъгълник, който е успореден на координатната ос
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
        this.SVGNode = SVGnode;
        this.color = color;
    }
    @Override
    public String stringBuilder() {
        String str=SHAPE_NAME+" "+topLeft.getX()+" "+topLeft.getY()+" "+" "+width+" "+height+" "+color;
        return str;
    }

    @Override
    public void translate(float verticalShift, float horizontalShift) {
        topLeft.translate(verticalShift,horizontalShift);
    }

    @Override
    public void syncNode(Document doc) {
        if (SVGNode == null){
            SVGNode = doc.createElement("rect");
            doc.getDocumentElement().appendChild(SVGNode);
            Attr a = doc.createAttribute("x");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("y");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("width");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("height");
            ((Element)SVGNode).setAttributeNode(a);
            a = doc.createAttribute("fill");
            ((Element)SVGNode).setAttributeNode(a);
        }

        NamedNodeMap nodeMap = SVGNode.getAttributes();
        nodeMap.getNamedItem("x").setNodeValue(String.valueOf(topLeft.getX()));
        nodeMap.getNamedItem("y").setNodeValue(String.valueOf(topLeft.getY()));
        nodeMap.getNamedItem("width").setNodeValue(String.valueOf(width));
        nodeMap.getNamedItem("height").setNodeValue(String.valueOf(height));
        nodeMap.getNamedItem("fill").setNodeValue(color);
    }

    @Override
    public boolean isWithin(Circle circle) {
        if (topLeft.isWithin(circle)&&
         new Point(topLeft.getX()+width,topLeft.getY()).isWithin(circle)&&
         new Point(topLeft.getX()+width, topLeft.getY()+height).isWithin(circle)&&
         new Point(topLeft.getX(),topLeft.getY()+height).isWithin(circle)){
        return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isWithin(Rectangle rectangle) {
        if (topLeft.isWithin(rectangle)&&
                new Point(topLeft.getX()+width, topLeft.getY()+height).isWithin(rectangle))
        {
            return true;
        }
        else
        {
        return false;
        }
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
