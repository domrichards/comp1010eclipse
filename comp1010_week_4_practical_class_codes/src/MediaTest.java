import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MediaTest {

	@Test
	void testMedia() {
		Media a = new Media(20, 40);
		assertEquals(20, a.length);
		assertEquals(40, a.frameRate);
	}

	@Test
	void testTotalFrameCount() {
		Media a = new Media(20, 40);
		assertEquals(800, a.totalFrameCount());
	}

	@Test
	void testCompareTo() {
		Media a = new Media(20, 40);
		Media b = new Media(15, 60);
		assertEquals(-1, a.compareTo(b));
		assertEquals(1, b.compareTo(a));
		assertEquals(0, a.compareTo(a));
	}

}
