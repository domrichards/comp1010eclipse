package practicePackage.builtInLists.testsAttempts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ServiceClasses.Rectangle;
import practicePackage.builtInLists.attempts.*;

@SuppressWarnings("unused")
public class Stage2Test {
	protected practicePackage.builtInLists.attempts.Stage2 testObject;
	
	public ArrayList<Integer> nullList, emptyList, singleItemList, tenMultiples, negPos, ascAllPos, descNegs,list1, list2;
	public ArrayList<Rectangle> rList;

	@BeforeEach
	public void run() {
		testObject = new practicePackage.builtInLists.attempts.Stage2();
		nullList = null;
		emptyList = new ArrayList<Integer>();
		singleItemList = new ArrayList<Integer>(Arrays.asList(-7));
		tenMultiples = new ArrayList<Integer>(Arrays.asList(10,-70,-20,90));
		negPos = new ArrayList<Integer>(Arrays.asList(-3, 15, -13, 16, -1, 10, -101));
		ascAllPos = new ArrayList<Integer>(Arrays.asList(4, 7, 13, 28, 137, 224, 237, 254));
		descNegs = new ArrayList<Integer>(Arrays.asList(-115, -125, -202, -225, -229, -255));

		list1 = new ArrayList<Integer>(Arrays.asList(10,70,20,90));
		list2 = new ArrayList<Integer>(Arrays.asList(-5, 0, 8, -7, 9, 15, 23, -1, 5));
		rList = new ArrayList<Rectangle>();
		rList.add(new Rectangle(5));
		rList.add(new Rectangle(10));
		rList.add(new Rectangle(2, 6));
		rList.add(new Rectangle(20));
		rList.add(new Rectangle(1, 5));
		rList.add(new Rectangle(8));			
	}

	@Test
	void testCount() {
		assertEquals(0, testObject.count(nullList,0));
		assertEquals(0, testObject.count(emptyList,0));
		assertEquals(0, testObject.count(singleItemList,0));
		assertEquals(1, testObject.count(singleItemList,-7));
		assertEquals(1, testObject.count(list1,10));
		assertEquals(1, testObject.count(list2,5));
		list2.add(5);
		list2.add(5);
		list2.add(5);
		assertEquals(4, testObject.count(list2,5));
	}

	@Test
	void testContainsInRange() {
		assertFalse(testObject.containsInRange(nullList,0,5));
		assertFalse(testObject.containsInRange(emptyList,0,5));
		assertFalse(testObject.containsInRange(singleItemList,-6,0));
		assertTrue(testObject.containsInRange(singleItemList,-7,0));
		assertFalse(testObject.containsInRange(singleItemList,-10,-8));
		assertTrue(testObject.containsInRange(singleItemList,-10,-7));
		assertTrue(testObject.containsInRange(list1,0,10));
		assertTrue(testObject.containsInRange(list1,20,100));
		assertFalse(testObject.containsInRange(list1,0,9));
		assertFalse(testObject.containsInRange(list2,4,4));

	}

	@Test
	void testAllInRange() {
		assertFalse(testObject.allInRange(nullList,0,5));
		assertTrue(testObject.allInRange(emptyList,0,5));
		assertFalse(testObject.allInRange(singleItemList,-6,0));
		assertTrue(testObject.allInRange(singleItemList,-7,0));
		assertFalse(testObject.allInRange(singleItemList,-10,-8));
		assertTrue(testObject.allInRange(singleItemList,-10,-7));
		assertFalse(testObject.allInRange(list1,0,10));
		assertFalse(testObject.allInRange(list1,20,100));
		assertTrue(testObject.allInRange(list1,10,90));
		assertFalse(testObject.allInRange(list1,0,9));
		assertFalse(testObject.allInRange(list2,-6,23));
		assertFalse(testObject.allInRange(list2,-7,22));
		assertTrue(testObject.allInRange(list2,-7,23));
	}

	@Test
	void testCountPrimes() {
		assertEquals(0, testObject.countPrimes(nullList));
		assertEquals(0, testObject.countPrimes(emptyList));
		assertEquals(0, testObject.countPrimes(singleItemList));
		assertEquals(0, testObject.countPrimes(list1));
		assertEquals(2, testObject.countPrimes(list2));	//23 and 5
	}

	@Test
	void testContainsPrime() {
		assertFalse(testObject.containsPrime(nullList));
		assertFalse(testObject.containsPrime(emptyList));
		assertFalse(testObject.containsPrime(singleItemList));

		singleItemList.add(0,13);
		assertTrue(testObject.containsPrime(singleItemList));

		assertFalse(testObject.containsPrime(list1));

		list1.add(7);
		assertTrue(testObject.containsPrime(list1));

		assertTrue(testObject.containsPrime(list2));
	}

	@Test
	void testAllPrimes() {
		assertFalse(testObject.allPrimes(nullList));
		assertTrue(testObject.allPrimes(emptyList));
		assertFalse(testObject.allPrimes(singleItemList));		
		singleItemList = new ArrayList<Integer>(Arrays.asList(13));
		assertTrue(testObject.allPrimes(singleItemList));		

		assertFalse(testObject.allPrimes(list1));

		list1 = new ArrayList<Integer>(Arrays.asList(13,29,97,2,5,3));
		assertTrue(testObject.allPrimes(list1));		

		assertFalse(testObject.allPrimes(list2));	
	}

