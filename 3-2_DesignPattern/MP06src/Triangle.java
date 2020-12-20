import java.awt.*;

public class Triangle extends Shape {
    public Triangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        double a = distance(points[0], points[1]);
        double b = distance(points[1], points[2]);
        double c = distance(points[2], points[0]);

        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

    private double distance(Point p1, Point p2){
        int x = p1.x - p2.x;
        int y = p1.y - p2.y;
        return Math.sqrt(x*x + y*y);
    }
}
