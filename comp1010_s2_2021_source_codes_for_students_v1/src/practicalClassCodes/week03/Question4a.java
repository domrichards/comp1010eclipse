package practicalClassCodes.week03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Question4a {
	/** 
	 * return the sum of all items of the array passed
	 */
	public static int sum(int[] data) {
		int r = 0;
		//int i starting at 1, but needs to start at 0
		for(int i=1; i < data.length; i++) {
			r++;
		}
		return r;
	}
	@Test
	public void testSum() {
		assertEquals(190, sum(new int[] {10, 70, 20, 90}));
	}
}
