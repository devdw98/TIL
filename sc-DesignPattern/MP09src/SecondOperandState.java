public class SecondOperandState implements State{
    MyCalc calc;

    public SecondOperandState(MyCalc calc) {
        this.calc = calc;
    }

    @Override
    public void processNumber(String ch) {
        calc.operand2 = Integer.parseInt(""+ch.charAt(ch.length()-1));
    }

    @Override
    public void processOperator(char ch) {
        if(ch == '='){
            calc.printOutResult();
            calc.setState(calc.getStartState());
        }
    }
}
