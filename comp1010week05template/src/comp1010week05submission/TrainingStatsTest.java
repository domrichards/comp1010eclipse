package comp1010week05submission;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrainingStatsTest {
	TrainingStats stats;
	int[] hr, dm;
	@BeforeEach
	void setUp() throws Exception {
		hr = new int[]{71, 80, 70, 60, 80, 90, 70, 60, 70};
		dm = new int[]{91, 50, 85, 78, 89, 97, 100, 83, 67, 91};
		stats = new TrainingStats(hr, dm);
	}

	@Test
	void testTrainingStats() {
		assertEquals("[71, 80, 70, 60, 80, 90, 70, 60, 70]", Arrays.toString(stats.heartRate));
		assertEquals("[91, 50, 85, 78, 89, 97, 100, 83, 67, 91]", Arrays.toString(stats.decisionMaking));
		assertNotEquals(hr, stats.heartRate);
		assertNotEquals(dm, stats.decisionMaking);
		hr = null;
		dm = null;
		assertEquals("[71, 80, 70, 60, 80, 90, 70, 60, 70]", Arrays.toString(stats.heartRate));
		assertEquals("[91, 50, 85, 78, 89, 97, 100, 83, 67, 91]", Arrays.toString(stats.decisionMaking));
	}

	@Test
	void testAverageDecisionAccuracy() {
		assertEquals(83.1, stats.averageDecisionAccuracy(), 0.01);
	}

	@Test
	void testBestHeartRateRun() {
		assertEquals("[70, 60, 70]", Arrays.toString(stats.bestHeartRateRun(3)));
	}
}
