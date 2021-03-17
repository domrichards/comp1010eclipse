import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GoalScoringRecordTest {

	@Test
	public void testCompareTo() {
		GoalScoringRecord a = new GoalScoringRecord(6, 2);
		GoalScoringRecord b = new GoalScoringRecord(8, 1);
		GoalScoringRecord c = new GoalScoringRecord(15, 5);
		
		//a is calling the method "compareTo"
		assertEquals(1,  a.compareTo(b)); // a=> calling object		assertEquals(-1,  b.compareTo(c));
		assertEquals(0,  c.compareTo(a));	
	}
}
