package Shapes;

public class Point extends Shape implements Within{
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void translate(float verticalShift, float horizontalShift) {
        this.x += horizontalShift;
        this.y += verticalShift;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public static double distance(Point p1,Point p2){
        return Math.sqrt(Math.pow((p2.getX()-p1.getX()),2)+Math.pow((p2.getY()-p1.getY()),2));
    }
    private double areaTriangle(Point p1,Point p2,Point p3){
        double p1top2 = Point.distance(p1,p2);
        double p1top3 = Point.distance(p1,p3);
        double p2top3 = Point.distance(p2,p3);
        double p = (p1top2+p1top3+p2top3)/2;

        return Math.sqrt(p*(p-p1top2)*(p-p2top3)*(p-p1top3));
    }

    @Override
    public boolean isWithin(Circle circle) {
        if(distance(circle.getCenter(), this)< circle.getRadius()){
        return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isWithin(Rectangle rectangle) {
        //p1,p2,p3
        //p1,p3,p4
        double areaRectangle = areaTriangle(rectangle.getP1(),rectangle.getP2(),rectangle.getP3())+areaTriangle(rectangle.getP1(),rectangle.getP3(), rectangle.getP4());
        //p1,0,p4
        //p1,0,p2
        //p2,0,p3
        //p3,0,p4
        double atr1=areaTriangle(rectangle.getP1(),this, rectangle.getP2());
        double atr2=areaTriangle(rectangle.getP1(),this, rectangle.getP4());
        double atr3=areaTriangle(rectangle.getP2(),this, rectangle.getP3());
        double atr4=areaTriangle(rectangle.getP3(),this, rectangle.getP4());
        double totalArea = atr1+atr2+atr3+atr4;
        if (areaRectangle==totalArea){
            return true;
        }
        else{
        return false;
        }
    }
}
