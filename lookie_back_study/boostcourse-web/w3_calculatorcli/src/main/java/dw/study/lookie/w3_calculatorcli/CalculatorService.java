package dw.study.lookie.w3_calculatorcli;

public class CalculatorService {
	public int plus(int a, int b) {
		return a + b;
	}

	public int minus(int a, int b) {
		return a - b;
	}

	public int multiple(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) throws ArithmeticException {
		return a / b;
	}
}
