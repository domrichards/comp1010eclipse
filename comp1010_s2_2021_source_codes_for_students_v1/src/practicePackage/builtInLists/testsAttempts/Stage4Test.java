package practicePackage.builtInLists.testsAttempts;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import practicePackage.builtInLists.attempts.*;

@SuppressWarnings("unused")
public class Stage4Test {
	protected practicePackage.builtInLists.attempts.Stage4 testObject;

	public ArrayList<Integer> nullList, emptyList, singleItemList, list1, list2;

	private ArrayList<Integer> empty;
	private ArrayList<Integer> tenMultiples;
	private ArrayList<Integer> nonNegsShort;
	private ArrayList<Integer> nonNegsLong;
	private ArrayList<Integer> positives;
	private ArrayList<Integer> mixed;
	private ArrayList<Integer> allZeroes;

	@BeforeEach
	public void run() {
		testObject = new practicePackage.builtInLists.attempts.Stage4();
		nullList = null;
		emptyList = new ArrayList<Integer>();
		singleItemList = new ArrayList<Integer>(Arrays.asList(-7));
		list1 = new ArrayList<Integer>(Arrays.asList(10,70,20,90));
		list2 = new ArrayList<Integer>(Arrays.asList(-5, 0, 8, -7, 9, 15, 23, -1, 5));

		empty = new ArrayList<Integer>();
		tenMultiples = new ArrayList<Integer>(Arrays.asList(10, 70, 20, 90));
		nonNegsShort = new ArrayList<Integer>(Arrays.asList(0, 4, 2, 3, 5, 1, 6, 9, 7, 8));
		nonNegsLong = new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 1, 2, 0, 1, 2, 3, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 5));
		positives = new ArrayList<Integer>(Arrays.asList(10, 3, 5, 6, 2));
		mixed = new ArrayList<Integer>(Arrays.asList(0, 10, 3, -2, 5, 2, 1, 12, -1));
		allZeroes = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0));
	}

	@Test
	void testSortArrayListOfInteger() {
		testObject.sort(nullList); //should not raise NullPointerException
		testObject.sort(emptyList);
		assertEquals("[]", emptyList.toString());
		testObject.sort(singleItemList);
		assertEquals("[-7]", singleItemList.toString());
		testObject.sort(list1);
		assertEquals("[10, 20, 70, 90]", list1.toString());
		testObject.sort(list2);
		//-5, 0, 8, -7, 9, 15, 23, -1, 5
		assertEquals("[-7, -5, -1, 0, 5, 8, 9, 15, 23]", list2.toString());
	}

	@Test
	void testSortArrayListOfIntegerBoolean() {
		testObject.sort(nullList, true); //should not raise NullPointerException
		testObject.sort(nullList, false); //should not raise NullPointerException
		testObject.sort(emptyList, false);
		assertEquals("[]", emptyList.toString());
		testObject.sort(emptyList, true);
		assertEquals("[]", emptyList.toString());
		testObject.sort(singleItemList, true);
		assertEquals("[-7]", singleItemList.toString());
		testObject.sort(singleItemList, false);
		assertEquals("[-7]", singleItemList.toString());
		testObject.sort(list1, true);
		assertEquals("[10, 20, 70, 90]", list1.toString());
		testObject.sort(list1, false);
		assertEquals("[90, 70, 20, 10]", list1.toString());
		testObject.sort(list2, true);
		assertEquals("[-7, -5, -1, 0, 5, 8, 9, 15, 23]", list2.toString());
		testObject.sort(list2, false);
		assertEquals("[23, 15, 9, 8, 5, 0, -1, -5, -7]", list2.toString());
	}

	@Test
	void testMerge() {
		ArrayList<Integer> 	merged = testObject.merge(nullList, emptyList);
		assertNull(merged);
		merged = testObject.merge(emptyList, nullList);
		assertNull(merged);
		merged = testObject.merge(nullList, nullList);
		assertNull(merged);
		merged = testObject.merge(emptyList, emptyList);
		assertNotNull(merged);
		assertEquals("[]", merged.toString());
		merged = testObject.merge(emptyList, singleItemList);
		assertNotNull(merged);
		assertEquals("[-7]", merged.toString());
		merged = testObject.merge(singleItemList, emptyList);
		assertNotNull(merged);
		assertEquals("[-7]", merged.toString());

		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(10, 20, 70, 90));
		ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(-7, -5, -1, 0, 5, 8, 9, 15, 23));
		merged = testObject.merge(a, b);

		assertNotNull(merged);
		assertEquals("[-7, -5, -1, 0, 5, 8, 9, 10, 15, 20, 23, 70, 90]", merged.toString());

		//to make sure you don't modify passed lists
		assertEquals("[10, 20, 70, 90]", a.toString());
		assertEquals("[-7, -5, -1, 0, 5, 8, 9, 15, 23]", b.toString());

		merged = testObject.merge(b, a);
		assertNotNull(merged);
		assertEquals("[-7, -5, -1, 0, 5, 8, 9, 10, 15, 20, 23, 70, 90]", merged.toString());
		assertEquals("[10, 20, 70, 90]", a.toString());
		assertEquals("[-7, -5, -1, 0, 5, 8, 9, 15, 23]", b.toString());
	}

	@Test
	void testGetLongestAscendingRun() {
		ArrayList<Integer> result = testObject.getLongestAscendingRun(nullList); //should not raise NullPointerException
		assertNull(result);
		result = testObject.getLongestAscendingRun(emptyList); 
		assertNotNull(result);
		assertEquals("[]", result.toString());
		result = testObject.getLongestAscendingRun(list1); 
		assertNotNull(result);
		assertEquals("[10, 70]", result.toString());
		result = testObject.getLongestAscendingRun(list2); 
		assertNotNull(result);
		assertEquals("[-7, 9, 15, 23]", result.toString());

		list2 = new ArrayList<Integer>(Arrays.asList(-5,-5,0,0,0,0,1,1,1,1,1,10,10,10));
		result = testObject.getLongestAscendingRun(list2); 
		assertNotNull(result);
		assertEquals("[-5, -5, 0, 0, 0, 0, 1, 1, 1, 1, 1, 10, 10, 10]", result.toString());

		list2 = new ArrayList<Integer>(Arrays.asList(10,10,20,30,40,50,50,5,15,10));
		result = testObject.getLongestAscendingRun(list2); 
		assertNotNull(result);
		assertEquals("[10, 10, 20, 30, 40, 50, 50]", result.toString());

		list2 = new ArrayList<Integer>(Arrays.asList(5,4,3,2,1));
		result = testObject.getLongestAscendingRun(list2); 
		assertNotNull(result);
		assertEquals("[5]", result.toString());

		list2 = new ArrayList<Integer>(Arrays.asList(2,2,2,4,4,4,4,4,2,4,4,2,2,2,2,2,2,2,2));
		result = testObject.getLongestAscendingRun(list2); 
		assertNotNull(result);
		assertEquals("[2, 2, 2, 4, 4, 4, 4, 4]", result.toString());
	}

	@Test
	void testNInARow() {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10,10,20,20,10,10,10,20,10,20,20,20,20,20));
		assertTrue(testObject.nInARow(list, 20, 5));
		assertFalse(testObject.nInARow(list, 20, 6));
		assertTrue(testObject.nInARow(list, 10, 3));
		assertFalse(testObject.nInARow(list, 10, 4));
	}

	@Test
	void testGetIntersection() {
		ArrayList<Integer> inter = testObject.getIntersection(nullList, emptyList);
		assertNull(inter);
		inter = testObject.getIntersection(emptyList, nullList);
		assertNull(inter);
		inter = testObject.getIntersection(nullList, nullList);
		assertNull(inter);
		inter = testObject.getIntersection(emptyList, emptyList);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());
		inter = testObject.getIntersection(emptyList, singleItemList);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());
		inter = testObject.getIntersection(singleItemList, emptyList);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());
		inter = testObject.getIntersection(list1, list2);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());
		inter = testObject.getIntersection(list2, list1);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());

		list1 = new ArrayList<Integer>(Arrays.asList(10,10,20,20,70,70,90,90));
		list2 = new ArrayList<Integer>(Arrays.asList(90,90,90,90,20,20,20,20));

		inter = testObject.getIntersection(list1, list2);
		assertNotNull(inter);
		assertEquals("[20, 90]", inter.toString());

		inter = testObject.getIntersection(list2, list1);
		assertNotNull(inter);
		assertEquals("[90, 20]", inter.toString());

		inter = testObject.getIntersection(list1, list1);
		assertNotNull(inter);
		assertEquals("[10, 20, 70, 90]", inter.toString());
	}

	@Test
	void testGetIntersectionV2() {
		ArrayList<Integer> inter = testObject.getIntersection(nullList, emptyList);
		assertNull(inter);
		inter = testObject.getIntersectionV2(emptyList, nullList);
		assertNull(inter);
		inter = testObject.getIntersectionV2(nullList, nullList);
		assertNull(inter);
		inter = testObject.getIntersectionV2(emptyList, emptyList);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());
		inter = testObject.getIntersectionV2(emptyList, singleItemList);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());
		inter = testObject.getIntersectionV2(singleItemList, emptyList);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());
		inter = testObject.getIntersectionV2(list1, list2);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());
		inter = testObject.getIntersectionV2(list2, list1);
		assertNotNull(inter);
		assertEquals("[]", inter.toString());

		list1 = new ArrayList<Integer>(Arrays.asList(10,10,20,20,70,70,90,90));
		list2 = new ArrayList<Integer>(Arrays.asList(90,90,90,90,20,20,20,20));

		inter = testObject.getIntersectionV2(list1, list2);
		assertNotNull(inter);
		assertEquals("[20, 20, 90, 90]", inter.toString());

		inter = testObject.getIntersectionV2(list2, list1);
		assertNotNull(inter);
		assertEquals("[90, 90, 20, 20]", inter.toString());

		inter = testObject.getIntersectionV2(list1, list1);
		assertNotNull(inter);
		assertEquals("[10, 10, 20, 20, 70, 70, 90, 90]", inter.toString());	
	}


	@Test
	void testItemsInAtleastN() {
		ArrayList<Integer> result = testObject.itemsInAtleastN(null, 2);
		assertNull(result);

		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list.add(null);
		list.add(null);
		list.add(null);

		result = testObject.itemsInAtleastN(list, 3);
		assertNotNull(result);
		assertEquals("[]", result.toString());

		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(4,5,6,7,8));
		ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(3,5,7,6));
		list = new ArrayList<ArrayList<Integer>>();
		list.add(a);
		list.add(b);
		list.add(c);
		result = testObject.itemsInAtleastN(list, 2);
		assertNotNull(result);
		assertEquals("[3, 4, 5, 6, 7]", result.toString());

		result = testObject.itemsInAtleastN(list, 3);
		assertNotNull(result);
		assertEquals("[5]", result.toString());

		ArrayList<Integer> d = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
		ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(4,6,7,8));
		ArrayList<Integer> f = new ArrayList<Integer>(Arrays.asList(3,5,7,6,4));

		list = new ArrayList<ArrayList<Integer>>();
		list.add(d);
		list.add(e);
		list.add(f);

		result = testObject.itemsInAtleastN(list, 3);
		assertNotNull(result);
		assertEquals("[4, 6]", result.toString());
	}

	@Test
	void testProductAllButOne() {
		assertNotNull(testObject.productAllButOne(empty));
		assertEquals(0, testObject.productAllButOne(empty).size());
		assertEquals("[1]", testObject.productAllButOne(singleItemList).toString());
		assertEquals("[126000, 18000, 63000, 14000]", testObject.productAllButOne(tenMultiples).toString());
		assertEquals("[362880, 0, 0, 0, 0, 0, 0, 0, 0, 0]", testObject.productAllButOne(nonNegsShort).toString());
		assertEquals("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]", testObject.productAllButOne(nonNegsLong).toString());
		assertEquals("[180, 600, 360, 300, 900]", testObject.productAllButOne(positives).toString());
		assertEquals("[7200, 0, 0, 0, 0, 0, 0, 0, 0]", testObject.productAllButOne(mixed).toString());
		assertEquals(allZeroes.toString(), testObject.productAllButOne(allZeroes).toString());
	}

	@Test
	void testGetLongestAscendingSequence() {
		assertNotNull(testObject.getLongestAscendingSequence(empty));
		assertEquals(0, testObject.getLongestAscendingSequence(empty).size());
		assertEquals("[-7]", testObject.getLongestAscendingSequence(singleItemList).toString());
		assertEquals("[10, 70]", testObject.getLongestAscendingSequence(tenMultiples).toString());
		assertEquals("[2, 3, 5]", testObject.getLongestAscendingSequence(nonNegsShort).toString());
		assertEquals("[0, 1, 2, 3, 4, 5]", testObject.getLongestAscendingSequence(nonNegsLong).toString());
		assertEquals("[3, 5, 6]", testObject.getLongestAscendingSequence(positives).toString());
		assertEquals("[0, 10]", testObject.getLongestAscendingSequence(mixed).toString());
		assertEquals("[0, 0, 0, 0, 0]", testObject.getLongestAscendingSequence(allZeroes).toString());
	}

	@Test
	void testGetLongestDescendingSequence() {
		assertNotNull(testObject.getLongestDescendingSequence(empty));
		assertEquals(0, testObject.getLongestDescendingSequence(empty).size());
		assertEquals("[-7]", testObject.getLongestDescendingSequence(singleItemList).toString());
		assertEquals("[70, 20]", testObject.getLongestDescendingSequence(tenMultiples).toString());
		assertEquals("[4, 2]", testObject.getLongestDescendingSequence(nonNegsShort).toString());
		assertEquals("[0, 0]", testObject.getLongestDescendingSequence(nonNegsLong).toString());
		assertEquals("[10, 3]", testObject.getLongestDescendingSequence(positives).toString());
		assertEquals("[10, 3, -2]", testObject.getLongestDescendingSequence(mixed).toString());
		assertEquals("[0, 0, 0, 0, 0]", testObject.getLongestDescendingSequence(allZeroes).toString());
	}

	@Test
	void testGetLongestUnchangedSequence() {
		assertNotNull(testObject.getLongestUnchangedSequence(empty));
		assertEquals(0, testObject.getLongestUnchangedSequence(empty).size());
		assertEquals("[-7]", testObject.getLongestUnchangedSequence(singleItemList).toString());
		assertEquals("[10]", testObject.getLongestUnchangedSequence(tenMultiples).toString());
		assertEquals("[2, 2, 2]", testObject.getLongestUnchangedSequence(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3))).toString());
		assertEquals("[3, 3, 3, 3, 3]", testObject.getLongestUnchangedSequence(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3, 3, 3, 3, 3))).toString());
		assertEquals("[5, 5, 5, 5, 5, 5, 5, 5]", testObject.getLongestUnchangedSequence(new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3, 3, 3, 3, 3, 2, 3, 3, 5, 5, 5, 5, 5, 5, 5, 5))).toString());
		assertEquals("[0, 0, 0, 0, 0]", testObject.getLongestUnchangedSequence(allZeroes).toString());
	}

	@Test
	void testGetCommonItemsSorted() {
		//First sort all the arrays
		Collections.sort(tenMultiples);
		Collections.sort(nonNegsShort);
		Collections.sort(nonNegsLong);
		Collections.sort(positives);
		Collections.sort(mixed);
		Collections.sort(allZeroes);

		assertNotNull(testObject.getCommonItemsSorted(tenMultiples, nonNegsShort));
		assertEquals(0, testObject.getCommonItemsSorted(tenMultiples, nonNegsShort).size()); //no items in common

		assertEquals("[0, 1, 2, 3, 4, 5]", testObject.getCommonItemsSorted(nonNegsShort, nonNegsLong).toString()); //some items in common

		assertEquals("[2, 3, 5, 6, 10]", testObject.getCommonItemsSorted(positives, positives).toString()); //all items in common

		assertEquals("[0]", testObject.getCommonItemsSorted(mixed, allZeroes).toString()); //only 1 item in common

		assertEquals("[0, 0]", testObject.getCommonItemsSorted(new ArrayList<Integer>(Arrays.asList(0, 0)), new ArrayList<Integer>(Arrays.asList(0, 0, 0))).toString());
	}

	@Test
	void testSortAsc() {
		testObject.sortAsc(null); //NullPointerException check
		testObject.sortAsc(empty);
		assertEquals("[]", empty.toString());
		testObject.sortAsc(singleItemList);
		assertEquals("[-7]", singleItemList.toString());
		testObject.sortAsc(tenMultiples);
		assertEquals("[10, 20, 70, 90]", tenMultiples.toString());
		testObject.sortAsc(nonNegsShort);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", nonNegsShort.toString());
		testObject.sortAsc(nonNegsLong);
		assertEquals("[0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5]", nonNegsLong.toString());
		testObject.sortAsc(positives);
		assertEquals("[2, 3, 5, 6, 10]", positives.toString());
		testObject.sortAsc(mixed);
		assertEquals("[-2, -1, 0, 1, 2, 3, 5, 10, 12]", mixed.toString());
		testObject.sortAsc(allZeroes);
		assertEquals("[0, 0, 0, 0, 0]", allZeroes.toString());
	}

	@Test
	void testSortDesc() {
		testObject.sortDesc(null); //NullPointerException check
		testObject.sortDesc(empty);
		assertEquals("[]", empty.toString());
		testObject.sortDesc(singleItemList);
		assertEquals("[-7]", singleItemList.toString());
		testObject.sortDesc(tenMultiples);
		assertEquals("[90, 70, 20, 10]", tenMultiples.toString());
		testObject.sortDesc(nonNegsShort);
		assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", nonNegsShort.toString());
		testObject.sortDesc(nonNegsLong);
		assertEquals("[5, 4, 4, 3, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0]", nonNegsLong.toString());
		testObject.sortDesc(positives);
		assertEquals("[10, 6, 5, 3, 2]", positives.toString());
		testObject.sortDesc(mixed);
		assertEquals("[12, 10, 5, 3, 2, 1, 0, -1, -2]", mixed.toString());
		testObject.sortDesc(allZeroes);
		assertEquals("[0, 0, 0, 0, 0]", allZeroes.toString());
	}

	@Test
	void testSort() {
		testObject.sort(null, true); //NullPointerException check
		testObject.sort(null, false); //NullPointerException check
		testObject.sort(empty, true);
		assertEquals(0, empty.size());
		testObject.sort(singleItemList, false);
		assertEquals("[-7]", singleItemList.toString());
		testObject.sort(tenMultiples, true);
		assertEquals("[10, 20, 70, 90]", tenMultiples.toString());
		testObject.sort(nonNegsShort, false);
		assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", nonNegsShort.toString());
		testObject.sort(nonNegsLong, true);
		assertEquals("[0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5]", nonNegsLong.toString());
		testObject.sort(positives, false);
		assertEquals("[10, 6, 5, 3, 2]", positives.toString());
		testObject.sort(mixed, true);
		assertEquals("[-2, -1, 0, 1, 2, 3, 5, 10, 12]", mixed.toString());
		testObject.sort(allZeroes, false);
		assertEquals("[0, 0, 0, 0, 0]", allZeroes.toString());
	}

	@Test
	void testSortIfNeeded() {
		testObject.sortIfNeeded(null, true); //NullPointerException check
		testObject.sortIfNeeded(null, false); //NullPointerException check
		testObject.sortIfNeeded(empty, true);
		assertEquals(0, empty.size());
		testObject.sortIfNeeded(singleItemList, false);
		assertEquals("[-7]", singleItemList.toString());
		testObject.sortIfNeeded(tenMultiples, true);
		assertEquals("[10, 20, 70, 90]", tenMultiples.toString());
		testObject.sortIfNeeded(nonNegsShort, false);
		assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", nonNegsShort.toString());
		testObject.sortIfNeeded(nonNegsLong, true);
		assertEquals("[0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5]", nonNegsLong.toString());
		testObject.sortIfNeeded(positives, false);
		assertEquals("[10, 6, 5, 3, 2]", positives.toString());
		testObject.sortIfNeeded(mixed, true);
		assertEquals("[-2, -1, 0, 1, 2, 3, 5, 10, 12]", mixed.toString());
		testObject.sortIfNeeded(allZeroes, false);
		assertEquals("[0, 0, 0, 0, 0]", allZeroes.toString());

		ArrayList<Integer> buggy1 = new ArrayList<Integer>(Arrays.asList(4, 7, 13, 28));
		testObject.sortIfNeeded(buggy1, false);
		assertNotEquals("[28, 13, 7, 4]", buggy1.toString());
		assertEquals("[4, 7, 13, 28]", buggy1.toString());

		ArrayList<Integer> buggy2 = new ArrayList<Integer>(Arrays.asList(235, 96, 69, 35, 23));
		testObject.sortIfNeeded(buggy2, true);
		assertNotEquals("[23, 35, 69, 96, 235]", buggy2.toString());
		assertEquals("[235, 96, 69, 35, 23]", buggy2.toString());
	}

	@Test
	void testReverseSort() {
		testObject.reverseSort(null); //NullPointerException check
		testObject.reverseSort(empty);
		assertEquals(0, empty.size());
		testObject.reverseSort(singleItemList);
		assertEquals("[-7]", singleItemList.toString());
		testObject.reverseSort(tenMultiples);
		assertNotEquals("[10, 20, 70, 90]", tenMultiples.toString());
		assertNotEquals("[90, 70, 20, 10]", tenMultiples.toString());
		assertEquals("[10, 70, 20, 90]", tenMultiples.toString());

		ArrayList<Integer> asc = new ArrayList<Integer>(Arrays.asList(23, 35, 69, 96, 235));
		testObject.reverseSort(asc);
		assertEquals("[235, 96, 69, 35, 23]", asc.toString());

		ArrayList<Integer> desc = new ArrayList<Integer>(Arrays.asList(28, 13, 7, 4));
		testObject.reverseSort(desc);
		assertEquals("[4, 7, 13, 28]", desc.toString());
	}

	@Test
	void testGetCommonItemsUnsorted() {
		assertNotNull(testObject.getCommonItemsUnsorted(tenMultiples, nonNegsShort)); 
		assertEquals(0, testObject.getCommonItemsUnsorted(tenMultiples, nonNegsShort).size()); //no items in common
		assertEquals("[0, 4, 2, 3, 5, 1]", testObject.getCommonItemsUnsorted(nonNegsShort, nonNegsLong).toString()); //some items in common
		assertEquals("[10, 3, 5, 6, 2]", testObject.getCommonItemsUnsorted(positives, positives).toString()); //all items in common
		assertEquals("[0]", testObject.getCommonItemsUnsorted(mixed, allZeroes).toString()); //only 1 item in common
		assertEquals("[1, 1, 1, 0, 0]", testObject.getCommonItemsUnsorted(new ArrayList<Integer> (Arrays.asList(2, 1, 0, 1, 0, 1, 1, 1, 3)), new ArrayList<Integer> (Arrays.asList(5, 0, 1, 1, 0, 0, 0, 0, 1, 6))).toString()); 
	}

	@Test
	void testNoCommonItems() {
		assertTrue(testObject.noCommonItems(new ArrayList<ArrayList<Integer>>(Arrays.asList(empty, singleItemList))));
		assertTrue(testObject.noCommonItems(new ArrayList<ArrayList<Integer>>(Arrays.asList(tenMultiples, nonNegsShort))));
		assertFalse(testObject.noCommonItems(new ArrayList<ArrayList<Integer>>(Arrays.asList(nonNegsLong, positives))));
		assertFalse(testObject.noCommonItems(new ArrayList<ArrayList<Integer>>(Arrays.asList(mixed, allZeroes))));
		assertFalse(testObject.noCommonItems(new ArrayList<ArrayList<Integer>>(Arrays.asList(tenMultiples, nonNegsShort, nonNegsLong))));
		assertFalse(testObject.noCommonItems(new ArrayList<ArrayList<Integer>>(Arrays.asList(positives, mixed, allZeroes))));

		ArrayList<Integer> w = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		ArrayList<Integer> x = new ArrayList<Integer>(Arrays.asList(5,6,7,8));
		ArrayList<Integer> y = new ArrayList<Integer>(Arrays.asList(9,10,11,12));
		ArrayList<Integer> z = new ArrayList<Integer>(Arrays.asList(13,14,15,16));
		assertTrue(testObject.noCommonItems(new ArrayList<ArrayList<Integer>>(Arrays.asList(w, x, y, z))));

		x = null;
		assertTrue(testObject.noCommonItems(new ArrayList<ArrayList<Integer>>(Arrays.asList(w, x, y, z)))); 

		z.set(3, 10);
		assertFalse(testObject.noCommonItems(new ArrayList<ArrayList<Integer>>(Arrays.asList(w, x, y, z)))); //because y and z have 10 in common
	}

	@Test
	void testLongestMirroredSequence() {
		assertNotNull(testObject.longestMirroredSequence(singleItemList));
		assertEquals("[-7]", testObject.longestMirroredSequence(singleItemList).toString());
		assertEquals("[20, 30, 40]", testObject.longestMirroredSequence(new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50, 20, 10, 40, 30, 20, 50, 40))).toString());
		assertEquals("[1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1]", testObject.longestMirroredSequence(new ArrayList<Integer>(Arrays.asList(1,2,1,2,1,2,1,2,1,2,1,2))).toString());
		assertEquals("[1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1]", testObject.longestMirroredSequence(new ArrayList<Integer>(Arrays.asList(1,2,1,2,1,2,1,2,1,2,1,2,1))).toString());
		assertEquals("[5]", testObject.longestMirroredSequence(new ArrayList<Integer>(Arrays.asList(5,6,7,8,9))).toString());
		assertEquals("[6, 7, 5, 7, 6]", testObject.longestMirroredSequence(new ArrayList<Integer>(Arrays.asList(5,6,7,5,7,6,8,5,6,9))).toString());
		assertEquals("[10]", testObject.longestMirroredSequence(tenMultiples).toString());
	}

	@Test
	void testGetSet() {
		assertNotNull(testObject.getSet(singleItemList));
		assertEquals("[-7]", testObject.getSet(singleItemList).toString());
		assertNotNull(testObject.getSet(nonNegsLong));
		assertEquals("[0, 1, 2, 3, 4, 5]", testObject.getSet(nonNegsLong).toString());
		assertNotNull(testObject.getSet(nonNegsShort));
		assertEquals("[0, 4, 2, 3, 5, 1, 6, 9, 7, 8]", testObject.getSet(nonNegsShort).toString());
	}
	
	@Test
	void testBestTotalSubLists() {
		ArrayList<Integer> data = new ArrayList<Integer>(Arrays.asList(6,4,6,1,1,1,1,1,1,1,3,1,2,5,6,5,1,1,3,2,1,1,4,4,4,4,4,4,4,4,4,1,1,1,1,1,1,1,1,1,10,4,2));
		ArrayList<ArrayList<Integer>> result = testObject.bestTotalSubLists(data, 3);
		System.out.println(result);
		assertEquals(3, result.size());
		assertEquals("[[6, 4, 6], [5, 6, 5], [10, 4, 2]]" , result.toString());
		result = testObject.bestTotalSubLists(data, 8);
		assertEquals(2, result.size());
		assertEquals("[[4, 4, 4, 4, 4, 4, 4, 4], [4, 4, 4, 4, 4, 4, 4, 4]]" , result.toString());
	}
	
	@Test
	public void testGetAllItemsFrom() {
		assertEquals("[4, 4, 4, 5, 5, 1, 1]", testObject.getAllItemsFrom(new ArrayList<Integer>(Arrays.asList(7,4,1,1,3,4,5,5,6,3,7,4)), new ArrayList<Integer>(Arrays.asList(4,5,1))).toString());
		assertEquals("[]", testObject.getAllItemsFrom(new ArrayList<Integer>(Arrays.asList(7,4,1,1,3,4,5,5,6,3,7,4)), new ArrayList<Integer>(Arrays.asList(2, 8, 9))).toString());
		assertEquals("[50, 50, 50]", testObject.getAllItemsFrom(new ArrayList<Integer>(Arrays.asList(10,100000,50,1000000,50,50000000,50)), new ArrayList<Integer>(Arrays.asList(50))).toString());
		assertEquals("[10, 20, 30, 50, -70000000, -70000000]", testObject.getAllItemsFrom(new ArrayList<Integer>(Arrays.asList(50,-70000000,10,20,30,-70000000)), new ArrayList<Integer>(Arrays.asList(10,20,30,40,50,-70000000))).toString());
	}
}
