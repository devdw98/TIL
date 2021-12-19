import java.awt.*;

public class Trapezoid extends Shape {
    public Trapezoid(String type, Point[] points) {
        super(type, points);
    }

    @Override
    public double calcArea() {
        int upWidth, downWidth, height;
        Point[] points1 = new Point[2];
        Point[] points2 = new Point[2];

        points1[0] = points[0];

        for(int i = 1,j = 0; i < points.length; i++){
            if(points1[0].y == points[i].y){
                points1[1] = points[i];
            }else{
                points2[j] = points[i];
                j++;
            }
        }
        upWidth = points1[0].x - points1[1].x;
        downWidth = points2[0].x - points2[1].x;
        height = points1[0].y - points2[0].y;

        if(upWidth < 0)
            upWidth *= -1;
        if(downWidth < 0)
            downWidth *= -1;
        if(height < 0)
            height *= -1;

        return (upWidth + downWidth) * height / 2;
    }
}
