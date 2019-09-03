package TestingJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class TestCalculatorOther extends TestCase {
	public TestCalculatorOther() {
		super();
	}

	int x;
	int y;

	@Test
	public void testComparenegative() {
		x = 6;
		y = 5;
		Calculator calculatorObj = new Calculator(x, y);
		int result = calculatorObj.compare();
		result = -result;
		System.out.println(result);
		assertEquals(-1, result);

	}

}
