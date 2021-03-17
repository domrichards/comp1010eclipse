//Dominic Richards
//45445532
//[x] 	I confirm this is my own work (in design and implementation) 
//		and that I have not viewed another student's code OR design.

/**
 * 
 * all functions must be completed using the instance variable array (data).
 * it's an array of arrays of integers.
 * 
 * for example:
 * 
 * int[][] example1 = new int[2][3];
 * 
 * results in an array containing 2 sub-arrays, each containing 3 integers each.
 * 
 * int[][] example2 = {{10,20},{40,50},{70,80}};
 * 
 * results in an array containing 3 sub-arrays - 
 * first being {10, 20}, second begin {40, 50}, third being {70, 80}
 * 
 * int[][] example3 = {{10,20,30},{40},null,{},{70,80}};
 * 
 * results in an array containing 5 sub-arrays - 
 * first being {10, 20, 30}, second begin {40}, third being null, fourth being empty and fifth being {70, 80}
 * 
 * You can traverse an array of arrays (i hate the term 2-dimensional) as:
 * 
 * for(int i=0; i < example3.length; i++) { //for each sub-array
 * 	  if(data[i] != null) { //ONLY if current sub-array is not null
 *       for(int k=0; k < example3[i].length; k++) { //for each item in sub-array at index i
 * 	        //data[i][k] gives sub-array i, item k
 *       }
 *    }
 * }		
 * 
 */
public class Analytics {
    public int[][] data;

    /**
     * Populating the array - DO NOT MODIFY
     * @param source
     */
    public Analytics(int[][] source) {
        data = source;
    }

    /**
     * 
     * @return number of sub-arrays
     */
    public int size() {
        return data.length;
    }
    
    /**
     * 
     * @param idx
     * @return true if a sub-array exists at given index (idx), false otherwise.
     * 
     * SOME EXAMPLES:
     * if idx = -1, return false since data[-1] is out of bounds
     * if idx = 0, return true since data[0] refers to the first sub-array
     * if idx = 1, return true since data[1] refers to the second sub-array
     * ...
     * if idx = data.length - 1, return true since data[data.length - 1] refers to the last sub-array
     * if idx = data.length, return false since data[data.length] is out of bounds
     */
    public boolean isValidSubsetIndex(int idx) {
        if(idx >= 0 && idx < data.length) {
        	return true;
        }
        return false;
    }

    /**
     * 
     * @param idx1 index of sub-array
     * @param idx2 index of item within the sub-array 
     * @return true if an item exists at sub-array at index idx1 and 
     * at index idx2 within that sub-array, false otherwise
     */
    public boolean itemExistsAt(int idx1, int idx2) {
    	if(idx1 >= 0 && idx2 >= 0 && idx1 < data.length && idx2 < data[idx1].length) {
    		return true;
    	}
			return false;
	} 
    /**
     * 
     * @param idx index of the sub-array whose size is required
     * @return the number of items in the sub-array at passed index (idx)
     * if idx = 0, we want the size of the first sub-array
     * if idx = 1, we want the size of the second sub-array
     * ...
     * if the index passed is invalid, return 0
     */
    public int subsetSize(int idx) {
    	if(idx < 0 || idx>=data.length) {
    		return 0;
    	}
    	return data[idx].length;
    }

    /**
     * 
     * @param idx
     * @return sum of all items in sub-array at index idx
     * return 0 if index is invalid
     */
    public int sum(int idx) {   	
    	if(idx < 0 || idx >= data.length) {
    		return 0;
    	}
    	
    	int sum=0;
    	for(int i=0; i<data[idx].length; i++) {
    		sum+=data[idx][i];
    	}
    	return sum;
    }

    

    /**
     * 
     * @param idx
     * @return average of items in sub-array at index idx
     * return 0 if index is invalid
     */
    public double subsetAverage(int idx) {
    	if(idx < 0 || idx>=data.length) {
    		return 0;
    	}
    	double sum = 0;
    	for(int i=0; i<data[idx].length; i++) {
    		sum += data[idx][i];
    	}
    	if(data[idx].length == 0) {
    		return 0.0;
    	}
    	return sum/data[idx].length;
    }


    /**
     * 
     * @param idx
     * @return maximum value in sub-array at index idx
     * return 0 if index is invalid or if sub-array empty
     */
    public int subsetMax(int idx) {
    	if(idx < 0 || idx>=data.length) {
    		return 0;
    	}
    	int max = -999;
    	for(int i=0; i<data[idx].length; i++) {
    		if(data[idx][i] > max) {
    			max = data[idx][i];
    		}
    	}
    	return max;
    }

    /**
     * 
     * @param idx
     * @return maximum value for the passed index within all sub-arrays.
     * for example,
     * if idx = 2, you need to return maximum of 
     * data[0][2], data[1][2], ...data[data.length - 1][2]
     * 
     * * if idx = 5, you need to return maximum of 
     * data[0][5], data[1][5], ...data[data.length - 1][5]
     * 
     * If an item at the given index does not exist in a specific sub-array, 
     * you should ignore and continue with the remaining sub-arrays.
     * 
     * If an item at the given index does not exist in ANY sub-array, 
     * you should return 0.
     */
    public int maxForRound(int idx) {
    	int max = 0;
        for(int i=0; i<data.length; i++) {
        	if(idx >= 0 && idx < data[i].length) {
        		if(data[i][idx] > max) {
        			max = data[i][idx];
        		}
        	}
        }
        return max;
    }

    /**
     * 
     * @return highest value in the entire array
     * return 0 if it's an empty array; like {{},{},{}}
     */
    public int overallMax() {
    	int max = 0;
        for(int i=0; i<data.length; i++) {
        	if(data[i] != null) {
        	for(int j=0; j<data[i].length; j++) {
        		if(data[i][j] > max) {
        			max = data[i][j];
        			}
        		}
        	}
        }
        return max;
    }

    /**
     * 
     * @return the array converted to a single-dimensional array
     * For example,
     * if data = {{10, 40}, {50}, {}, {70, 20, 90}, {}},
     * return {10, 40, 50, 70, 20, 90}
     */
    public int[] merge() {
    	return new int[0];
    	    }
    
    /**
     * 
     * NOT ASSESSED
     * 
     * @return an array containing the SMALLEST value from each sub-array
     */
    public int[] smallestValuesFromEachSubset() {
    	return new int[0];
    }
    
    /**
     * 
     * NOT ASSESSED
     * 
     * @return a frequency table containing the items and the number of sub-arrays they occur in.
     * the order of items should be based on the order they exist in the array.
     * 
     * the frequency table should be in the form of an array of arrays of integers such that 
     * the each sub-array has two items - the first being the value and second being the number of
     * sub-arrays it exists in.
     * 
     * for example, if data = {{10,20,30,40,},{40,40,40,40},{20,10,10,20,10,40,40,20,10}}
     * 
     * return {{10,2},{20,2},{30,1},{40,3}}
     */
    public int[][] frequencyTable() {
    	return new int[0][0];
    }
}
