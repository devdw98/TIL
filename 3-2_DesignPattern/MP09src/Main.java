public class Main {
    public static void main(String[] args) {
//        professor.CalcV1 calcv1 = new professor.CalcV1();
        MyCalc calc = new MyCalc();
        boolean run = true;
        while (run) {
//            run = calcv1.run();
            run = calc.run();
        }
    }
}
