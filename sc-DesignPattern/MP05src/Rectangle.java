import java.awt.*;

public class Rectangle extends Shape {
    public Rectangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        int width , height;

        width = points[1].x - points[0].x;
        height = points[1].y - points[0].y;

        if(width < 0 )
            width *= -1;
        if(height < 0)
            height *= -1;

        return width * height;
    }

}
