import java.awt.*;

public class RectangularShapeFactory implements ShapeFactory{

    //MP06_Singleton Pattern 적용
    private volatile static RectangularShapeFactory inst;
    private RectangularShapeFactory(){};
    public static RectangularShapeFactory getInstance(){
        if(inst == null){
            synchronized (RectangularShapeFactory.class){
                if(inst == null){
                    inst = new RectangularShapeFactory();
                }
            }
        }
        return inst;
    }

    @Override
    public Shape create(String type, Point[] points) {
        Shape shape = null;
        if(type.equals("Rectangle")){
            shape = new Rectangle(type, points);
        }else if(type.equals("Trapezoid")){
            shape = new Trapezoid(type, points);
        }else if(type.equals("Parallelogram")){
            shape = new Parallelogram(type, points);
        }

        return shape;
    }
}
