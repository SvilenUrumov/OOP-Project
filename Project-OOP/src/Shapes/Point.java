package Shapes;

import org.w3c.dom.Document;

public class Point extends Shape implements Within{
    public static final String SHAPE_NAME = "point";
    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String stringBuilder() {
        String str=SHAPE_NAME+" "+x+" "+y;
        return str;
    }

    @Override
    public void translate(float verticalShift, float horizontalShift) {
        this.x += horizontalShift;
        this.y += verticalShift;
    }

    @Override
    public void syncNode(Document doc) {

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
        if (x>rectangle.getTopLeft().getX() && y>rectangle.getTopLeft().getY()
                && x<(rectangle.getTopLeft().getX()+rectangle.getWidth())
                && y<(rectangle.getTopLeft().getY()+rectangle.getHeight())){
            return true;
        }
        else{
        return false;
    }
    }
}
