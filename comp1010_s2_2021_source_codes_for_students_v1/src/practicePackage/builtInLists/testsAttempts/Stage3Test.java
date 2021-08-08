package practicePackage.builtInLists.testsAttempts;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ServiceClasses.Rectangle;
import practicePackage.builtInLists.attempts.*;

@SuppressWarnings("unused")
public class Stage3Test {
	protected practicePackage.builtInLists.attempts.Stage3 testObject;
	
	public ArrayList<Integer> nullList, emptyList, singleItemList, list1, list2;

	public ArrayList<Integer> multiplesTen1, multiplesTen2, reverseMultiplesTen, mixedPosNeg, allZeroes1, allZeroes2;

	@BeforeEach
	public void run() {
		testObject = new practicePackage.builtInLists.attempts.Stage3();
		nullList = null;
		emptyList = new ArrayList<Integer>();
		singleItemList = new ArrayList<Integer>(Arrays.asList(777));
		list1 = new ArrayList<Integer>(Arrays.asList(10,70,20,90));
		list2 = new ArrayList<Integer>(Arrays.asList(-5, 0, 8, -7, 9, 15, 23, -1, 5));
		multiplesTen1 = new ArrayList<Integer>(Arrays.asList(10, 70, 20, 90));
		multiplesTen2 = new ArrayList<Integer>(Arrays.asList(10, 70, 20, 90));
		reverseMultiplesTen = new ArrayList<Integer>(Arrays.asList(90, 20, 70, 10));
		mixedPosNeg = new ArrayList<Integer>(Arrays.asList(-50, 30, -20, 0, 20, -30, 50));
		allZeroes1 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
		allZeroes2 = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	}

	@Test
	void testGetPositives() {
		assertNotNull(testObject.getPositives(list1));
		assertEquals("[10, 70, 20, 90]", testObject.getPositives(list1).toString());

		//to check that you are not modifying the list passed	
		assertNotNull(testObject.getPositives(list1));
		assertEquals("[10, 70, 20, 90]", testObject.getPositives(list1).toString());

		assertNotNull(testObject.getPositives(list2).toString());
		assertEquals("[8, 9, 15, 23, 5]", testObject.getPositives(list2).toString());
		assertNotNull(testObject.getPositives(singleItemList).toString());
		assertEquals("[777]", testObject.getPositives(singleItemList).toString());
		assertNotNull(testObject.getPositives(emptyList).toString());
		assertEquals("[]", testObject.getPositives(emptyList).toString());
		assertNull(testObject.getPositives(nullList));
	}

	@Test
	void testRemoveNegatives() {
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		list2.add(-6);
		//a whole lot of -6s at the end
		testObject.removeNegatives(list2);
		assertEquals("[0, 8, 9, 15, 23, 5]", list2.toString());
		testObject.removeNegatives(singleItemList);
		assertEquals("[777]", singleItemList.toString());
	}