	@Test
	void testCountSquares() {
		assertEquals(4, testObject.countSquares(rList));
		rList.remove(0);
		assertEquals(3, testObject.countSquares(rList));
		rList.remove(0);
		assertEquals(2, testObject.countSquares(rList));
		rList.remove(rList.size()-1);
		assertEquals(1, testObject.countSquares(rList));
	}

	@Test
	void testSum() {
		assertEquals(0, testObject.sum(null));
		assertEquals(0, testObject.sum(emptyList));
		assertEquals(-7, testObject.sum(singleItemList));
		assertEquals(10, testObject.sum(tenMultiples));
		assertEquals((-77), testObject.sum(negPos));
		assertEquals(904, testObject.sum(ascAllPos));
		assertEquals((-1151), testObject.sum(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sum(e));
	}

	@Test
	void testSumEven() {
		assertEquals(0, testObject.sumEven(null));
		assertEquals(0, testObject.sumEven(emptyList));
		assertEquals(0, testObject.sumEven(singleItemList));
		assertEquals(10, testObject.sumEven(tenMultiples));
		assertEquals(26, testObject.sumEven(negPos));
		assertEquals(510, testObject.sumEven(ascAllPos));
		assertEquals((-202), testObject.sumEven(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumEven(e));
	}

	@Test
	void testSumOdd() {
		assertEquals(0, testObject.sumOdd(null));
		assertEquals(0, testObject.sumOdd(emptyList));
		assertEquals(-7, testObject.sumOdd(singleItemList));
		assertEquals(0, testObject.sumOdd(tenMultiples));
		assertEquals((-103), testObject.sumOdd(negPos));
		assertEquals(394, testObject.sumOdd(ascAllPos));
		assertEquals((-949), testObject.sumOdd(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumOdd(e));
	}

	@Test
	void testSumPositives() {
		assertEquals(0, testObject.sumPositives(null));
		assertEquals(0, testObject.sumPositives(emptyList));
		assertEquals(0, testObject.sumPositives(singleItemList));
		assertEquals(100, testObject.sumPositives(tenMultiples));
		assertEquals(41, testObject.sumPositives(negPos));
		assertEquals(904, testObject.sumPositives(ascAllPos));
		assertEquals(0, testObject.sumPositives(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 10));
		assertEquals(10, testObject.sumPositives(e));
	}

	@Test
	void testSumNegatives() {
		assertEquals(0, testObject.sumNegatives(null));
		assertEquals(0, testObject.sumNegatives(emptyList));
		assertEquals(-7, testObject.sumNegatives(singleItemList));
		assertEquals((-90), testObject.sumNegatives(tenMultiples));
		assertEquals((-118), testObject.sumNegatives(negPos));
		assertEquals(0, testObject.sumNegatives(ascAllPos));
		assertEquals((-1151), testObject.sumNegatives(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, -10));
		assertEquals((-10), testObject.sumNegatives(e));
	}

	@Test
	void testSumEvenIndexedItems() {
		assertEquals(0, testObject.sumEvenIndexedItems(null));
		assertEquals(0, testObject.sumEvenIndexedItems(emptyList));
		assertEquals(-7, testObject.sumEvenIndexedItems(singleItemList));
		assertEquals(-10, testObject.sumEvenIndexedItems(tenMultiples));
		assertEquals(-118, testObject.sumEvenIndexedItems(negPos));
		assertEquals(391, testObject.sumEvenIndexedItems(ascAllPos));
		assertEquals(-546, testObject.sumEvenIndexedItems(descNegs));
	}

	@Test
	void testSumOddIndexedItems() {
		assertEquals(0, testObject.sumOddIndexedItems(null));
		assertEquals(0, testObject.sumOddIndexedItems(emptyList));
		assertEquals(0, testObject.sumOddIndexedItems(singleItemList));
		assertEquals(20, testObject.sumOddIndexedItems(tenMultiples));
		assertEquals(41, testObject.sumOddIndexedItems(negPos));
		assertEquals(513, testObject.sumOddIndexedItems(ascAllPos));
		assertEquals(-605, testObject.sumOddIndexedItems(descNegs));
	}

	@Test
	void testSumMultiples() {
		assertEquals(0, testObject.sumMultiples(null, 69));
		assertEquals(0, testObject.sumMultiples(emptyList, 96));
		assertEquals(-7, testObject.sumMultiples(singleItemList, -7));
		assertEquals(10, testObject.sumMultiples(tenMultiples, 10));
		assertEquals(0, testObject.sumMultiples(negPos, 7));
		assertEquals(256, testObject.sumMultiples(ascAllPos, 4));
		assertEquals(-720, testObject.sumMultiples(descNegs, 5));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumMultiples(e, 235));
	}

	@Test
	void testSumFactors() {
		assertEquals(0, testObject.sumFactors(null, 69));
		assertEquals(0, testObject.sumFactors(emptyList, 96));
		assertEquals(-7, testObject.sumFactors(singleItemList, -7));
		assertEquals(-7, testObject.sumFactors(singleItemList, 7));
		assertEquals(10, testObject.sumFactors(tenMultiples, 1260));
		assertEquals(9, testObject.sumFactors(negPos, -100));
		assertEquals(263, testObject.sumFactors(ascAllPos, 224));
		assertEquals(0, testObject.sumFactors(descNegs, -235));
	}

	@Test
	void testSumInRange() {
		assertEquals(0, testObject.sumInRange(null, 69, 96));
		assertEquals(0, testObject.sumInRange(emptyList, 23, 35));
		assertEquals(0, testObject.sumInRange(singleItemList, 777, 777));
		assertEquals(-7, testObject.sumInRange(singleItemList, -7, -7));
		assertEquals(10, testObject.sumInRange(tenMultiples, -70, 90)); //all items satisfy
		assertEquals((-90), testObject.sumInRange(tenMultiples, -80, -10));
		assertEquals(100, testObject.sumInRange(tenMultiples, 0, 100));
		assertEquals(10, testObject.sumInRange(negPos, 10, 14)); //only 1 item satisfies (= low)
		assertEquals(4, testObject.sumInRange(ascAllPos, -115, 4)); //only 1 item satisfies (= high)
		assertEquals(0, testObject.sumInRange(descNegs, 0, 125)); //no items satisfy
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumInRange(e, 0, 0));
	}

	@Test
	void testSumNotInRange() {
		assertEquals(0, testObject.sumNotInRange(null, 69, 96));
		assertEquals(0, testObject.sumNotInRange(emptyList, 23, 35));
		assertEquals(-7, testObject.sumNotInRange(singleItemList, 777, 777));
		assertEquals(10, testObject.sumNotInRange(tenMultiples, 100, 169)); //all items satisfy
		assertEquals(100, testObject.sumNotInRange(tenMultiples, -80, -10));
		assertEquals((-90), testObject.sumNotInRange(tenMultiples, 0, 100));
		assertEquals((-87), testObject.sumNotInRange(negPos, 10, 14)); //only 1 item dissatisfies (= low)
		assertEquals(900, testObject.sumNotInRange(ascAllPos, -115, 4)); //only 1 item dissatisfies (= high)
		assertEquals(0, testObject.sumNotInRange(descNegs, -269, 0)); //no items satisfy
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumNotInRange(e, 0, 0));
	}

