package Shapes;

import org.w3c.dom.Node;

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
