//NAME Dominic Richards
//STUDENT ID 45445532
//[x] I declare that I haven't seen another person's code, and the submission is entirely your work.
//(put an x inside the square brackets to provide declaration)

//Example:
//Gaurav Gupta
//44040404
//[x] I declare that I haven't seen another person's code, and the submission is entirely your work.

package assignments.assignment1.basic;
public class OrderingLogic {

	// the board variable needs to be public so that
	// it can be accessed by the JUnit test. Please
	// do not modify its visibility.
	public int[] data;

	/**
	 * @param size - the number of tiles on the board.
	 * if size is not positive, set it to 1 before proceeding.
	 * if size is more than 15, set it to 15 before proceeding.
	 * instantiate array data to contain (validated) size items.
	 * populate array data with randomized items between 1 and 90 
	 * (inclusive on both sides).
	 */
	public OrderingLogic(int size) {
		if (size <= 0) {
			size = 1;
		}
		if (size > 15) {
			size = 15;
		}
		data = new int [size];
		for(int i=0; i<data.length; i++) {
			data[i] = 1 + (int)(Math.random()*90);
		}
		/*
		 * read javadoc method comment carefully. applet will start working.
		 * once you complete this successfully. 
		 * then you can proceed with the rest of the game.
		 */
	}

	/**
	 * 
	 * Check if index idx is a valid index, that is, if there
	 * is an item at that index. Return false if the index
	 * is invalid
	 * 
	 * @param idx - the index to check
	 * @return true if index idx is a valid index of the array,
	 * false otherwise
	 */
	public boolean isValidIndex(int idx) {
		if(idx < 0 || idx >= data.length || data == null) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * Remove the item at index idx  moving all subsequent items "to the left".
	 * Do nothing if the index idx is invalid
	 * @param idx
	 */
	public void remove(int idx) {
		int[] left = new int[data.length-1];
		if(idx < 0 || idx >= data.length || data == null) {
			return;
		} else {
		for(int i=0, j=0; i<data.length; i++) {
			if(i!=idx) {
				left[j]=data[i];
				j++;
			}
		}
		}
		data = left;
	
	}

	/**
	 * 
	 * @return true if the array is sorted in ascending OR descending order, false otherwise
	 */
	public boolean isSorted() {
		boolean ascending = true;
		boolean descending = true;
		for(int i=0; i<data.length-1; i++) {
			if(data[i] < data[i+1]) {
				descending = false;
			}
			if(data[i] > data[i+1]) {
				ascending = false;
			}
		}
		if(ascending == false && descending == false) {
			return false;
		} else {
			return true;
		}
	}
}
