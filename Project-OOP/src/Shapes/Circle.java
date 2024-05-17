package Shapes;

import org.w3c.dom.Node;

public class Circle extends Shape implements Within{
    private Point center;
    private float radius;

    public Circle(Point center, float radius) {
        this.center = center;
        this.radius = radius;
        this.SVGNode = null;
    }

    public Circle(Point center, float radius, Node SVGNode) {
        this.center = center;
        this.radius = radius;
        this.SVGNode = SVGNode;
    }

    @Override
    public void translate(float verticalShift, float horizontalShift) {
        center.translate(verticalShift,horizontalShift);
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
        Line zeroLine = new Line(line.getStart(),line.getEnd());
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
        int i1 = intersections(new Line(rectangle.getP1(),rectangle.getP2()));
        int i2 = intersections(new Line(rectangle.getP2(),rectangle.getP3()));
        int i3 = intersections(new Line(rectangle.getP3(),rectangle.getP4()));
        int i4 = intersections(new Line(rectangle.getP4(),rectangle.getP1()));
        if (center.isWithin(rectangle)&&i1<2&&i2<2&&i3<2&&i4<2){
            return true;
        }
        else{
            return false;
        }
    }
}
