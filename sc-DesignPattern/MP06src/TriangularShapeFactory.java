import java.awt.*;

public class TriangularShapeFactory implements ShapeFactory{

    //MP06_Singleton Pattern 적용
    private volatile static TriangularShapeFactory inst;
    private TriangularShapeFactory(){};
    public static TriangularShapeFactory getInstance(){
        if(inst == null){
            synchronized (TriangularShapeFactory.class){
                if(inst == null){
                    inst = new TriangularShapeFactory();
                }
            }
        }
        return inst;
    }

    @Override
    public Shape create(String type, Point[] points) {

        Shape shape = null;
        if(type.equals("Triangle")){
            shape = new Triangle(type, points);
        }else if(type.equals("RightTriangle")){
            shape = new RightTriangle(type, points);
        }

        return shape;
    }
}