	@Test
	void testTwoInARow() {
		assertFalse(testObject.twoInARow(list1, 5));
		assertFalse(testObject.twoInARow(list1, 10));
		assertFalse(testObject.twoInARow(list1, 70));
		assertFalse(testObject.twoInARow(list1, 20));
		assertFalse(testObject.twoInARow(list1, 90));

		list1 = new ArrayList<Integer>(Arrays.asList(10,70,5,5));
		assertTrue(testObject.twoInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(5,5,8,3));
		assertTrue(testObject.twoInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,5,4,3,2,1));
		assertTrue(testObject.twoInARow(list1, 5));	
	}

	@Test
	void testThreeInARow() {
		assertFalse(testObject.threeInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(10,5,0,5,5));
		assertFalse(testObject.threeInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(10,70,5,5,5));
		assertTrue(testObject.threeInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(10,70,5,5));
		assertFalse(testObject.threeInARow(list1, 5));		

		list1 = new ArrayList<Integer>(Arrays.asList(5,5,5,8,3));
		assertTrue(testObject.threeInARow(list1, 5));

		list1 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,5,5,5,5,5,5,5,4,3,2,1));
		assertTrue(testObject.threeInARow(list1, 5));	
	}

	@Test
	void testMutuallyReverse() {
		assertFalse(testObject.mutuallyReverse(list1, list2));
		list2 = new ArrayList<Integer>(Arrays.asList(90,20,70,10));
		assertTrue(testObject.mutuallyReverse(list1, list2));
		list2 = new ArrayList<Integer>(Arrays.asList(90,70,20,10));
		assertFalse(testObject.mutuallyReverse(list1, list2));
	}

	@Test
	void testAllUnique() {
		assertTrue(testObject.allUnique(list1));
		assertTrue(testObject.allUnique(list2));
		assertTrue(testObject.allUnique(singleItemList));
		assertTrue(testObject.allUnique(emptyList));
		list2 = new ArrayList<Integer>(Arrays.asList(-5, 0, 8, -7, 9, 15, 23, -1, -5));
		assertFalse(testObject.allUnique(list2));
		list2 = new ArrayList<Integer>(Arrays.asList(0, 8, -7, 9, 15, 23, -1, -5, -5));
		assertFalse(testObject.allUnique(list2));
	}

	@Test
	void testGetRectangles() {
		ArrayList<Integer> widths = new ArrayList<Integer>(Arrays.asList(10,70,20,90));
		ArrayList<Integer> heights = new ArrayList<Integer>(Arrays.asList(50,30,60,70));
		ArrayList<Rectangle> list = testObject.getRectangles(widths, heights);
		assertNotNull(list);
		assertEquals(4, list.size());
		assertEquals("10 by 50", list.get(0).toString());
		assertEquals("70 by 30", list.get(1).toString());
		assertEquals("20 by 60", list.get(2).toString());
		assertEquals("90 by 70", list.get(3).toString());
	}

	@Test
	void testGeneratePatternedArray() {
		assertNull(testObject.generatePatternedArray(-1, 2, 5));

		assertNotNull(testObject.generatePatternedArray(0, 2, 5));
		assertEquals("[]", testObject.generatePatternedArray(0, 2, 5).toString());

		assertNotNull(testObject.generatePatternedArray(5, 2, 3));
		assertEquals("[2, 5, 8, 11, 14]", testObject.generatePatternedArray(5, 2, 3).toString());

		assertNotNull(testObject.generatePatternedArray(7, 0, -3));
		assertEquals("[0, -3, -6, -9, -12, -15, -18]", testObject.generatePatternedArray(7, 0, -3).toString());
	}

	@Test
	void testCountUniqueItems() {
		assertEquals(0, testObject.countUniqueItems(null));
		assertEquals(0, testObject.countUniqueItems(emptyList));
		assertEquals(1, testObject.countUniqueItems(singleItemList));
		assertEquals(4, testObject.countUniqueItems(multiplesTen1));
		assertEquals(0, testObject.countUniqueItems(allZeroes1));
		assertEquals(1, testObject.countUniqueItems(new ArrayList<Integer>(Arrays.asList(10,20,30,40,40,30,20,10,50))));
	}

	@Test
	void testIdentical() {
		assertFalse(testObject.identical(multiplesTen1, null));
		assertFalse(testObject.identical(null, multiplesTen2));
		assertFalse(testObject.identical(null, null));
		assertFalse(testObject.identical(emptyList, singleItemList));
		assertTrue(testObject.identical(multiplesTen1, multiplesTen2));
		assertTrue(testObject.identical(multiplesTen2, multiplesTen1));
		assertFalse(testObject.identical(multiplesTen1, new ArrayList<Integer>(Arrays.asList(10, 20, 70, 90))));
		assertFalse(testObject.identical(multiplesTen2, new ArrayList<Integer>(Arrays.asList(10, 70, 20))));
		assertFalse(testObject.identical(multiplesTen1, new ArrayList<Integer>(Arrays.asList(10, 70))));
		assertFalse(testObject.identical(multiplesTen2, new ArrayList<Integer>(Arrays.asList(10))));
		assertTrue(testObject.identical(allZeroes1, allZeroes2));
		assertTrue(testObject.identical(allZeroes2, allZeroes1));
	}

	@Test
	void testContains() {
		assertFalse(testObject.contains(multiplesTen1, null));
		assertFalse(testObject.contains(null, multiplesTen2));
		assertFalse(testObject.contains(null, null));
		assertFalse(testObject.contains(emptyList, singleItemList));
		assertTrue(testObject.contains(singleItemList, emptyList));
		assertTrue(testObject.contains(multiplesTen1, multiplesTen2));
		assertTrue(testObject.contains(multiplesTen2, multiplesTen1));
		assertTrue(testObject.contains(multiplesTen1, reverseMultiplesTen));
		assertTrue(testObject.contains(reverseMultiplesTen, multiplesTen1));
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10, -70, 20, -90, 90, -20, 70, -10));
		assertTrue(testObject.contains(list, multiplesTen1));
		assertTrue(testObject.contains(list, multiplesTen2));
		assertTrue(testObject.contains(list, reverseMultiplesTen));
		assertTrue(testObject.contains(allZeroes1, allZeroes2));
		assertTrue(testObject.contains(allZeroes2, allZeroes1));
	}

	@Test
	void testSame() {
		assertFalse(testObject.same(multiplesTen1, null));
		assertFalse(testObject.same(null, multiplesTen2));
		assertFalse(testObject.same(null, null));
		assertFalse(testObject.same(emptyList, singleItemList));
		assertFalse(testObject.same(singleItemList, emptyList));
		assertTrue(testObject.same(multiplesTen1, multiplesTen2));
		assertTrue(testObject.same(multiplesTen2, multiplesTen1));
		assertTrue(testObject.same(multiplesTen1, reverseMultiplesTen));
		assertTrue(testObject.same(reverseMultiplesTen, multiplesTen1));
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10, -70, 20, -90, 90, -20, 70, -10));
		assertFalse(testObject.same(list, multiplesTen1));
		assertFalse(testObject.same(list, multiplesTen2));
		assertFalse(testObject.same(list, reverseMultiplesTen));
		assertTrue(testObject.same(allZeroes1, allZeroes2));
		assertTrue(testObject.same(allZeroes2, allZeroes1));
	}

	@Test
	void testMerge() {
		assertNull(testObject.merge(reverseMultiplesTen, null));
		assertNull(testObject.merge(null, mixedPosNeg));
		assertNull(testObject.merge(null, null));
		assertNotNull(testObject.merge(emptyList, emptyList));
		assertEquals(0, testObject.merge(emptyList, emptyList).size());
		assertEquals("[777]", testObject.merge(emptyList, singleItemList).toString());
		assertEquals("[777]", testObject.merge(singleItemList, emptyList).toString());
		assertEquals("[10, 70, 20, 90, 10, 70, 20, 90]", testObject.merge(multiplesTen1, multiplesTen2).toString());
		assertEquals("[10, 70, 20, 90, 90, 20, 70, 10]", testObject.merge(multiplesTen2, reverseMultiplesTen).toString());
		assertEquals("[90, 20, 70, 10, 10, 70, 20, 90]", testObject.merge(reverseMultiplesTen, multiplesTen1).toString());
		assertEquals("[-50, 30, -20, 0, 20, -30, 50, 0, 0, 0, 0, 0]", testObject.merge(mixedPosNeg, allZeroes1).toString());
		assertEquals("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]", testObject.merge(allZeroes1, allZeroes1).toString());
		assertEquals("[0, 0, 0, 0, 0, -50, 30, -20, 0, 20, -30, 50]", testObject.merge(allZeroes2, mixedPosNeg).toString());
		assertEquals("[-50, 30, -20, 0, 20, -30, 50, -50, 30, -20, 0, 20, -30, 50]", testObject.merge(mixedPosNeg, mixedPosNeg).toString());
	}

	@Test
	void testGenerate() {
		assertNull(testObject.generate(-1));
		assertNotNull(testObject.generate(0));
		assertEquals(0, testObject.generate(0).size());
		assertEquals(235, testObject.generate(235).size());
		assertEquals("[1, 2]", testObject.generate(2).toString());
		assertNotEquals("[0, 1, 2]", testObject.generate(3).toString());
		assertNotEquals("[2, 3, 4, 5, 6]", testObject.generate(5).toString());
	}

	@Test
	void testGetReverse() {
		assertNull(testObject.getReverse(null));
		assertNotNull(testObject.getReverse(emptyList));
		assertEquals(0, testObject.getReverse(emptyList).size());
		assertEquals("[777]", testObject.getReverse(singleItemList).toString());
		assertEquals(reverseMultiplesTen.toString(), testObject.getReverse(multiplesTen1).toString());
		assertEquals(multiplesTen2.toString(), testObject.getReverse(reverseMultiplesTen).toString());
		assertNotEquals(multiplesTen1.toString(), testObject.getReverse(multiplesTen2).toString());
		assertNotEquals("[90, 70, 20, 10]", testObject.getReverse(multiplesTen1).toString());
		assertNotEquals("[90, 20, 70]", testObject.getReverse(multiplesTen2).toString());
		assertNotEquals("[90, 20]", testObject.getReverse(multiplesTen1).toString());
		assertNotEquals("[90]", testObject.getReverse(multiplesTen2).toString());
		assertEquals(allZeroes1.toString(), testObject.getReverse(allZeroes2).toString());
		assertEquals(allZeroes2.toString(), testObject.getReverse(allZeroes1).toString());
	}

	@Test
	void testGetMostFrequentItem() {
		assertEquals(2, testObject.getMostFrequentItem(new ArrayList<Integer>(Arrays.asList(1, 2, 2, 3, 5, 2, 2, 7))));
		assertEquals(3, testObject.getMostFrequentItem(new ArrayList<Integer>(Arrays.asList(3, 5, 7, 9, 11, 13, 5, 3))));
		assertEquals(5, testObject.getMostFrequentItem(new ArrayList<Integer>(Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5))));
	}

	@Test
	void testGetLeastFrequentItem() {
		assertEquals(5, testObject.getLeastFrequentItem(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5))));
		assertEquals(3, testObject.getLeastFrequentItem(new ArrayList<Integer>(Arrays.asList(3, 11, 11, 15, 15, 15, 19, 19, 19, 19, 23, 23, 23, 23, 23, 7))));
		assertEquals(2, testObject.getLeastFrequentItem(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2))));
	}

	@Test
	void testGetFrequencyTable() {
		assertNull(testObject.getFrequencyTable(null));
		assertNotNull(testObject.getFrequencyTable(emptyList));
		assertEquals(0, testObject.getFrequencyTable(emptyList).size());
		assertNotNull(testObject.getFrequencyTable(singleItemList));
		assertEquals("[[777, 1]]", testObject.getFrequencyTable(singleItemList).toString());
		assertNotNull(testObject.getFrequencyTable(mixedPosNeg));
		assertEquals("[[-50, 1], [30, 1], [-20, 1], [0, 1], [20, 1], [-30, 1], [50, 1]]", testObject.getFrequencyTable(mixedPosNeg).toString());
		assertEquals("[[4, 2], [7, 3], [13, 5]]", testObject.getFrequencyTable(new ArrayList<Integer>(Arrays.asList(4, 7, 13, 13, 7, 13, 13, 13, 7, 4))).toString());
	}

	@Test
	void testSubArrayFromIndex() {
		assertNull(testObject.sublistFromIndex(null, 23));
		assertNull(testObject.sublistFromIndex(emptyList, 35));
		assertNull(testObject.sublistFromIndex(multiplesTen1, -1));
		assertNull(testObject.sublistFromIndex(multiplesTen2, 4));
		assertNotNull(testObject.sublistFromIndex(reverseMultiplesTen, 0));
		assertEquals("[90, 20, 70, 10]", testObject.sublistFromIndex(reverseMultiplesTen, 0).toString());
		assertEquals("[50]", testObject.sublistFromIndex(mixedPosNeg, 6).toString());
		assertEquals("[0, 0, 0, 0]", testObject.sublistFromIndex(allZeroes1, 1).toString());
		assertEquals("[0, 0, 0]", testObject.sublistFromIndex(allZeroes2, 2).toString());
	}

	@Test
	void testSubArrayUptoIndex() {
		assertNull(testObject.sublistUptoIndex(null, 69));
		assertNull(testObject.sublistUptoIndex(emptyList, 96));
		assertNull(testObject.sublistUptoIndex(multiplesTen1, -1));
		assertNull(testObject.sublistUptoIndex(multiplesTen2, 4));
		assertNotNull(testObject.sublistUptoIndex(reverseMultiplesTen, 3));
		assertEquals("[90, 20, 70, 10]", testObject.sublistUptoIndex(reverseMultiplesTen, 3).toString());
		assertEquals("[-50]", testObject.sublistUptoIndex(mixedPosNeg, 0).toString());
		assertEquals("[0, 0]", testObject.sublistUptoIndex(allZeroes1, 1).toString());
		assertEquals("[0, 0, 0]", testObject.sublistUptoIndex(allZeroes2, 2).toString());
	}

	@Test
	void testSubarray() {
		assertNull(testObject.sublist(null, 23, 35)); 
		assertNull(testObject.sublist(emptyList, 69, 96));
		assertNull(testObject.sublist(multiplesTen1, -1, 2));
		assertNull(testObject.sublist(multiplesTen2, 3, 4));
		assertNull(testObject.sublist(reverseMultiplesTen, 1, 0));
		assertNotNull(testObject.sublist(mixedPosNeg, 2, 4));
		assertEquals("[-20, 0, 20]", testObject.sublist(mixedPosNeg, 2, 4).toString());
		assertEquals(allZeroes1.toString(), testObject.sublist(allZeroes2, 0, 4).toString());
	}

	@Test
	void testGetNegatives() {
		assertNull(testObject.getNegatives(null)); 
		assertNotNull(testObject.getNegatives(emptyList)); 
		assertEquals(0, testObject.getNegatives(emptyList).size()); 
		assertEquals(0, testObject.getNegatives(multiplesTen1).size());
		assertEquals(0, testObject.getNegatives(multiplesTen2).size());
		assertEquals(0, testObject.getNegatives(reverseMultiplesTen).size());
		assertNotEquals("[-50, -20, 0, -30]", testObject.getNegatives(mixedPosNeg).toString());
		assertEquals("[-50, -20, -30]", testObject.getNegatives(mixedPosNeg).toString());
		assertEquals(0, testObject.getNegatives(allZeroes1).size());
		assertEquals(0, testObject.getNegatives(allZeroes2).size());
	}

	@Test
	void testGetNonZeroes() {
		assertNull(testObject.getNonZeroes(null));
		assertNotNull(testObject.getNonZeroes(emptyList));
		assertEquals(0, testObject.getNonZeroes(emptyList).size());
		assertEquals("[10, 70, 20, 90]", testObject.getNonZeroes(multiplesTen1).toString());
		assertEquals("[10, 70, 20, 90]", testObject.getNonZeroes(multiplesTen2).toString());
		assertEquals("[90, 20, 70, 10]", testObject.getNonZeroes(reverseMultiplesTen).toString());
		assertEquals("[-50, 30, -20, 20, -30, 50]", testObject.getNonZeroes(mixedPosNeg).toString());
		assertEquals(0, testObject.getNonZeroes(allZeroes1).size());
		assertEquals(0, testObject.getNonZeroes(allZeroes2).size());
	}

	@Test
	void testGetPrimes() {
		assertNull(testObject.getPrimes(null)); 
		assertNotNull(testObject.getPrimes(emptyList)); 
		assertEquals(0, testObject.getPrimes(emptyList).size()); 
		assertEquals(0, testObject.getPrimes(mixedPosNeg).size());
		assertEquals("[2, 3, 5]", testObject.getPrimes(new ArrayList<Integer>(Arrays.asList(2, 3, 5))).toString());
		assertEquals("[7]", testObject.getPrimes(new ArrayList<Integer>(Arrays.asList(0, 1, 4, 6, 7, 8, 9))).toString());
	}

	@Test
	void testGetWithoutNegatives() {
		assertNull(testObject.getWithoutNegatives(null)); 
		assertNotNull(testObject.getWithoutNegatives(emptyList)); 
		assertEquals(0, testObject.getWithoutNegatives(emptyList).size()); 
		assertEquals(multiplesTen1.toString(), testObject.getWithoutNegatives(multiplesTen2).toString());
		assertEquals(multiplesTen2.toString(), testObject.getWithoutNegatives(multiplesTen1).toString());
		assertEquals(reverseMultiplesTen.toString(), testObject.getWithoutNegatives(reverseMultiplesTen).toString());
		assertNotEquals("[30, 20, 50]", testObject.getWithoutNegatives(mixedPosNeg).toString());
		assertEquals("[30, 0, 20, 50]", testObject.getWithoutNegatives(mixedPosNeg).toString());
		assertEquals(allZeroes1.toString(), testObject.getWithoutNegatives(allZeroes2).toString());
		assertEquals(allZeroes2.toString(), testObject.getWithoutNegatives(allZeroes1).toString());
	}

	@Test
	void testGetWithoutPositives() {
		assertNull(testObject.getWithoutPositives(null)); 
		assertNotNull(testObject.getWithoutPositives(emptyList)); 
		assertEquals(0, testObject.getWithoutPositives(emptyList).size()); 
		assertEquals(0, testObject.getWithoutPositives(multiplesTen1).size());
		assertEquals(0, testObject.getWithoutPositives(multiplesTen2).size());
		assertEquals(0, testObject.getWithoutPositives(reverseMultiplesTen).size());
		assertNotEquals("[-50, -20, -30]", testObject.getWithoutPositives(mixedPosNeg).toString());
		assertEquals("[-50, -20, 0, -30]", testObject.getWithoutPositives(mixedPosNeg).toString());
		assertEquals(allZeroes1.toString(), testObject.getWithoutPositives(allZeroes2).toString());
		assertEquals(allZeroes2.toString(), testObject.getWithoutPositives(allZeroes1).toString());
	}

	@Test
	void testGetUniqueItems() {
		assertNull(testObject.getUniqueItems(null));
		assertNotNull(testObject.getUniqueItems(emptyList));
		assertEquals(0, testObject.getUniqueItems(emptyList).size());
		assertEquals(multiplesTen1.toString(), testObject.getUniqueItems(multiplesTen2).toString());
		assertEquals(multiplesTen2.toString(), testObject.getUniqueItems(multiplesTen1).toString());
		assertEquals(reverseMultiplesTen.toString(), testObject.getUniqueItems(reverseMultiplesTen).toString());
		assertEquals(mixedPosNeg.toString(), testObject.getUniqueItems(mixedPosNeg).toString());
		assertEquals(0, testObject.getUniqueItems(allZeroes1).size());
		assertEquals(0, testObject.getUniqueItems(allZeroes2).size());
		assertEquals("[2, 3, 5]", testObject.getUniqueItems(new ArrayList<Integer>(Arrays.asList(4, 2, 4, 3, 6, 5, 6))).toString());
	}

	@Test
	void testGetCopy() {
		assertNull(testObject.getCopy(null));
		assertNotNull(testObject.getCopy(new ArrayList<ArrayList<Integer>>()));
		assertEquals(0, testObject.getCopy(new ArrayList<ArrayList<Integer>>()).size());
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(Arrays.asList(multiplesTen1, reverseMultiplesTen, allZeroes1));
		assertNotSame(multiplesTen1, testObject.getCopy(temp).get(0));
		assertNotSame(reverseMultiplesTen, testObject.getCopy(temp).get(1));
		assertNotSame(allZeroes1, testObject.getCopy(temp).get(2));
		assertNotNull(testObject.getCopy(temp));
		assertNotNull(testObject.getCopy(temp).get(0));
		assertEquals(multiplesTen2.toString(), testObject.getCopy(temp).get(0).toString());
		assertEquals(reverseMultiplesTen.toString(), testObject.getCopy(temp).get(1).toString());
		assertEquals(allZeroes2.toString(), testObject.getCopy(temp).get(2).toString());
	}

	@Test
	void testIndexOf() {
		assertEquals(-1, testObject.indexOf(emptyList, singleItemList));
		assertEquals(-1, testObject.indexOf(multiplesTen1, new ArrayList<Integer>(Arrays.asList(0, 10, 70, 20, 90))));
		assertEquals(0, testObject.indexOf(multiplesTen1, multiplesTen2));
		assertEquals(1, testObject.indexOf(multiplesTen2, new ArrayList<Integer>(Arrays.asList(70, 20))));
		assertEquals(-1, testObject.indexOf(mixedPosNeg, reverseMultiplesTen));
		assertEquals(3, testObject.indexOf(mixedPosNeg, new ArrayList<Integer>(Arrays.asList(0))));
		assertEquals(2, testObject.indexOf(new ArrayList<Integer>(Arrays.asList(23, 35, 90, 20, 70, 10, 69, 90, 20, 70, 10, 96, 90, 20, 70, 10, 13, 4, 7, 13)), reverseMultiplesTen));
		assertEquals(0, testObject.indexOf(allZeroes2, allZeroes1));
		assertEquals(0, testObject.indexOf(allZeroes1, allZeroes2));
	}

	@Test
	void testLastIndexOf() {
		assertEquals(-1, testObject.lastIndexOf(emptyList, singleItemList));
		assertEquals(-1, testObject.lastIndexOf(multiplesTen2, new ArrayList<Integer>(Arrays.asList(0, 10, 70, 20, 90))));
		assertEquals(0, testObject.lastIndexOf(multiplesTen2, multiplesTen1));
		assertEquals(1, testObject.lastIndexOf(multiplesTen1, new ArrayList<Integer>(Arrays.asList(70, 20))));
		assertEquals(-1, testObject.lastIndexOf(mixedPosNeg, reverseMultiplesTen));
		assertEquals(3, testObject.lastIndexOf(mixedPosNeg, new ArrayList<Integer>(Arrays.asList(0))));
		assertEquals(12, testObject.lastIndexOf(new ArrayList<Integer>(Arrays.asList(23, 35, 90, 20, 70, 10, 69, 90, 20, 70, 10, 96, 90, 20, 70, 10, 13, 4, 7, 13)), reverseMultiplesTen));
		assertEquals(0, testObject.lastIndexOf(allZeroes1, allZeroes2));
		assertEquals(0, testObject.lastIndexOf(allZeroes2, allZeroes1));
	}

	@Test
	void testTotalNumberOfItems() {
		assertEquals(0, testObject.totalNumberOfItems(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(2, 3, 5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, 6, 8, 7, 9)));

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(4, 7, 13, 28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(10, 70, 20, 90)));

		assertEquals(0, testObject.totalNumberOfItems(multi1));
		assertEquals(1, testObject.totalNumberOfItems(multi2));
		assertEquals(10, testObject.totalNumberOfItems(multi3));

		assertEquals(8, testObject.totalNumberOfItems(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));	     
		assertEquals(0, testObject.totalNumberOfItems(multi5));
	}

	@Test
	void testTotalNumberOfEvenItems() {
		assertEquals(0, testObject.totalNumberOfEvenItems(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(2, 3, 5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, 6, 8, 7, 9)));

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(4, 7, 13, 28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(10, 70, 20, 90)));

		assertEquals(0, testObject.totalNumberOfEvenItems(multi1));
		assertEquals(0, testObject.totalNumberOfEvenItems(multi2));
		assertEquals(5, testObject.totalNumberOfEvenItems(multi3));
		assertEquals(6, testObject.totalNumberOfEvenItems(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));	     
		assertEquals(0, testObject.totalNumberOfEvenItems(multi5));
	}

	@Test
	void testTotalNumberOfOddItems() {
		assertEquals(0, testObject.totalNumberOfOddItems(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(2, 3, 5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, 6, 8, 7, 9)));

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(4, 7, 13, 28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(10, 70, 20, 90)));

		assertEquals(0, testObject.totalNumberOfOddItems(multi1));
		assertEquals(1, testObject.totalNumberOfOddItems(multi2));
		assertEquals(5, testObject.totalNumberOfOddItems(multi3));
		assertEquals(2, testObject.totalNumberOfOddItems(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));	     
		assertEquals(0, testObject.totalNumberOfOddItems(multi5));
	}

	@Test
	void testTotalNumberOfPositiveItems() {
		assertEquals(0, testObject.totalNumberOfPositiveItems(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, -1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(-2, 3, -5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, -6, 8, -7, 9)));

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(4, 7, -13, -28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(-10, 0, 20, 90)));


		assertEquals(0, testObject.totalNumberOfPositiveItems(multi1));
		assertEquals(1, testObject.totalNumberOfPositiveItems(multi2));
		assertEquals(4, testObject.totalNumberOfPositiveItems(multi3));
		assertEquals(4, testObject.totalNumberOfPositiveItems(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));	     
		assertEquals(0, testObject.totalNumberOfPositiveItems(multi5));
	}

	@Test
	void testTotalNumberOfNegativeItems() {
		assertEquals(0, testObject.totalNumberOfNegativeItems(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, -1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(-2, 3, -5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, -6, -8, 7, 9)));

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(4, 7, -13, -28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(-10, 0, 20, 90)));


		assertEquals(0, testObject.totalNumberOfNegativeItems(multi1));
		assertEquals(0, testObject.totalNumberOfNegativeItems(multi2));
		assertEquals(5, testObject.totalNumberOfNegativeItems(multi3));
		assertEquals(3, testObject.totalNumberOfNegativeItems(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));	     
		assertEquals(0, testObject.totalNumberOfNegativeItems(multi5));
	}

	@Test
	void testTotalNumberOfUniqueItems() {
		assertEquals(0, testObject.totalNumberOfUniqueItems(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, -1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(-2, 3, -5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, -6, 8, -7, 9)));

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(2, 4, 2, -7, 3, 13, 3, -28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(0, -10, 0, 70, 5, -20, 5, 90)));


		assertEquals(0, testObject.totalNumberOfUniqueItems(multi1));
		assertEquals(1, testObject.totalNumberOfUniqueItems(multi2));
		assertEquals(10, testObject.totalNumberOfUniqueItems(multi3));
		assertEquals(8, testObject.totalNumberOfUniqueItems(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));	     
		assertEquals(0, testObject.totalNumberOfUniqueItems(multi5));
	}

	@Test
	void testCountNullSublists() {
		assertEquals(0, testObject.countNullSublists(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, -1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(-2, 3, -5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, -6, 8, -7, 9)));
		multi3.add(null);
		multi3.add(null);
		multi3.add(null);

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(2, 4, 2, -7, 3, 13, 3, -28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(0, -10, 0, 70, 5, -20, 5, 90)));

		assertEquals(0, testObject.countNullSublists(multi1));
		assertEquals(0, testObject.countNullSublists(multi2));
		assertEquals(3, testObject.countNullSublists(multi3));
		assertEquals(2, testObject.countNullSublists(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));
		assertEquals(5, testObject.countNullSublists(multi5));
	}

	@Test
	void testCountNonNullSublists() {
		assertEquals(0, testObject.countNonNullSublists(null));

		ArrayList<ArrayList<Integer>> multi1 = new ArrayList<ArrayList<Integer>>();

		ArrayList<ArrayList<Integer>> multi2 = new ArrayList<ArrayList<Integer>>();
		multi2.add(new ArrayList<Integer>(Arrays.asList(777)));

		ArrayList<ArrayList<Integer>> multi3 = new ArrayList<ArrayList<Integer>>();
		multi3.add(new ArrayList<Integer>(Arrays.asList(0, -1)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(-2, 3, -5)));
		multi3.add(new ArrayList<Integer>(Arrays.asList(4, -6, 8, -7, 9)));
		multi3.add(null);
		multi3.add(null);
		multi3.add(null);
		multi3.add(null);
		multi3.add(null);

		ArrayList<ArrayList<Integer>> multi4 = new ArrayList<ArrayList<Integer>>();
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(2, 4, 2, -7, 3, 13, 3, -28)));
		multi4.add(null);
		multi4.add(new ArrayList<Integer>(Arrays.asList(0, -10, 0, 70, 5, -20, 5, 90)));

		assertEquals(0, testObject.countNonNullSublists(multi1));
		assertEquals(1, testObject.countNonNullSublists(multi2));
		assertEquals(3, testObject.countNonNullSublists(multi3));
		assertEquals(2, testObject.countNonNullSublists(multi4));

		ArrayList<ArrayList<Integer>> multi5 = new ArrayList<ArrayList<Integer>>(Arrays.asList(null, null, null, null, null));
		assertEquals(0, testObject.countNonNullSublists(multi5));
	}
}
