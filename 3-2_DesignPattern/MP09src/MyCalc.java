import java.util.Scanner;

public class MyCalc {
    Scanner scanner;
    String inputStr;
    int operand1;
    int operand2;
    char operator;
    State state;

    State startState;
    State firstOperandState;
    State secondOperandState;
    State operatorState;

    MyCalc(){
        scanner = new Scanner(System.in);
        startState = new StartState(this);
        firstOperandState = new FirstOperandState(this);
        secondOperandState = new SecondOperandState(this);
        operatorState = new OperatorState(this);
        state = startState;
    }

    String getInput(String s) {
        System.out.println(s);
        return scanner.next();
    }

    void printOutResult() {
        switch (operator) {
            case '+':
                System.out.printf("%d + %d = %d\n", operand1, operand2, operand1 + operand2);
                break;

            case '-':
                System.out.printf("%d - %d = %d\n", operand1, operand2, operand1 - operand2);
                break;

            case '*':
                System.out.printf("%d * %d = %d\n", operand1, operand2, operand1 * operand2);
                break;

            case '/':
                System.out.printf("%d / %d = %d\n", operand1, operand2, operand1 / operand2);
                break;
        }
    }

    boolean run() {
        inputStr = getInput("정수 또는 +,-,*,/,= 기호 중 한 개를 입력하세요");
        char ch = inputStr.charAt(inputStr.length()-1);
        if (ch == 'q' || ch == 'Q') { // q를 입력하면 프로그램 종료
            return false;
        }
        else if (ch >= '0' && ch <= '9') { // 정수가 입력되면
            state.processNumber(inputStr);
        }
        else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '=') { // 연산자 처리
            state.processOperator(ch);
        }
        return true;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getStartState() {
        return startState;
    }

    public State getFirstOperandState() {
        return firstOperandState;
    }

    public State getSecondOperandState() {
        return secondOperandState;
    }

    public State getOperatorState() {
        return operatorState;
    }
}