	@Test
	void testResetNegatives() {
		testObject.resetNegatives(null); //NullPointerException check

		testObject.resetNegatives(emptyList);
		assertEquals(0, emptyList.size());

		testObject.resetNegatives(singleItemList);
		assertEquals((Integer)0, singleItemList.get(0));

		testObject.resetNegatives(tenMultiples);
		assertEquals(4, tenMultiples.size());
		assertEquals((Integer)10, tenMultiples.get(0));
		assertEquals((Integer)0, tenMultiples.get(1));
		assertEquals((Integer)0, tenMultiples.get(2));
		assertEquals((Integer)90, tenMultiples.get(3));

		String before1 = ascAllPos.toString();
		testObject.resetNegatives(ascAllPos);
		String after1 = ascAllPos.toString();
		assertEquals(before1, after1);

		testObject.resetNegatives(descNegs);
		assertEquals("[0, 0, 0, 0, 0, 0]", descNegs.toString());

		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		String before2 = e.toString();
		testObject.resetNegatives(e);
		String after2 = e.toString();
		assertEquals(before2, after2);
	}

	@Test
	void testMakeAbsolute() {
		testObject.makeAbsolute(null); //NullPointerException check

		testObject.makeAbsolute(emptyList);
		assertEquals(0, emptyList.size());

		testObject.makeAbsolute(singleItemList);
		assertEquals((Integer)7, singleItemList.get(0));

		testObject.makeAbsolute(negPos);
		assertEquals((Integer)3, negPos.get(0));
		assertEquals((Integer)15, negPos.get(1));
		assertEquals((Integer)10, negPos.get(5));
		assertEquals((Integer)101, negPos.get(6));

		String before1 = ascAllPos.toString();
		testObject.makeAbsolute(ascAllPos);
		String after1 = ascAllPos.toString();
		assertEquals(before1, after1);

		ArrayList<Integer> e = new ArrayList<Integer>();
		for (int i = 0; i < descNegs.size(); i++) {
			e.add(-descNegs.get(i));
		}
		testObject.makeAbsolute(descNegs);
		assertEquals(descNegs.toString(), e.toString());

		ArrayList<Integer> f = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		String before2 = f.toString();
		testObject.makeAbsolute(f);
		String after2 = f.toString();
		assertEquals(before2, after2);
	}

	@Test
	void testSquareUp() {
		testObject.squareUp(null); //NullPointerException check

		testObject.squareUp(emptyList);
		assertEquals(0, emptyList.size());

		testObject.squareUp(singleItemList);
		assertEquals((Integer)(7 * 7), singleItemList.get(0));

		testObject.squareUp(tenMultiples);
		assertEquals("[100, 4900, 400, 8100]", tenMultiples.toString());

		testObject.squareUp(negPos);
		for (int item: negPos) {
			assertTrue(ServiceClasses.MathService.isSquare(item));
		}

		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		String before = e.toString();
		testObject.squareUp(e);
		String after = e.toString();
		assertEquals(before, after);
	}

