import java.awt.*;

public class RightTriangle extends Shape {
    public RightTriangle(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        int width , height;
//        width = points[1].x - points[0].x;
//        height = points[1].y - points[0].y;
//        return width * height / 2;

        if(points[0].x == points[1].x){
            height = points[0].y - points[1].y;
            width = points[0].x - points[2].x;
        }else {
            height = points[0].y - points[2].y;
            width = points[0].x - points[1].x;
        }

        if(width < 0)
            width *= -1;
        if(height < 0)
            height *= -1;

        return width * height / 2;
    }
}
