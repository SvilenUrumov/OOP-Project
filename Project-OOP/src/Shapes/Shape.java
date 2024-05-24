package Shapes;

import org.w3c.dom.Node;

public abstract class Shape implements Within{
    protected Node SVGNode;
    protected String color;
    public abstract void translate(float verticalShift,float horizontalShift);
    public abstract String stringBuilder();

}
