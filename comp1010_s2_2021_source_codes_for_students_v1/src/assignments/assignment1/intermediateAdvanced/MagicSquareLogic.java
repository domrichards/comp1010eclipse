//NAME Dominic Richards
//STUDENT ID 45445532
//[x] I declare that I haven't seen another person's code, and the submission is entirely your work.
//(put an x inside the square brackets to provide declaration)

//Example:
//Gaurav Gupta
//44040404
//[x] I declare that I haven't seen another person's code, and the submission is entirely your work.

package assignments.assignment1.intermediateAdvanced;

public class MagicSquareLogic {
	// the board variable needs to be public so that
	// it can be accessed by the JUnit test. Please
	// do not modify its visibility.
	public int[][] data;
	public int n;

	/**
	 * @param size - number of rows/columns of the magic squares.
	 * if size is less than 3, set it to 3 before continuing.
	 * if size is more than 7, set it to 7 before continuing.
	 * 
	 * copy (moderated) size into n.
	 * 
	 * instantiate the array to contain size sub-arrays, each containing size items.
	 * populate the array such that it contains each item from 1 to n*n exactly once.
	 * 
	 * items in the array should be sufficiently randomized. for example, if n = 3,
	 * the array should not be {{1,2,3},{4,5,6},{7,8,9}} EVERY TIME.
	 * our tests have a check for that. if the test passes, you are ok. 
	 */
	public MagicSquareLogic(int size) {
	}

	/**
	 * 
	 * @param i
	 * @param k
	 * @return true if the indices i and k are valid (and false otherwise), 
	 * in that,
	 * the item, data[i][k], if accessed, would not generate ArrayIndexOutOfBoundsException
	 */
	public boolean isValid(int i, int k) {
		if(i < 0 || k < 0) { // return false if i or k are less than zero
			return false;
		}
		if(i >= data.length || k >= data.length) { // return false if i or k are greater than the arrays length
			return false;
		}
		if(data == null) { // return false if the array's data is null
			return false;
		}
		return true;
	}
	/**
	 * swap 
	 * item at index k1 inside sub-array at index i1,
	 * with
	 * item at index k2 inside sub-array at index i2,
	 * @return true if the indices were valid, and items were swapped,
	 * and false otherwise
	 */
	public boolean swap(int i1, int k1, int i2, int k2) {
		int temp; 												// create a temporary int for values in data to be stored
		if(isValid(i1,k1) == true && isValid(i2,k2) == true) { 		// check if both indices are valid
			temp = data[i1][k1];
			data[i1][k1] = data[i2][k2];
			data[i2][k2] = temp;
			return true;											// swap both items and return true
		}
		return false;
	}

	/**
	 * 
	 * @return true if the array data contains each value from 1 to n*n EXACTLY ONCE,
	 * false otherwise
	 */
	public boolean completeSet() {
		return true;
	}

	/**
	 * 
	 * @return true if the array represents a perfect magic square.
	 * this will need some research on your part.
	 * assumption: data represents a square matrix between 3x3 and 7x7.
	 */
	public boolean finished() {
		return false;
	}
}
