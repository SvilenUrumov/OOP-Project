package Shapes;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class Polygon extends Shape implements Within{
    public static final String SHAPE_NAME = "polygon";
    private ArrayList<Point> points;

    public Polygon(ArrayList<Point> points,String color, Node SVGNode) {
        this.points = points;
        this.SVGNode = SVGNode;
        this.color = color;
    }
    @Override
    public String stringBuilder() {
        String str=SHAPE_NAME;
        return str;
    }

    @Override
    public void translate(float verticalShift, float horizontalShift) {
        for (int i=0;i<points.size();i++){
            points.get(i).translate(verticalShift,horizontalShift);
        }

    }

    @Override
    public boolean isWithin(Circle circle) {
        for (int i=0;i<points.size();i++){
            if(!points.get(i).isWithin(circle)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isWithin(Rectangle rectangle) {
        for (int i=0;i<points.size();i++){
            if(!points.get(i).isWithin(rectangle)){
                return false;
            }
        }
        return true;
    }
}
