package practicePackage.builtInLists.testsAttempts;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ServiceClasses.Rectangle;

public class Stage1Test {
	protected practicePackage.builtInLists.attempts.Stage1 testObject;
	
	public ArrayList<Integer> nullList, emptyList, singleItemList, list1, list2;

	@BeforeEach
	public void run() {
		testObject = new practicePackage.builtInLists.attempts.Stage1();
		nullList = null;
		emptyList = new ArrayList<Integer>();
		singleItemList = new ArrayList<Integer>(Arrays.asList(-7));
		list1 = new ArrayList<Integer>(Arrays.asList(10,70,20,90));
		list2 = new ArrayList<Integer>(Arrays.asList(-5, 0, 8, -7, 9, 15, 23, -1, 5));
	}

	@Test
	void testGetLastItem() {
		assertEquals(null, testObject.getLastItem(nullList));
		assertEquals(null, testObject.getLastItem(emptyList));
		assertEquals((Integer)(-7), testObject.getLastItem(singleItemList));
		assertEquals((Integer)(90), testObject.getLastItem(list1));
		assertEquals((Integer)(5), testObject.getLastItem(list2));
	}

	@Test
	void testGetSumFirstLastItems() {
		assertEquals(null, testObject.getSumFirstLastItems(nullList));
		assertEquals(null, testObject.getSumFirstLastItems(emptyList));
		assertEquals((Integer)(-7), testObject.getSumFirstLastItems(singleItemList));
		assertEquals((Integer)(100), testObject.getSumFirstLastItems(list1));
		assertEquals((Integer)(0), testObject.getSumFirstLastItems(list2));
	}

	@Test
	void testContainsEvenNumberOfItems() {
		assertFalse(testObject.containsEvenNumberOfItems(nullList));
		assertTrue(testObject.containsEvenNumberOfItems(emptyList));
		assertFalse(testObject.containsEvenNumberOfItems(singleItemList));
		assertTrue(testObject.containsEvenNumberOfItems(list1));
		assertFalse(testObject.containsEvenNumberOfItems(list2));
	}

	@Test
	void testSameSize() {
		ArrayList<Integer> list3 = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
		assertTrue(testObject.sameSize(list1, list3));
		list3.add(10); //list3 now contains 5 items
		assertFalse(testObject.sameSize(list1, list3));
		list3.remove(0); //list3 now contains 4 items
		assertTrue(testObject.sameSize(list1, list3));
		list3.remove(0); //list3 now contains 3 items
		assertFalse(testObject.sameSize(list1, list3));
	}

	@Test
	void testMedian() {
		assertEquals(null, testObject.median(nullList));
		assertEquals(null, testObject.median(emptyList));
		assertEquals((Integer)(-7), testObject.median(singleItemList));
		assertEquals((Integer)(70), testObject.median(list1));
		assertEquals((Integer)(9), testObject.median(list2));
	}

	@Test
	void testGetFirstItem() {
		ArrayList<Rectangle> list = null;
		assertNull(testObject.getFirstItem(list));
		list = new ArrayList<Rectangle>();
		assertNull(testObject.getFirstItem(list));
		list.add(new Rectangle(10));
		assertNotNull(testObject.getFirstItem(list));
		assertEquals("10 by 10", testObject.getFirstItem(list).toString());
		list.add(0, new Rectangle(20, 50));
		assertNotNull(testObject.getFirstItem(list));
		assertEquals("20 by 50", testObject.getFirstItem(list).toString());
	}

}
