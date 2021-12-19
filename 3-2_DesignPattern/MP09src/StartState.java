public class StartState implements State{
    MyCalc calc;

    public StartState(MyCalc calc) {
        this.calc = calc;
    }

    @Override
    public void processNumber(String ch) {
        calc.operand1 = Integer.parseInt("" + ch.charAt(ch.length()-1));
        calc.setState(calc.getFirstOperandState());
    }

    @Override
    public void processOperator(char ch) {

    }
}
