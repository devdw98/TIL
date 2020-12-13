import java.awt.*;

public abstract class Shape {
    protected Point[] points;
    String type;

    public Shape(String type, Point[] points) {
        this.points = points;
        this.type = type;
    }

    public abstract double calcArea();

    public String toString(){
        String result = type+"\n";
        for(int i = 0; i<points.length;i++){
            result += "P"+i+": "+points[i].toString()+"\n";
        }
        return result+ "area: "+calcArea()+"\n";
    }
}
