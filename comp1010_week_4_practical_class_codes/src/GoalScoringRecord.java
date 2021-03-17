public class GoalScoringRecord {
	public int shotsTaken, goalsScored;
	
	
	//constructor
	public GoalScoringRecord(int s, int g) {
		shotsTaken = Math.max(0, s);
		goalsScored = Math.max(0, g);
	}
	
	/**
	 * 
	 * @return conversion rate in percentage
	 */
	public double conversionRate() {
		return 100 * goalsScored / shotsTaken;
	}
	
	/**
	 * 
	 * @param other
	 * @return 1 if conversion rate of calling object is more than conversion rate of parameter object
	 * -1 if conversion rate of calling object is less than conversion rate of parameter object
	 * 0 if conversion rate of calling object is equal to conversion rate of parameter object
	 * this specifies calling object, other is paramter object
	 */
	public int compareTo(GoalScoringRecord other) {
		
		if (this.conversionRate() > other.conversionRate()) {
			return 1;
		}
		
		if(this.conversionRate() < other.conversionRate()) {
			return -1;
		}
		
		return 0; 
	}
}
	
