package Shapes;

import org.w3c.dom.Node;

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

    private int intersections(Line line){
        Line zeroLine = new Line(line.getStart(),line.getEnd(),null,null);
        zeroLine.translate(-center.getX(), -center.getY());
        double dx = zeroLine.getEnd().getX()-zeroLine.getStart().getX();
        double dy = zeroLine.getEnd().getY()-zeroLine.getStart().getY();
        double dr = Math.sqrt(Math.pow(dx,2)+Math.pow(dy,2));
        double D = zeroLine.getStart().getX()*zeroLine.getEnd().getY()-zeroLine.getEnd().getX()*zeroLine.getStart().getY();
        double delta = Math.pow(radius,2)*Math.pow(dr,2)-Math.pow(D,2);
        if (delta>0){
            return 2;
        }else if (delta == 0){
            return 1;
        }
        else{
            return 0;
        }
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
                radius< (center.getY()-rectangle.getTopLeft().getY()) &&
                //Right
                radius< (center.getX()-(rectangle.getTopLeft().getX()+rectangle.getWidth())) &&
                //Left
                radius< (center.getX()-rectangle.getTopLeft().getX()) &&
                //Bottom
                radius< (center.getY()-(rectangle.getTopLeft().getY()+ rectangle.getHeight())))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
