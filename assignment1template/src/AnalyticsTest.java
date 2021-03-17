import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnalyticsTest {
	public static double score = 0;
	public static String result = "";
	public static String currentMethodName = null;
	public static ArrayList<String> methodsPassed = new ArrayList<String>();
		
	Analytics aP, aCR, aD, aHD, aEmpty;
	
	@BeforeEach
	public void setUp() throws Exception {
		currentMethodName = null;
		
		aP = new Analytics(new int[][]{{30, 10, 40},
            {50, 20, 80},
            {10, 60, 30},
            {60, 60, 60}});
            
        aCR = new Analytics(new int[][]{{-30, 10, -40},
            {-50, 20, 0},
            {-10, 60, 30},
            {-60, 60, 60},
            {-20, -20, -20}});

        aD = new Analytics(new int[][]{{-30, 10, -40},
            {},
            {-10, 60},
            {-60},
            {-20, -20, -20, -20, -20},
            {-20, -20, -20, -20, -20},
            {-20, -20, -20, -20, -20},
            {-20, -20, -20, -20, -20},
            {-20, -20, -20, -20, -20},
            {-20, -20, -20, -20, -20},
            {-20, -20, -20, -20, -20}});

        aHD = new Analytics(new int[][]{{-30, 10, -40},
            {},
            {-10, 60},
            {-60},
            {-20, -20, -20, -20, -20},
            {-20, -20},
            {-20},
            {},
            {50},
            {10, 30, 20}});
        
        /**
         * note that i WILL add a couple more sets of test data in the actual marking:
         * 
         * FOR EXAMPLE:
         * 
         * aLong = new Analytics(new int[][]{{10,20,30,40,50,60,70,80,90,100,110,120,130},
         * 									 {-10,-20,-30,-40,-50,-60,-70,-80,-90,-100,-110,-120,-130}});
         * 
         * Thus (in this example), anyone who coded for at most 5 items in any sub-array will fail
         * the additional test. Make sure you program for arbitrary-sized data sets.
         */
		
        aEmpty = new Analytics(new int[][] {});
		
	}

	@Test @Order(1) @Graded(description="testSizeP", marks=2.5)
	public void testSizeP() {
		assertEquals(4, aP.size());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(2) @Graded(description="testSizeCR", marks=2.5)
	public void testSizeCR() {
		testSizeP();
		assertEquals(4, aP.size());
		assertEquals(5, aCR.size());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(3) @Graded(description="testSizeD", marks=2.5)
	public void testSizeD() {
		testSizeCR();
		assertEquals(4, aP.size());
		assertEquals(5, aCR.size());
		assertEquals(11, aD.size());
		assertEquals(0, aEmpty.size());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(4) @Graded(description="testSizeHD", marks=2.5)
	public void testSizeHD() {
		testSizeD();
		assertEquals(4, aP.size());
		assertEquals(5, aCR.size());
		assertEquals(11, aD.size());
		assertEquals(0, aEmpty.size());
		assertEquals(10, aHD.size());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(5) @Graded(description="testIsValidSubsetIndexP", marks=2.5)
	public void testIsValidSubsetIndexP() {
		assertFalse(aP.isValidSubsetIndex(-1));
		assertFalse(aP.isValidSubsetIndex((int)(Math.random()*-1000)));
		assertFalse(aP.isValidSubsetIndex(4));
		assertFalse(aP.isValidSubsetIndex(4 + (int)(Math.random()*1000)));
		for(int i=0; i < 4; i++) {
			assertTrue(aP.isValidSubsetIndex(i));
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(6) @Graded(description="testIsValidSubsetIndexCR", marks=2.5)
	public void testIsValidSubsetIndexCR() {
		testIsValidSubsetIndexP();
		assertFalse(aCR.isValidSubsetIndex(-1));
		assertFalse(aCR.isValidSubsetIndex((int)(Math.random()*-1000)));
		assertFalse(aCR.isValidSubsetIndex(5));
		assertFalse(aCR.isValidSubsetIndex(5 + (int)(Math.random()*1000)));
		for(int i=0; i < 5; i++) {
			assertTrue(aCR.isValidSubsetIndex(i));
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(7) @Graded(description="testIsValidSubsetIndexD", marks=2.5)
	public void testIsValidSubsetIndexD() {
		testIsValidSubsetIndexCR();
		assertFalse(aD.isValidSubsetIndex(-1));
		assertFalse(aD.isValidSubsetIndex((int)(Math.random()*-1000)));
		assertFalse(aD.isValidSubsetIndex(11));
		assertFalse(aD.isValidSubsetIndex(11 + (int)(Math.random()*1000)));
		for(int i=0; i < 11; i++) {
			assertTrue(aD.isValidSubsetIndex(i));
		}
		
		assertFalse(aEmpty.isValidSubsetIndex(-1));
		assertFalse(aEmpty.isValidSubsetIndex(0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(8) @Graded(description="testIsValidSubsetIndexHD", marks=2.5)
	public void testIsValidSubsetIndexHD() {
		testIsValidSubsetIndexD();
		assertFalse(aHD.isValidSubsetIndex(-1));
		assertFalse(aHD.isValidSubsetIndex((int)(Math.random()*-1000)));
		assertFalse(aHD.isValidSubsetIndex(10));
		assertFalse(aHD.isValidSubsetIndex(10 + (int)(Math.random()*1000)));
		for(int i=0; i < 10; i++) {
			assertTrue(aHD.isValidSubsetIndex(i));
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(9) @Graded(description="testItemExistsAtP", marks=2.5)
	public void testItemExistsAtP() {
		assertFalse(aP.itemExistsAt(-1, 0));
		assertFalse(aP.itemExistsAt(0, -1));
		for(int i=0; i < 3; i++) {
			assertTrue(aP.itemExistsAt(i, 0));
			assertTrue(aP.itemExistsAt(i, 1));
			assertTrue(aP.itemExistsAt(i, 2));
		}
		assertFalse(aP.itemExistsAt(4, 0));
		assertFalse(aP.itemExistsAt(0, 3));
		assertFalse(aP.itemExistsAt(0, 3 + (int)(Math.random()*1000)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(10) @Graded(description="testItemExistsAtCR", marks=2.5)
	public void testItemExistsAtCR() {
		testItemExistsAtP();
		assertFalse(aCR.itemExistsAt(-1, 0));
		assertFalse(aCR.itemExistsAt(0, -1));
		for(int i=0; i < 4; i++) {
			assertTrue(aCR.itemExistsAt(i, 0));
			assertTrue(aCR.itemExistsAt(i, 1));
			assertTrue(aCR.itemExistsAt(i, 2));
		}
		assertFalse(aCR.itemExistsAt(5, 0));
		assertFalse(aCR.itemExistsAt(0, 4));
		assertFalse(aCR.itemExistsAt(0, 4 + (int)(Math.random()*1000)));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(11) @Graded(description="testItemExistsAtD", marks=2.5)
	public void testItemExistsAtD() {
		testItemExistsAtCR();
		assertFalse(aD.itemExistsAt(-1, 0));
		assertFalse(aD.itemExistsAt(0, -1));
		for(int i=0; i < 11; i++) {
			for(int k=0; k < aD.data[i].length; k++) {
				assertTrue(aD.itemExistsAt(i, k));
			}
			for(int k=aD.data[i].length; k < 20; k++) {
				assertFalse(aD.itemExistsAt(i, k));
			}
		}
		assertFalse(aD.itemExistsAt(11, 0));
		assertFalse(aEmpty.itemExistsAt(10, 0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(12) @Graded(description="testItemExistsAtHD", marks=2.5)
	public void testItemExistsAtHD() {
		testItemExistsAtD();
		assertFalse(aHD.itemExistsAt(-1, 0));
		assertFalse(aHD.itemExistsAt(0, -1));
		for(int i=0; i < 10; i++) {
			for(int k=0; k < aHD.data[i].length; k++) {
				assertTrue(aHD.itemExistsAt(i, k));
			}
			for(int k=aHD.data[i].length; k < 20; k++) {
				assertFalse(aHD.itemExistsAt(i, k));
			}
		}
		assertFalse(aHD.itemExistsAt(10, 0));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(13) @Graded(description="testSubsetSizeP", marks=2.5)
	public void testSubsetSizeP() {
		assertEquals(0, aP.subsetSize(-1));
        assertEquals(0, aP.subsetSize(4));
		int[] pSize = {3, 3, 3, 3};
		for(int i=0; i < pSize.length; i++) {
			assertEquals(pSize[i], aP.subsetSize(i));
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(14) @Graded(description="testSubsetSizeCR", marks=2.5)
	public void testSubsetSizeCR() {
		testSubsetSizeP();
		assertEquals(0, aCR.subsetSize(-1));
        assertEquals(0, aCR.subsetSize(5));
		int[] crSize = {3, 3, 3, 3, 3};
		for(int i=0; i < crSize.length; i++) {
			assertEquals(crSize[i], aCR.subsetSize(i));
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(15) @Graded(description="testSubsetSizeD", marks=2.5)
	public void testSubsetSizeD() {
		testSubsetSizeCR();
		assertEquals(0, aD.subsetSize(-1));
        assertEquals(0, aD.subsetSize(11));
		int[] dSize = {3, 0, 2, 1, 5, 5, 5, 5, 5, 5, 5};
		for(int i=0; i < dSize.length; i++) {
			assertEquals(dSize[i], aD.subsetSize(i));
		}
		
		assertEquals(0, aEmpty.subsetSize(-1));
        assertEquals(0, aEmpty.subsetSize(0));
        assertEquals(0, aEmpty.subsetSize(1));		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}


	@Test @Order(16) @Graded(description="testSubsetSizeHD", marks=2.5)
	public void testSubsetSizeHD() {
		testSubsetSizeD();
		assertEquals(0, aHD.subsetSize(-1));
        assertEquals(0, aHD.subsetSize(10));
		int[] hdSize = {3, 0, 2, 1, 5, 2, 1, 0, 1, 3};
		for(int i=0; i < hdSize.length; i++) {
			assertEquals(hdSize[i], aHD.subsetSize(i));
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(17) @Graded(description="testSumP", marks=2.5)
	public void testSumP() {
		assertEquals(80, aP.sum(0));
		assertEquals(150, aP.sum(1));
		assertEquals(100, aP.sum(2));
		assertEquals(180, aP.sum(3));
		assertEquals(0, aP.sum(-1));
		assertEquals(0, aP.sum(4));
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(18) @Graded(description="testSumCR", marks=2.5)
	public void testSumCR() {
		testSumP();
		assertEquals(-60, aCR.sum(0));
		assertEquals(-30, aCR.sum(1));
		assertEquals(80, aCR.sum(2));
		assertEquals(60, aCR.sum(3));
		assertEquals(-60, aCR.sum(4));
		assertEquals(0, aCR.sum(-1));
		assertEquals(0, aCR.sum(5));
		  
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	
	@Test @Order(19) @Graded(description="testSumD", marks=2.5)
	public void testSumD() {
		testSumCR();   
        int[] sumD = {-60, 0, 50, -60, -100, -100, -100, -100, -100, -100, -100};
        for(int i=0; i < sumD.length; i++) {
        	assertEquals(sumD[i], aD.sum(i));
        }
        assertEquals(0, aD.sum(-1));
		assertEquals(0, aD.sum(11));
		
		for(int i=-100; i<=100; i++) {
			assertEquals(0, aEmpty.sum(i));
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(20) @Graded(description="testSumHD", marks=2.5)
	public void testSumHD() {
		testSumD();
        int[] sumHD = {-60, 0, 50, -60, -100, -40, -20, 0, 50, 60};
        
        for(int i=0; i < sumHD.length; i++) {
        	assertEquals(sumHD[i], aHD.sum(i));
        }
        assertEquals(0, aHD.sum(-1));
		assertEquals(0, aHD.sum(10));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(21) @Graded(description="testSubsetAverageP", marks=2.5)
	public void testSubsetAverageP() {
		assertEquals(80/3.0, aP.subsetAverage(0), 0.001);
		assertEquals(150/3.0, aP.subsetAverage(1), 0.001);
		assertEquals(100/3.0, aP.subsetAverage(2), 0.001);
		assertEquals(180/3.0, aP.subsetAverage(3), 0.001);
		assertEquals(0, aP.subsetAverage(-1), 0.001);
		assertEquals(0, aP.subsetAverage(4), 0.001);
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(22) @Graded(description="testSubsetAverageCR", marks=2.5)
	public void testSubsetAverageCR() {
		testSubsetAverageP();
		
		assertEquals(-60/3.0, aCR.subsetAverage(0), 0.001);
		assertEquals(-30/3.0, aCR.subsetAverage(1), 0.001);
		assertEquals(80/3.0, aCR.subsetAverage(2), 0.001);
		assertEquals(60/3.0, aCR.subsetAverage(3), 0.001);
		assertEquals(-60/3.0, aCR.subsetAverage(4), 0.001);
		assertEquals(0, aCR.subsetAverage(-1), 0.001);
		assertEquals(0, aCR.subsetAverage(5), 0.001);
		  
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(23) @Graded(description="testSubsetAverageD", marks=2.5)
	public void testSubsetAverageD() {
		testSubsetAverageCR();   
        double[] averageD = {-20, 0, 25, -60, -20, -20, -20, -20, -20, -20, -20};
        for(int i=0; i < averageD.length; i++) {
        	assertEquals(averageD[i], aD.subsetAverage(i), 0.001);
        }
        assertEquals(0, aD.subsetAverage(-1), 0.001);
		assertEquals(0, aD.subsetAverage(11), 0.001);
		
		for(int i=-100; i<=100; i++) {
			assertEquals(0, aEmpty.subsetAverage(i), 0.001);
		}
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(24) @Graded(description="testSubsetAverageHD", marks=2.5)
	public void testSubsetAverageHD() {
		testSubsetAverageD();
        
		double[] averageHD = {-20, 0, 25, -60, -20, -20, -20, 0, 50, 20};
        
        for(int i=0; i < averageHD.length; i++) {
        	assertEquals(averageHD[i], aHD.subsetAverage(i), 0.001);
        }
        assertEquals(0, aHD.subsetAverage(-1), 0.001);
		assertEquals(0, aHD.subsetAverage(10), 0.001);

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(25) @Graded(description="testSubsetMaxP", marks=2.5)
	public void testSubsetMaxP() {
		assertEquals(0, aP.subsetMax(-1));
		assertEquals(0, aP.subsetMax(4));
		assertEquals(40, aP.subsetMax(0));
		assertEquals(80, aP.subsetMax(1));
		assertEquals(60, aP.subsetMax(2));
		assertEquals(60, aP.subsetMax(3));
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}	

	@Test @Order(26) @Graded(description="testSubsetMaxCR", marks=2.5)
	public void testSubsetMaxCR() {
		testSubsetMaxP();
		assertEquals(0, aCR.subsetMax(-1));
		assertEquals(0, aCR.subsetMax(5));
		assertEquals(10, aCR.subsetMax(0));
		assertEquals(20, aCR.subsetMax(1));
		assertEquals(60, aCR.subsetMax(2));
		assertEquals(60, aCR.subsetMax(3));
		assertEquals(-20, aCR.subsetMax(4));

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}	
	
	@Test @Order(27) @Graded(description="testSubsetMaxD", marks=2.5)
	public void testSubsetMaxD() {
		testSubsetMaxCR();
		int[] maxD = {10, 0, 60, -60, -20, -20, -20, -20, -20, -20};
		
		for(int i=0; i < maxD.length; i++) {
			assertEquals(maxD[i], aD.subsetMax(i));
		}
		
		for(int i=-100; i < 0; i++) {
			assertEquals(0, aD.subsetMax(i));
		}
		
		for(int i=aD.data.length; i < aD.data.length + 100; i++) {
			assertEquals(0, aD.subsetMax(i));
		}
		
		for(int i=-100; i<=100; i++) {
			assertEquals(0, aEmpty.subsetMax(i));
		}

		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}	
	
	@Test @Order(28) @Graded(description="testSubsetMaxHD", marks=2.5)
	public void testSubsetMaxHD() {
		testSubsetMaxD();
		int[] maxHD = {10, 0, 60, -60, -20, -20, -20, 0, 50, 30};
		
		for(int i=0; i < maxHD.length; i++) {
			assertEquals(maxHD[i], aHD.subsetMax(i));
		}
		
		for(int i=-100; i < 0; i++) {
			assertEquals(0, aHD.subsetMax(i));
		}
		
		for(int i=aHD.data.length; i < aHD.data.length + 100; i++) {
			assertEquals(0, aHD.subsetMax(i));
		}
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(29) @Graded(description="testMaxForRoundP", marks=2.5)
	public void testMaxForRoundP() {
		assertEquals(0, aP.maxForRound(-1));
		assertEquals(0, aP.maxForRound(3));
		assertEquals(60, aP.maxForRound(0));
		assertEquals(60, aP.maxForRound(1));
		assertEquals(80, aP.maxForRound(2));
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	
	@Test @Order(30) @Graded(description="testMaxForRoundCR", marks=2.5)
	public void testMaxForRoundCR() {
		testMaxForRoundP();
		assertEquals(0, aCR.maxForRound(-1));
		assertEquals(0, aCR.maxForRound(3));
		assertEquals(-10, aCR.maxForRound(0));
		assertEquals(60, aCR.maxForRound(1));
		assertEquals(60, aCR.maxForRound(2));
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(31) @Graded(description="testMaxForRoundD", marks=2.5)
	public void testMaxForRoundD() {
		testMaxForRoundCR();
		assertEquals(0, aD.maxForRound(-1));
		assertEquals(0, aD.maxForRound(5));
		assertEquals(-10, aD.maxForRound(0));
		assertEquals(60, aD.maxForRound(1));
		assertEquals(-20, aD.maxForRound(2));
		assertEquals(-20, aD.maxForRound(3));
		assertEquals(-20, aD.maxForRound(4));
		
		
		for(int i=-100; i<=100; i++) {
			assertEquals(0, aEmpty.maxForRound(i));
		}
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}


	@Test @Order(32) @Graded(description="testMaxForRoundHD", marks=2.5)
	public void testMaxForRoundHD() {
		testMaxForRoundD();
		assertEquals(0, aHD.maxForRound(-1));
		assertEquals(0, aHD.maxForRound(5));
		assertEquals(50, aHD.maxForRound(0));
		assertEquals(60, aHD.maxForRound(1));
		assertEquals(20, aHD.maxForRound(2));
		assertEquals(-20, aHD.maxForRound(3));
		assertEquals(-20, aHD.maxForRound(4));
		
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(33) @Graded(description="testOverallMaxP", marks=2.5)
	public void testOverallMaxP() {
		assertEquals(80, aP.overallMax());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(34) @Graded(description="testOverallMaxCR", marks=2.5)
	public void testOverallMaxCR() {
		testOverallMaxP();
		assertEquals(60, aCR.overallMax());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(35) @Graded(description="testOverallMaxD", marks=2.5)
	public void testOverallMaxD() {
		testOverallMaxCR();
		assertEquals(60, aD.overallMax());
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(36) @Graded(description="testOverallMaxHD", marks=2.5)
	public void testOverallMaxHD() {
		testOverallMaxD();
		assertEquals(60, aHD.overallMax()); //yup, i should have chosen a more diverse data set
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@Test @Order(37) @Graded(description="testMergeP", marks=2.5)
	public void testMergeP() {
		assertEquals("[30, 10, 40, 50, 20, 80, 10, 60, 30, 60, 60, 60]", Arrays.toString(aP.merge()));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(38) @Graded(description="testMergeCR", marks=2.5)
	public void testMergeCR() {
		testMergeP();
		assertEquals("[-30, 10, -40, -50, 20, 0, -10, 60, 30, -60, 60, 60, -20, -20, -20]", Arrays.toString(aCR.merge()));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(39) @Graded(description="testMergeD", marks=2.5)
	public void testMergeD() {
		testMergeCR();
		assertEquals("[-30, 10, -40, -10, 60, -60, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20, -20]", Arrays.toString(aD.merge()));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}
	
	@Test @Order(40) @Graded(description="testMergeHD", marks=2.5)
	public void testMergeHD() {
		testMergeD();
		assertEquals("[-30, 10, -40, -10, 60, -60, -20, -20, -20, -20, -20, -20, -20, -20, 50, 10, 30, 20]", Arrays.toString(aHD.merge()));
		currentMethodName = new Throwable().getStackTrace()[0].getMethodName();
	}

	@AfterEach
	public void logSuccess() throws NoSuchMethodException, SecurityException {
		if(currentMethodName != null && !methodsPassed.contains(currentMethodName)) {
			methodsPassed.add(currentMethodName);
			Method method = getClass().getMethod(currentMethodName);
			Graded graded = method.getAnnotation(Graded.class);
			score+=graded.marks();
			result+=graded.description()+" passed. Marks awarded: "+graded.marks()+"\n";
		}
	}
	
	@AfterAll
	public static void wrapUp() throws IOException {
		if(result.length() != 0) {
			result = result.substring(0, result.length()-1); //remove the last "\n"
		}
		System.out.println(result+"\nIndicative mark: "+score);
		if(score==100) {
			System.out.println("Golazo! Golazo!!! Golazo!!!!!");
		}
	}
}
