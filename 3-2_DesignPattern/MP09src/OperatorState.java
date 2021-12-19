public class OperatorState implements State{
    MyCalc calc;

    public OperatorState(MyCalc calc) {
        this.calc = calc;
    }

    @Override
    public void processNumber(String ch) {
        calc.operand2 = Integer.parseInt(""+ch.charAt(ch.length()-1));
        calc.setState(calc.getSecondOperandState());
    }

    @Override
    public void processOperator(char ch) {
        calc.operator = ch;
    }
}
