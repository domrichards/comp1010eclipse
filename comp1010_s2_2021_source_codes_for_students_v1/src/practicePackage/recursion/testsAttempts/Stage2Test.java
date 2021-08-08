package practicePackage.recursion.testsAttempts;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage.recursion.attempts.Stage2;

public class Stage2Test {
	protected Stage2 testObject;

	@BeforeEach
	public void run() {
		testObject = new Stage2();
	}

	@Test
	public void testCountDigits() {
		assertEquals(0, testObject.countDigits(0));
		assertEquals(1, testObject.countDigits(8));
		assertEquals(4, testObject.countDigits(1729));
		assertEquals(4, testObject.countDigits(-1729));
		assertEquals(5, testObject.countDigits(80264));
		assertEquals(5, testObject.countDigits(-80264));
	}

	@Test
	public void testSumEvenDigits() {
		assertEquals(2, testObject.sumEvenDigits(1729));
		assertEquals(2, testObject.sumEvenDigits(-1729));
		assertEquals(0, testObject.sumEvenDigits(1739));
		assertEquals(0, testObject.sumEvenDigits(-1739));
		assertEquals(20, testObject.sumEvenDigits(80264));
		assertEquals(20, testObject.sumEvenDigits(-80264));
	}

	@Test
	public void testSumDigitsOver() {
		assertEquals(16, testObject.sumDigitsOver(1729, 3));
		assertEquals(18, testObject.sumDigitsOver(-1729, 1));
		assertEquals(0, testObject.sumDigitsOver(1739, 9));
		assertEquals(20, testObject.sumDigitsOver(8264, 0));
		assertEquals(8, testObject.sumDigitsOver(-80264, 7));
	}

	@Test
	public void testCountDigit() {
		assertEquals(0, testObject.countDigit(0, 0));
		assertEquals(1, testObject.countDigit(8, 8));
		assertEquals(0, testObject.countDigit(8, 5));
		assertEquals(2, testObject.countDigit(1721, 1));
		assertEquals(2, testObject.countDigit(-1721, 1));
		assertEquals(3, testObject.countDigit(888, 8));
		assertEquals(3, testObject.countDigit(-888, 8));
	}
	
	@Test
	public void testFirstDigit() {
		assertEquals(0, testObject.firstDigit(0));
		assertEquals(8, testObject.firstDigit(8));
		assertEquals(8, testObject.firstDigit(-8));
		assertEquals(1, testObject.firstDigit(1729));
		assertEquals(1, testObject.firstDigit(-1729));
		assertEquals(5, testObject.firstDigit(5678));
		assertEquals(5, testObject.firstDigit(-5678));
	}

	@Test
	public void testProduct() {
		assertEquals(18, testObject.product(2, 9));
		assertEquals(1500, testObject.product(30, 50));
		assertEquals(200, testObject.product(2, 100));
		assertEquals(61, testObject.product(61, 1));
	}

	@Test
	public void testFibonacci() {
		assertEquals(0, testObject.fibonacci(0));
		assertEquals(1, testObject.fibonacci(1));
		assertEquals(5, testObject.fibonacci(5));
		assertEquals(8, testObject.fibonacci(6));
		assertEquals(21, testObject.fibonacci(8));
	}

	@Test
	public void testTribonacci() {
		assertEquals(0, testObject.tribonacci(0));
		assertEquals(0, testObject.tribonacci(1));
		assertEquals(1, testObject.tribonacci(2));
		assertEquals(1, testObject.tribonacci(3));
		assertEquals(2, testObject.tribonacci(4));
		assertEquals(4, testObject.tribonacci(5));
		assertEquals(7, testObject.tribonacci(6));
		assertEquals(13, testObject.tribonacci(7));
	}
	
	@Test
	public void testCombinations() {
		assertEquals(1, testObject.combinations(5, 0));
		assertEquals(1, testObject.combinations(2, 2));
		assertEquals(10, testObject.combinations(5, 3));
		assertEquals(120, testObject.combinations(10, 7));
	}		
	
	@Test
	public void testHighestDigit() {
		assertEquals(7, testObject.highestDigit(1732));
		assertEquals(7, testObject.highestDigit(-1732));
		assertEquals(8, testObject.highestDigit(888));
		assertEquals(0, testObject.highestDigit(0));
	}
	
	@Test
	public void testSmallestDigit() {
		assertEquals(1, testObject.smallestDigit(1732));
		assertEquals(1, testObject.smallestDigit(-1732));
		assertEquals(8, testObject.smallestDigit(888));
		assertEquals(0, testObject.smallestDigit(0));
	}
	
	@Test
	public void testSmallestEvenDigit() {
		assertEquals(2, testObject.smallestEvenDigit(1732));
		assertEquals(2, testObject.smallestEvenDigit(-1732));
		assertEquals(8, testObject.smallestEvenDigit(888));
		assertEquals(0, testObject.smallestEvenDigit(0));
	}
	
	@Test
	public void testHighestEvenDigit() {
		assertEquals(8, testObject.highestEvenDigit(17382));
		assertEquals(6, testObject.highestEvenDigit(-61732));
		assertEquals(8, testObject.highestEvenDigit(888));
		assertEquals(0, testObject.highestEvenDigit(0));
	}
	
	@Test
	public void testHighestEvenDigitLocation() {
		assertEquals(2, testObject.highestEvenDigitLocation(17382));
		assertEquals(5, testObject.highestEvenDigitLocation(-61732));
		assertEquals(1, testObject.highestEvenDigitLocation(888));
		assertEquals(0, testObject.highestEvenDigitLocation(0));
		assertEquals(3, testObject.highestEvenDigitLocation(-864));
	}
	
	@Test
	public void testHighestDigitLocation() {
		assertEquals(2, testObject.highestDigitLocation(17382));
		assertEquals(3, testObject.highestDigitLocation(-61732));
		assertEquals(1, testObject.highestDigitLocation(888));
		assertEquals(0, testObject.highestDigitLocation(0));
		assertEquals(3, testObject.highestDigitLocation(-864));
	}
	
	@Test
	public void testSmallestDigitLocation() {
		assertEquals(5, testObject.smallestDigitLocation(17382));
		assertEquals(4, testObject.smallestDigitLocation(-61732));
		assertEquals(1, testObject.smallestDigitLocation(888));
		assertEquals(0, testObject.smallestDigitLocation(0));
		assertEquals(1, testObject.smallestDigitLocation(-864));
	}
}
