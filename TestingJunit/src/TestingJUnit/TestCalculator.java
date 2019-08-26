package TestingJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestCalculator extends TestCase {
	int x;
	int y;

	public TestCalculator(String string) {
		super(string);
	}

	@Test
	public void testCompare() {
		x = 6;
		y = 5;
		Calculator calculatorObj = new Calculator(x, y);
		int result = calculatorObj.compare();
		System.out.println(result);
		assertEquals(1, result);

	}

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
