package dw.study.lookie.w4_calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	public int plus(int value1, int value2) {
		return value1 + value2;
	}

	public int minus(int value1, int value2) {
		return value1 - value2;
	}
}
