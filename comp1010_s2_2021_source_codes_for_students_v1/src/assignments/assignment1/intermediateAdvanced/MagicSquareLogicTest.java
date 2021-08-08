package assignments.assignment1.intermediateAdvanced;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
public class MagicSquareLogicTest {
	MagicSquareLogic eng1, eng2;

	@BeforeEach
	public void run() {
		eng1 = new MagicSquareLogic(3);
		eng1.data = new int[][]{{9,1,2},{6,7,8},{4,5,3}};

		eng2 = new MagicSquareLogic(4);
		eng2.data = new int[][]{{10,3,1,2},{11,6,7,8},{12,4,5,9}, {13,14,15,16}};
	}

	@Test
	public void testMagicSquareLogic() {
		eng1 = new MagicSquareLogic(3);
		assertEquals(3, eng1.n);
		assertEquals(3, eng1.data.length);
		for(int i=0; i < eng1.data.length; i++) {
			assertEquals(3, eng1.data[i].length);
		}
		
		eng1 = new MagicSquareLogic(4);
		assertEquals(4, eng1.n);
		assertEquals(4, eng1.data.length);
		for(int i=0; i < eng1.data.length; i++) {
			assertEquals(4, eng1.data[i].length);
		}
		
		eng1 = new MagicSquareLogic(8); //should updated to 7
		assertEquals(7, eng1.n);
		assertEquals(7, eng1.data.length);
		for(int i=0; i < eng1.data.length; i++) {
			assertEquals(7, eng1.data[i].length);
		}
		
		eng1 = new MagicSquareLogic(2); //should update to 3
		assertEquals(3, eng1.n);
		assertEquals(3, eng1.data.length);
		for(int i=0; i < eng1.data.length; i++) {
			assertEquals(3, eng1.data[i].length);
		}
		
		int product = 1;
		for(int i=0; i < eng1.n; i++) {
			for(int k=0; k < eng1.n; k++) {
				product*=eng1.data[i][k];
			}
		}
		assertEquals(362880, product); //1*2*...*9 = 3628800

		int[] freq = new int[9];
		for(int i=0; i < 3000; i++) {
			eng1 = new MagicSquareLogic(3);
			for(int k=0; k < eng1.n; k++) {
				for(int p=0; p < eng1.n; p++) {
					freq[eng1.data[k][p]-1]++;
				}
			}
		}
		for(int i=0; i < freq.length; i++) {
			assertTrue(freq[i]>=300, "item "+(freq[i]+1)+" doesn't occur enough times over a long series of experiments");
		}
		
		String[] log = new String[1000];
		int[] count = new int[1000];
		for(int run=0; run < log.length; run++) {
			eng1 = new MagicSquareLogic(3);
			assertEquals(3, eng1.n);
			String temp = "";
			for(int i=0; i < eng1.n; i++) {
				for(int k=0; k < eng1.n; k++) {
					temp = temp + eng1.data[i][k];
				}
			}
			log[run] = temp;
		}
		
		for(int i=0; i < log.length; i++) {
			for(int k=i; k < log.length; k++) {
				if(log[i].equals(log[k])) {
					count[i]++;
				}
			}
			assertTrue(count[i] <= 5);
			//given we are randomized the data, no one sequence
			//should occur more than 5 out of 1000 times
		}
	}


	@Test
	public void testIsValid() {
		assertFalse(eng1.isValid(-1, 0));
		assertFalse(eng1.isValid(0, -1));
		assertFalse(eng1.isValid(-5, -3));
		assertFalse(eng1.isValid(3, 0));
		assertFalse(eng1.isValid(0, 3));
		assertFalse(eng1.isValid(3, 8));
		assertFalse(eng1.isValid(39, 4));
		for(int i=0; i < 3; i++) {
			for(int k=0; k < 3; k++) {
				assertTrue(eng1.isValid(i, k), i+","+k+" is a valid index set");
			}
		}
	}

	@Test
	public void testSwap() {
		assertFalse(eng1.swap(-1,0,0,0));
		assertFalse(eng1.swap(0,-6,0,0));
		assertFalse(eng1.swap(-1,0,-3,0));
		assertFalse(eng1.swap(-1,0,0,-102));

		assertFalse(eng1.swap(4,0,0,0));
		assertFalse(eng1.swap(0,3,1,0));
		assertFalse(eng1.swap(0,0,5,0));
		assertFalse(eng1.swap(1,1,0,6));
		

		int item1 = eng1.data[0][0];
		int item2 = eng1.data[0][1];
		assertTrue(eng1.swap(0,0,0,1));
		assertEquals(item1, eng1.data[0][1]);
		assertEquals(item2, eng1.data[0][0]);

		item1 = eng1.data[1][2];
		item2 = eng1.data[0][1];
		assertTrue(eng1.swap(1,2,0,1));
		assertEquals(item1, eng1.data[0][1]);
		assertEquals(item2, eng1.data[1][2]);

	}
	
	@Test
	public void testCompleteSet() {
		assertTrue(eng1.completeSet());
		eng1.data[0][0] = eng1.data[2][2];
		assertFalse(eng1.completeSet());
		
		assertTrue(eng2.completeSet());
		eng2.data[2][3] = eng2.data[3][1];
		eng2.data[3][3] = eng2.data[2][3];
		assertFalse(eng2.completeSet());
		
		eng1 = new MagicSquareLogic(5);
		assertTrue(eng1.completeSet());
		eng1.data[4][4] = 26;
		assertFalse(eng1.completeSet());
		
		eng1 = new MagicSquareLogic(5);
		assertTrue(eng1.completeSet());
		eng1.data[3][3] = 0;
		assertFalse(eng1.completeSet());
	}
	
	@Test
	public void testFinished() {
		fail("Students need to write this test themselves");
	}

}
