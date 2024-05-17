package Shapes;

import org.w3c.dom.Node;

public abstract class Shape {
    protected Node SVGNode;
    public abstract void translate(float verticalShift,float horizontalShift);

}
