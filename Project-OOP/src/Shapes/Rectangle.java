package Shapes;

import org.w3c.dom.Node;

public class Rectangle extends Shape implements Within{
    private Point p1,p2,p3,p4;

    public Rectangle(Point topLeft, float width, float height) {
        //Конструктра дефинира правоъгълник, който е успореден на координатната ос
        this.p1 = topLeft;
        this.p2 = new Point(topLeft.getX()+width,topLeft.getY());
        this.p3 = new Point(topLeft.getX()+width, topLeft.getY()+height);
        this.p4 = new Point(topLeft.getX(),topLeft.getY()+height);
        this.SVGNode = null;
    }

    public Rectangle(Point topLeft, float width, float height, Node SVGNode) {
        this.p1 = topLeft;
        this.p2 = new Point(topLeft.getX()+width,topLeft.getY());
        this.p3 = new Point(topLeft.getX()+width, topLeft.getY()+height);
        this.p4 = new Point(topLeft.getX(),topLeft.getY()+height);
        this.SVGNode = SVGNode;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP3() {
        return p3;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public Point getP4() {
        return p4;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }

    public Rectangle(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    @Override
    public void translate(float verticalShift, float horizontalShift) {
        p1.translate(verticalShift,horizontalShift);
    }

    @Override
    public boolean isWithin(Circle circle) {
        if(p1.isWithin(circle)&&p2.isWithin(circle)&&p3.isWithin(circle)&&p4.isWithin(circle)){
            return true;
        }
        else{
        return false;
        }
    }

    @Override
    public boolean isWithin(Rectangle rectangle) {
        if (p1.isWithin(rectangle)&&p2.isWithin(rectangle)&&p3.isWithin(rectangle)&&p4.isWithin(rectangle)){
            return true;
        }
        else{
        return false;
        }
    }
}
