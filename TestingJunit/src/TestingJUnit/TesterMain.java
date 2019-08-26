package TestingJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestSuite;

class TesterMain {
	public static TestSuite createTestSuite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(new TestCalculator("TestCompare"));
		testSuite.addTest(new TestCalculator("TestComparenegative"));
		return testSuite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestCalculator.class);
	}

}
