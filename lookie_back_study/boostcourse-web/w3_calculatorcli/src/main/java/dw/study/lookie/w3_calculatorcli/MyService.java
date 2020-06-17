package dw.study.lookie.w3_calculatorcli;

public class MyService {
	private final CalculatorService cs;
	
	public MyService(CalculatorService cs) {
		this.cs = cs;
	}
	
	public int execute(int a, int b) {
//		return cs.plus(a, b) * 2;
		return 2;
	}

}