	@Test
	void testCountEven() {
		assertEquals(0, testObject.countEven(null));
		assertEquals(0, testObject.countEven(emptyList));
		assertEquals(0, testObject.countEven(singleItemList));
		assertEquals(4, testObject.countEven(tenMultiples));
		assertEquals(2, testObject.countEven(negPos));
		assertEquals(4, testObject.countEven(ascAllPos));
		assertEquals(1, testObject.countEven(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
		assertEquals(5, testObject.countEven(e));
	}

	@Test
	void testCountOdd() {
		assertEquals(0, testObject.countOdd(null));
		assertEquals(0, testObject.countOdd(emptyList));
		assertEquals(1, testObject.countOdd(singleItemList));
		assertEquals(0, testObject.countOdd(tenMultiples));
		assertEquals(5, testObject.countOdd(negPos));
		assertEquals(4, testObject.countOdd(ascAllPos));
		assertEquals(5, testObject.countOdd(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
		assertEquals(0, testObject.countOdd(e));
	}

	@Test
	void testCountPositives() {
		assertEquals(0, testObject.countPositives(null));
		assertEquals(0, testObject.countPositives(emptyList));
		assertEquals(0, testObject.countPositives(singleItemList));
		assertEquals(2, testObject.countPositives(tenMultiples));
		assertEquals(3, testObject.countPositives(negPos));
		assertEquals(8, testObject.countPositives(ascAllPos));
		assertEquals(0, testObject.countPositives(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0,0,0,0,10));
		assertEquals(1, testObject.countPositives(e));
	}

	@Test
	void testCountNegatives() {
		assertEquals(0, testObject.countNegatives(null));
		assertEquals(0, testObject.countNegatives(emptyList));
		assertEquals(1, testObject.countNegatives(singleItemList));
		assertEquals(2, testObject.countNegatives(tenMultiples));
		assertEquals(4, testObject.countNegatives(negPos));
		assertEquals(0, testObject.countNegatives(ascAllPos));
		assertEquals(6, testObject.countNegatives(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0,0,0,0,-10));
		assertEquals(1, testObject.countNegatives(e));
	}

	@Test
	void testCountMultiples() {
		assertEquals(0, testObject.countMultiples(null, 69));
		assertEquals(0, testObject.countMultiples(emptyList, 96));
		assertEquals(1, testObject.countMultiples(singleItemList, -7));
		assertEquals(4, testObject.countMultiples(tenMultiples, 10));
		assertEquals(0, testObject.countMultiples(negPos, 7));
		assertEquals(3, testObject.countMultiples(ascAllPos, 4));
		assertEquals(4, testObject.countMultiples(descNegs, 5));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(5, testObject.countMultiples(e, 235));
	}

	@Test
	void testCountFactors() {
		assertEquals(0, testObject.countFactors(null, 69));
		assertEquals(0, testObject.countFactors(emptyList, 96));
		assertEquals(1, testObject.countFactors(singleItemList, 777));
		assertEquals(4, testObject.countFactors(tenMultiples, 1260));
		assertEquals(2, testObject.countFactors(negPos, -100));
		assertEquals(4, testObject.countFactors(ascAllPos, 224));
		assertEquals(0, testObject.countFactors(descNegs, -235));
	}

	@Test
	void testCountInRange() {
		assertEquals(0, testObject.countInRange(null, 69, 96));
		assertEquals(0, testObject.countInRange(emptyList, 23, 35));
		assertEquals(1, testObject.countInRange(singleItemList, -7, -7));
		assertEquals(4, testObject.countInRange(tenMultiples, -70, 90)); //all items satisfy
		assertEquals(2, testObject.countInRange(tenMultiples, -80, -10));
		assertEquals(2, testObject.countInRange(tenMultiples, 0, 100));
		assertEquals(1, testObject.countInRange(negPos, 10, 14)); //only 1 item satisfies (= low)
		assertEquals(1, testObject.countInRange(ascAllPos, -115, 4)); //only 1 item satisfies (= high)
		assertEquals(0, testObject.countInRange(descNegs, 0, 125)); //no items satisfy
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(5, testObject.countInRange(e, 0, 0));
	}

	@Test
	void testCountNotInRange() {
		assertEquals(0, testObject.countNotInRange(null, 69, 96));
		assertEquals(0, testObject.countNotInRange(emptyList, 23, 35));
		assertEquals(1, testObject.countNotInRange(singleItemList, 777, 777));
		assertEquals(4, testObject.countNotInRange(tenMultiples, 100, 169)); //all items satisfy
		assertEquals(2, testObject.countNotInRange(tenMultiples, -80, -10));
		assertEquals(2, testObject.countNotInRange(tenMultiples, 0, 100));
		assertEquals(6, testObject.countNotInRange(negPos, 10, 14)); //only 1 item dissatisfies (= low)
		assertEquals(7, testObject.countNotInRange(ascAllPos, -115, 4)); //only 1 item dissatisfies (= high)
		assertEquals(0, testObject.countNotInRange(descNegs, -269, 0)); //no items satisfy
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.countNotInRange(e, 0, 0));
	}

	@Test
	void testCountOccurrences() {
		assertEquals(0, testObject.countOccurrences(null, 69));
		assertEquals(0, testObject.countOccurrences(emptyList, 96));
		assertEquals(1, testObject.countOccurrences(singleItemList, -7));
		assertEquals(0, testObject.countOccurrences(tenMultiples, 0));
		assertEquals(1, testObject.countOccurrences(ascAllPos, 13));
		assertEquals(7, testObject.countOccurrences(new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7)), 7));
	}

	@Test
	void testCountUnique() {
		assertEquals(0, testObject.countUnique(null));
		assertEquals(0, testObject.countUnique(emptyList));
		assertEquals(1, testObject.countUnique(singleItemList));
		assertEquals(6, testObject.countUnique(descNegs));
		assertEquals(3, testObject.countUnique(new ArrayList<Integer>(Arrays.asList(0, 2, 0, 3, 1, 5, 1))));
		assertEquals(0, testObject.countUnique(new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7))));
	}

	@Test
	void testContains() {
		assertFalse(testObject.contains(null, 69));
		assertFalse(testObject.contains(emptyList, 96));
		assertFalse(testObject.contains(singleItemList, 777));
		assertTrue(testObject.contains(singleItemList, -7));
		assertFalse(testObject.contains(descNegs, 0));
		assertTrue(testObject.contains(negPos, -13));
		assertTrue(testObject.contains(new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7)), 7));
	}

	@Test
	void testIndexOf() {
		assertEquals(-1, testObject.indexOf(null, 69));
		assertEquals(-1, testObject.indexOf(emptyList, 96));
		assertEquals(0, testObject.indexOf(singleItemList, -7));
		assertEquals(0, testObject.indexOf(tenMultiples, 10));
		assertEquals(3, testObject.indexOf(negPos, 16));
		assertEquals(7, testObject.indexOf(ascAllPos, 254));
		assertEquals(-1, testObject.indexOf(descNegs, 0));
		assertEquals(0, testObject.indexOf(new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7)), 7));
	}

	@Test
	void testLastIndexOf() {
		assertEquals(-1, testObject.lastIndexOf(null, 69));
		assertEquals(-1, testObject.lastIndexOf(emptyList, 96));
		assertEquals(0, testObject.lastIndexOf(singleItemList, -7));
		assertEquals(0, testObject.lastIndexOf(tenMultiples, 10));
		assertEquals(3, testObject.lastIndexOf(negPos, 16));
		assertEquals(7, testObject.lastIndexOf(ascAllPos, 254));
		assertEquals(-1, testObject.lastIndexOf(descNegs, 0));
		assertEquals(6, testObject.lastIndexOf(new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7)), 7));
	}

	@Test
	void testContainsFromIndex() {
		assertFalse(testObject.containsFromIndex(null, 35, 23));
		assertFalse(testObject.containsFromIndex(emptyList, 96, 69));
		assertFalse(testObject.containsFromIndex(singleItemList, 777, 0));
		assertFalse(testObject.containsFromIndex(tenMultiples, 90, 4));
		assertFalse(testObject.containsFromIndex(negPos, -13, -1));
		assertTrue(testObject.containsFromIndex(ascAllPos, 254, 6));
		assertFalse(testObject.containsFromIndex(descNegs, -115, 1));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7));
		assertTrue(testObject.containsFromIndex(e, 7, 0));
		assertTrue(testObject.containsFromIndex(e, 7, 6));
	}

	@Test
	void testContainsUptoIndex() {
		assertFalse(testObject.containsUptoIndex(null, 35, 23));
		assertFalse(testObject.containsUptoIndex(emptyList, 96, 69));
		assertFalse(testObject.containsUptoIndex(singleItemList, 777, 0));
		assertFalse(testObject.containsUptoIndex(tenMultiples, 90, 4));
		assertFalse(testObject.containsUptoIndex(negPos, -13, -1));
		assertTrue(testObject.containsUptoIndex(ascAllPos, 254, 7));
		assertTrue(testObject.containsUptoIndex(descNegs, -115, 0));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7));
		assertTrue(testObject.containsUptoIndex(e, 7, 0));
		assertTrue(testObject.containsUptoIndex(e, 7, 6));
	}

	@Test
	void testContainsBetweenIndices() {
		assertFalse(testObject.containsBetweenIndices(null, 35, 0, 0));
		assertFalse(testObject.containsBetweenIndices(emptyList, 35, 0, 0));
		assertFalse(testObject.containsBetweenIndices(singleItemList, 35, 0, 0));
		assertFalse(testObject.containsBetweenIndices(singleItemList, -7, 1, 1));
		assertTrue(testObject.containsBetweenIndices(singleItemList, -7, 0, 0));
		assertTrue(testObject.containsBetweenIndices(tenMultiples, 90, 3, 3));
		assertTrue(testObject.containsBetweenIndices(tenMultiples, 90, 1, 3));
		assertFalse(testObject.containsBetweenIndices(tenMultiples, 10, 1, 3));
		assertTrue(testObject.containsBetweenIndices(tenMultiples, 10, 0, 0));
		assertTrue(testObject.containsBetweenIndices(tenMultiples, 10, 0, 1));
	}

	@Test
	void testSumFromIndex() {
		assertEquals(0, testObject.sumFromIndex(null, 23));
		assertEquals(0, testObject.sumFromIndex(emptyList, 35));
		assertEquals(-7, testObject.sumFromIndex(singleItemList, 0));
		assertEquals(0, testObject.sumFromIndex(tenMultiples, 1));
		assertEquals((-101), testObject.sumFromIndex(negPos, 6));
		assertEquals(0, testObject.sumFromIndex(ascAllPos, -1));
		assertEquals(0, testObject.sumFromIndex(descNegs, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumFromIndex(e, 0));
		assertEquals(0, testObject.sumFromIndex(e, 4));
	}

	@Test
	void testSumUptoIndex() {
		assertEquals(0, testObject.sumUptoIndex(null, 23));
		assertEquals(0, testObject.sumUptoIndex(emptyList, 35));
		assertEquals(-7, testObject.sumUptoIndex(singleItemList, 0));
		assertEquals((-80), testObject.sumUptoIndex(tenMultiples, 2));
		assertEquals((-3), testObject.sumUptoIndex(negPos, 0));
		assertEquals(0, testObject.sumUptoIndex(ascAllPos, -1));
		assertEquals(0, testObject.sumUptoIndex(descNegs, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumUptoIndex(e, 0));
		assertEquals(0, testObject.sumUptoIndex(e, 4));
	}

	@Test
	void testSumBetweenIndices() {
		assertEquals(0, testObject.sumBetweenIndices(null, 23, 35));
		assertEquals(0, testObject.sumBetweenIndices(emptyList, 69, 96));
		assertEquals(-7, testObject.sumBetweenIndices(singleItemList, 0, 0));
		assertEquals((-90), testObject.sumBetweenIndices(tenMultiples, 1, 2));
		assertEquals(0, testObject.sumBetweenIndices(negPos, -1, 7));
		assertEquals(0, testObject.sumBetweenIndices(ascAllPos, -1, 7));
		assertEquals(0, testObject.sumBetweenIndices(descNegs, 0, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumBetweenIndices(e, 0, 4));
		assertEquals(0, testObject.sumBetweenIndices(e, 1, 3));
	}

	@Test
	void testSumEvenFromIndex() {
		assertEquals(0, testObject.sumEvenFromIndex(null, 23));
		assertEquals(0, testObject.sumEvenFromIndex(emptyList, 35));
		assertEquals(0, testObject.sumEvenFromIndex(singleItemList, 0));
		assertEquals(70, testObject.sumEvenFromIndex(tenMultiples, 2));
		assertEquals(10, testObject.sumEvenFromIndex(negPos, 5));
		assertEquals(0, testObject.sumEvenFromIndex(ascAllPos, -1));
		assertEquals(0, testObject.sumEvenFromIndex(descNegs, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumEvenFromIndex(e, 0));
		assertEquals(0, testObject.sumEvenFromIndex(e, 4));
	}

	@Test
	void testSumOddUptoIndex() {
		assertEquals(0, testObject.sumOddUptoIndex(null, 23));
		assertEquals(0, testObject.sumOddUptoIndex(emptyList, 35));
		assertEquals(-7, testObject.sumOddUptoIndex(singleItemList, 0));
		assertEquals(0, testObject.sumOddUptoIndex(tenMultiples, 3));
		assertEquals(-2, testObject.sumOddUptoIndex(negPos, 4));
		assertEquals(0, testObject.sumOddUptoIndex(ascAllPos, -1));
		assertEquals(0, testObject.sumOddUptoIndex(descNegs, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(0, testObject.sumOddUptoIndex(e, 0));
		assertEquals(0, testObject.sumOddUptoIndex(e, 4));
	}

	@Test
	void testProductPositivesUptoIndex() {
		assertEquals(1, testObject.productPositivesUptoIndex(null, 23));
		assertEquals(1, testObject.productPositivesUptoIndex(emptyList, 35));
		assertEquals(1, testObject.productPositivesUptoIndex(singleItemList, 0));
		assertEquals(900, testObject.productPositivesUptoIndex(tenMultiples, 3));
		assertEquals(240, testObject.productPositivesUptoIndex(negPos, 4));
		assertEquals(1, testObject.productPositivesUptoIndex(ascAllPos, -1));
		assertEquals(1, testObject.productPositivesUptoIndex(descNegs, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(1, testObject.productPositivesUptoIndex(e, 0));
		assertEquals(1, testObject.productPositivesUptoIndex(e, 4));
	}

	@Test
	void testProductNegativesFromIndex() {
		assertEquals(1, testObject.productNegativesFromIndex(null, 23));
		assertEquals(1, testObject.productNegativesFromIndex(emptyList, 35));
		assertEquals(-7, testObject.productNegativesFromIndex(singleItemList, 0));
		assertEquals(-20, testObject.productNegativesFromIndex(tenMultiples, 2));
		assertEquals(-101, testObject.productNegativesFromIndex(negPos, 5));
		assertEquals(1, testObject.productNegativesFromIndex(ascAllPos, -1));
		assertEquals(1, testObject.productNegativesFromIndex(descNegs, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertEquals(1, testObject.productNegativesFromIndex(e, 0));
		assertEquals(1, testObject.productNegativesFromIndex(e, 4));
	}

	@Test
	void testCountOccurrencesBetweenIndices() {
		assertEquals(0, testObject.countOccurrencesBetweenIndices(null, 235, 23, 35));
		assertEquals(0, testObject.countOccurrencesBetweenIndices(emptyList, 6996, 69, 96));
		assertEquals(0, testObject.countOccurrencesBetweenIndices(singleItemList, 777, 0, 0));
		assertEquals(1, testObject.countOccurrencesBetweenIndices(singleItemList, -7, 0, 0));
		assertEquals(0, testObject.countOccurrencesBetweenIndices(tenMultiples, 10, 1, 2));
		assertEquals(0, testObject.countOccurrencesBetweenIndices(negPos, 2, -1, 7));
		assertEquals(0, testObject.countOccurrencesBetweenIndices(ascAllPos, 3, -1, 7));
		assertEquals(0, testObject.countOccurrencesBetweenIndices(descNegs, 5, 0, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7));
		assertEquals(7, testObject.countOccurrencesBetweenIndices(e, 7, 0, 6));
		assertEquals(5, testObject.countOccurrencesBetweenIndices(e, 7, 1, 5));
		assertEquals(3, testObject.countOccurrencesBetweenIndices(e, 7, 2, 4));
	}

	@Test
	void testCountUniqueBetweenIndices() {
		assertEquals(0, testObject.countUniqueBetweenIndices(null, 23, 35));
		assertEquals(0, testObject.countUniqueBetweenIndices(emptyList, 69, 96));
		assertEquals(1, testObject.countUniqueBetweenIndices(singleItemList, 0, 0));
		assertEquals(2, testObject.countUniqueBetweenIndices(tenMultiples, 1, 2));
		assertEquals(0, testObject.countUniqueBetweenIndices(negPos, -1, 7));
		assertEquals(0, testObject.countUniqueBetweenIndices(ascAllPos, -1, 7));
		assertEquals(0, testObject.countUniqueBetweenIndices(descNegs, 0, 6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(7, 7, 7, 7, 7, 7, 7));
		assertEquals(0, testObject.countUniqueBetweenIndices(e, 0, 6));
		assertEquals(0, testObject.countUniqueBetweenIndices(e, 1, 5));
		assertEquals(0, testObject.countUniqueBetweenIndices(e, 2, 4));
	}

	@Test
	void testAllPositives() {
		assertFalse(testObject.allPositives(null));
		assertTrue(testObject.allPositives(emptyList));
		assertFalse(testObject.allPositives(singleItemList));
		assertFalse(testObject.allPositives(tenMultiples));
		assertFalse(testObject.allPositives(negPos));
		assertTrue(testObject.allPositives(ascAllPos));
		assertFalse(testObject.allPositives(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertFalse(testObject.allPositives(e));
	}

	@Test
	void testAllNegatives() {
		assertFalse(testObject.allNegatives(null));
		assertTrue(testObject.allNegatives(emptyList));
		assertTrue(testObject.allNegatives(singleItemList));
		assertFalse(testObject.allNegatives(tenMultiples));
		assertFalse(testObject.allNegatives(negPos));
		assertFalse(testObject.allNegatives(ascAllPos));
		assertTrue(testObject.allNegatives(descNegs));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		assertFalse(testObject.allNegatives(e));
	}

	@Test
	void testAllZeroes() {
		assertFalse(testObject.allZeroes(null));
		assertTrue(testObject.allZeroes(emptyList));
		assertFalse(testObject.allZeroes(singleItemList));
		assertFalse(testObject.allZeroes(tenMultiples));
		assertFalse(testObject.allZeroes(negPos));
		assertFalse(testObject.allZeroes(ascAllPos));
		assertFalse(testObject.allZeroes(descNegs));
		assertTrue(testObject.allZeroes(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testAllNonZeroes() {
		assertFalse(testObject.allNonZeroes(null));
		assertTrue(testObject.allNonZeroes(emptyList));
		assertTrue(testObject.allNonZeroes(singleItemList));
		assertTrue(testObject.allNonZeroes(tenMultiples));
		assertTrue(testObject.allNonZeroes(negPos));
		assertTrue(testObject.allNonZeroes(ascAllPos));
		assertTrue(testObject.allNonZeroes(descNegs));
		assertFalse(testObject.allNonZeroes(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testContainsPositive() {
		assertFalse(testObject.containsPositive(null));
		assertFalse(testObject.containsPositive(emptyList));
		assertFalse(testObject.containsPositive(singleItemList));
		assertTrue(testObject.containsPositive(tenMultiples));
		assertTrue(testObject.containsPositive(negPos));
		assertTrue(testObject.containsPositive(ascAllPos));
		assertFalse(testObject.containsPositive(descNegs));
		assertFalse(testObject.containsPositive(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testContainsNegative() {
		assertFalse(testObject.containsNegative(null));
		assertFalse(testObject.containsNegative(emptyList));
		assertTrue(testObject.containsNegative(singleItemList));
		assertTrue(testObject.containsNegative(tenMultiples));
		assertTrue(testObject.containsNegative(negPos));
		assertFalse(testObject.containsNegative(ascAllPos));
		assertTrue(testObject.containsNegative(descNegs));
		assertFalse(testObject.containsNegative(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testContainsZero() {
		assertFalse(testObject.containsZero(null));
		assertFalse(testObject.containsZero(emptyList));
		assertFalse(testObject.containsZero(singleItemList));
		singleItemList.set(0, 0);
		assertTrue(testObject.containsZero(singleItemList));
		assertFalse(testObject.containsZero(tenMultiples));
		assertFalse(testObject.containsZero(negPos));
		assertFalse(testObject.containsZero(ascAllPos));
		assertFalse(testObject.containsZero(descNegs));
		assertTrue(testObject.containsZero(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testContainsNonZero() {
		assertFalse(testObject.containsNonZero(null));
		assertFalse(testObject.containsNonZero(emptyList));
		assertTrue(testObject.containsNonZero(singleItemList));
		singleItemList.set(0, 0);
		assertFalse(testObject.containsNonZero(singleItemList));
		assertTrue(testObject.containsNonZero(tenMultiples));
		assertTrue(testObject.containsNonZero(negPos));
		assertTrue(testObject.containsNonZero(ascAllPos));
		assertTrue(testObject.containsNonZero(descNegs));
		assertFalse(testObject.containsNonZero(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testIsAscending() {
		assertFalse(testObject.isAscending(null));
		assertTrue(testObject.isAscending(emptyList));
		assertTrue(testObject.isAscending(singleItemList));
		assertFalse(testObject.isAscending(tenMultiples));
		assertFalse(testObject.isAscending(negPos));
		assertTrue(testObject.isAscending(ascAllPos));
		assertFalse(testObject.isAscending(descNegs));
		assertTrue(testObject.isAscending(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testIsDescending() {
		assertFalse(testObject.isDescending(null));
		assertTrue(testObject.isDescending(emptyList));
		assertTrue(testObject.isDescending(singleItemList));
		assertFalse(testObject.isDescending(tenMultiples));
		assertFalse(testObject.isDescending(negPos));
		assertFalse(testObject.isDescending(ascAllPos));
		assertTrue(testObject.isDescending(descNegs));
		assertTrue(testObject.isDescending(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testIsUnchanged() {
		assertFalse(testObject.isUnchanged(null));
		assertTrue(testObject.isUnchanged(emptyList));
		assertTrue(testObject.isUnchanged(singleItemList));
		assertFalse(testObject.isUnchanged(tenMultiples));
		assertFalse(testObject.isUnchanged(negPos));
		assertFalse(testObject.isUnchanged(ascAllPos));
		assertFalse(testObject.isUnchanged(descNegs));
		assertTrue(testObject.isUnchanged(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testgetSortedOrder() {
		assertEquals(0, testObject.getSortedOrder(null));
		assertEquals(2, testObject.getSortedOrder(emptyList));
		assertEquals(2, testObject.getSortedOrder(singleItemList));
		assertEquals(0, testObject.getSortedOrder(tenMultiples));
		assertEquals(0, testObject.getSortedOrder(negPos));
		assertEquals(1, testObject.getSortedOrder(ascAllPos));
		assertEquals(-1, testObject.getSortedOrder(descNegs));
		assertEquals(2, testObject.getSortedOrder(new ArrayList<Integer>(Arrays.asList(10, 10, 10, 10, 10))));
	}

	@Test
	void testIsBalanced() {
		assertFalse(testObject.isBalanced(null));
		assertTrue(testObject.isBalanced(emptyList));
		assertFalse(testObject.isBalanced(singleItemList));
		assertTrue(testObject.isBalanced(tenMultiples));
		assertFalse(testObject.isBalanced(negPos));
		assertFalse(testObject.isBalanced(ascAllPos));
		assertFalse(testObject.isBalanced(descNegs));
		assertTrue(testObject.isBalanced(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0))));
	}

	@Test
	void testAllDigits() {
		assertFalse(testObject.allDigits(null));
		assertTrue(testObject.allDigits(new ArrayList<Character>()));
		assertTrue(testObject.allDigits(new ArrayList<Character>(Arrays.asList('7'))));
		assertTrue(testObject.allDigits(new ArrayList<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'))));
		assertFalse(testObject.allDigits(new ArrayList<Character>(Arrays.asList('C', 'O', 'M', 'P', '1', '2', '5'))));
		assertFalse(testObject.allDigits(new ArrayList<Character>(Arrays.asList('H', 'D'))));
	}

	@Test
	void testContainsDigit() {
		assertFalse(testObject.containsDigit(null));
		assertFalse(testObject.containsDigit(new ArrayList<Character>()));
		assertTrue(testObject.containsDigit(new ArrayList<Character>(Arrays.asList('7'))));
		assertTrue(testObject.containsDigit(new ArrayList<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'))));
		assertTrue(testObject.containsDigit(new ArrayList<Character>(Arrays.asList('C', 'O', 'M', 'P', '1', '2', '5'))));
		assertFalse(testObject.containsDigit(new ArrayList<Character>(Arrays.asList('H', 'D'))));
	}

	@Test
	void testToString() {
		assertNull(testObject.toString(null));
		assertEquals("", testObject.toString(new ArrayList<Character>()));
		assertEquals("COMP125", testObject.toString(new ArrayList<Character>(Arrays.asList('C', 'O', 'M', 'P', '1', '2', '5'))));
		assertEquals("Hello world!", testObject.toString(new ArrayList<Character>(Arrays.asList('H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!'))));
	}

	@Test
	void testGetCopy() {
		assertNull(testObject.getCopy(null));
		assertNotNull(testObject.getCopy(emptyList));
		assertEquals("[]", testObject.getCopy(emptyList).toString());
		assertNotSame(emptyList, testObject.getCopy(emptyList));
		assertNotNull(testObject.getCopy(singleItemList));
		assertNotSame(singleItemList, testObject.getCopy(singleItemList));
		assertEquals(0, testObject.getCopy(emptyList).size());
		assertEquals("[-7]", testObject.getCopy(singleItemList).toString());
		assertNotNull(testObject.getCopy(negPos));
		assertNotSame(negPos, testObject.getCopy(negPos));
		assertEquals("[-3, 15, -13, 16, -1, 10, -101]", testObject.getCopy(negPos).toString());		
	}

}
