public class FirstOperandState implements State{
    MyCalc calc;

    public FirstOperandState(MyCalc calc) {
        this.calc = calc;
    }

    @Override
    public void processNumber(String ch) {
        calc.operand1 = Integer.parseInt(""+ch.charAt(ch.length()-1));
    }

    @Override
    public void processOperator(char ch) {
        calc.setState(calc.getOperatorState());
        calc.operator = ch;
    }
}
