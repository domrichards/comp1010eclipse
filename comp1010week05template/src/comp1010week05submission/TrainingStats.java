package comp1010week05submission;

public class TrainingStats {
	public int[] heartRate; //heart rate over the training sessions 
	public int[] decisionMaking; //scores out of 100 for each decision made
	
	/**
	 * create instance copies of parameter arrays int corresponding instance variable arrays
	 * for decision making, constraint all values between 0 and 100
	 * (think about what that means and if you don't understand it, look at the sample output provided)
	 * @param rate
	 * @param decisions
	 */
	public TrainingStats(int[] rate, int[] decisions) {
		this.heartRate=rate;
		this.decisionMaking=decisions;
		
		int[] rateCopy = new int[100];
		for(int i=0; i<rate.length; i++) {
			rateCopy[i]=rate[i];
		}
		
		int[] decisionsCopy = new int[100];
		for(int i=0; i<decisions.length; i++) {
			if(decisions[i] < 0 || decisions[i] > 100) {
				decisions[i]=null;
			}
			decisionsCopy[i]=decisions[i];
		}
		
	}
	
	/**
	 * P/CR level
	 * @return the average decision accuracy
	 */
	public double averageDecisionAccuracy() {
		return 0;
	}
	
	/**
	 * D/HD level
	 * @param n (assume n is between 1 and heartRate.length
	 * @return a sub-array  of size n with the lowest total of heart rate 
	 */
	public int[] bestHeartRateRun(int n) {
		return null;
	}
}
