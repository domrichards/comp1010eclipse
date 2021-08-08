package practicePackage.builtInLists.attempts;

import java.util.*;

import ServiceClasses.*;

public class Stage2 {
	/**
	 * 
	 * @param list
	 * @return the sum of all items of the list
	 * return 0 if list is null or empty
	 */
	public int sum(ArrayList<Integer> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return the sum of all negatives items of the list
	 * return 0 if list is null or empty
	 */
	public int sumNegatives(ArrayList<Integer> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return the number of even items in the list
	 * return 0 if list is null or empty
	 */
	public int countEven(ArrayList<Integer> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @return the number of times target exists in the list
	 * return 0 if list is null or empty
	 */
	public int count(ArrayList<Integer> list, int target) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param low
	 * @param high (assume low is less than or equal to high)
	 * @return the number of items in the list that belong to the range [low ... high]
	 * return 0 if list is null or empty
	 */
	public int countInRange(ArrayList<Integer> list, int low, int high) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param low
	 * @param high (assume low is less than or equal to high)
	 * @return true if there is at least one item in the list that is in the range [low ... high]
	 * return false if list is null or empty
	 */
	public boolean containsInRange(ArrayList<Integer> list, int low, int high) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param low
	 * @param high (assume low is less than or equal to high)
	 * @return true if all the items in the list are in the range [low ... high]
	 * return false if list is null
	 * return true if the list is empty
	 */
	public boolean allInRange(ArrayList<Integer> list, int low, int high) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return the number of prime numbers in the list
	 * return 0 if list is null or empty
	 * 
	 * IMPORTANT: you can (and should) use the helper 
	 * method isPrime(int) from class MathService as MathService.isPrime(value_to_check)
	 */
	public int countPrimes(ArrayList<Integer> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if there is at least one prime number in the list, false otherwise
	 * return false if list is null or empty
	 * 
	 * IMPORTANT: you can (and should) use the helper 
	 * method isPrime(int) from class MathService as MathService.isPrime(value_to_check)
	 */
	public boolean containsPrime(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if all the items in the list are prime numbers, false otherwise
	 * return false if list is null
	 * return true if the list is empty (because technically, every item in the list IS prime)
	 * 
	 * IMPORTANT: you can (and should) use the helper 
	 * method isPrime(int) from class MathService as MathService.isPrime(value_to_check) 
	 */
	public boolean allPrimes(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return number of rectangles in the list that are squares
	 * (you can, and should invoke, the instance method isSquare() in class Rectangle)
	 * return 0 if list is null or empty
	 * 
	 * TIP: using the enhanced for loop will make your life much easier!
	 */
	public int countSquares(ArrayList<Rectangle> list) {
		return 0; //to be completed
	}

	/**
	 * change each item of the list to its square.
	 * 
	 * if list is null or empty, do nothing
	 * 
	 * TIP: use set and get methods.
	 * @param list
	 * 
	 * For example,
	 * 
	 * if list = [3,0,-2,6], it should become [9, 0, 4, 36]
	 */
	public void squareUp(ArrayList<Integer> list) {
		//to be completed
	}

	/**
	 * 
	 * @param list
	 * @return the sum of all even items of the list passed.
	 * return 0 if the list is null
	 */
	public int sumEven(ArrayList<Integer> list) {
		return 0; //to be completed
	} 

	/**
	 * 
	 * @param list
	 * @return the sum of all odd items of the list passed.
	 * return 0 if the list is null
	 */
	public int sumOdd(ArrayList<Integer> list) {
		return 0; //to be completed
	} 

	/**
	 * 
	 * @param list
	 * @return the sum of all positive (more than 0) items of the list passed.
	 * return 0 if the list is null
	 */
	public int sumPositives(ArrayList<Integer> list) {
		return 0; //to be completed
	} 	

	/**
	 * 
	 * @param list
	 * @param n
	 * @return the sum of all items of the list passed that are multiples of n.
	 * return 0 if the list is null
	 */
	public int sumMultiples(ArrayList<Integer> list, int n) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param n
	 * @return the sum of all items of the list passed of which n is a multiple.
	 * return 0 if the list is null
	 */
	public int sumFactors(ArrayList<Integer> list, int n) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param low
	 * @param high
	 * @return sum of all items of the list passed that lie in the number range [low...high]
	 */
	public int sumInRange(ArrayList<Integer> list, int low, int high) {
		return 0; //to be completed
	} 	

	/**
	 * 
	 * @param list
	 * @param low
	 * @param high
	 * @return sum of all items of the list passed that lie OUTSIDE the number range [low...high]
	 */
	public int sumNotInRange(ArrayList<Integer> list, int low, int high) {
		return 0; //to be completed
	} 	

	/**
	 * 
	 * @param list
	 * @return the sum of all items at even indices of the list passed
	 */
	public int sumEvenIndexedItems(ArrayList<Integer> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return the sum of all items at odd indices of the list passed
	 */
	public int sumOddIndexedItems(ArrayList<Integer> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * reset any negative value(s) in the list passed to zero.
	 */
	public void resetNegatives(ArrayList<Integer> list) {
		//to be completed
	}

	/**
	 * 
	 * @param list
	 * update any negative value(s) in the list passed to positive value.
	 * for example, if list[2] is -5, it should become 5.
	 */
	public void makeAbsolute(ArrayList<Integer> list) {
		//to be completed
	}

	/**
	 * 
	 * @param list
	 * @return the number of odd numbers in the list passed.
	 * return 0 if the list is null.
	 */
	public int countOdd(ArrayList<Integer> list) {
		return 0; //to be completed
	} 

	/**
	 * 
	 * @param list
	 * @return the number of positive (more than 0) numbers in the list passed.
	 * return 0 if the list is null.
	 */
	public int countPositives(ArrayList<Integer> list) {
		return 0; //to be completed
	} 	

	/**
	 * 
	 * @param list
	 * @return the number of negative (less than 0) numbers in the list passed.
	 * return 0 if the list is null.
	 */
	public int countNegatives(ArrayList<Integer> list) {
		return 0; //to be completed
	} 	

	/**
	 * 
	 * @param list
	 * @param n
	 * @return the number of items in the list passed that are multiples of n.
	 * return 0 if the list is null.
	 */
	public int countMultiples(ArrayList<Integer> list, int n) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param n
	 * @return the number of items in the list passed of which n is a multiple.
	 * return 0 if the list is null.
	 */
	public int countFactors(ArrayList<Integer> list, int n) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param low
	 * @param high
	 * @return number of items in the list passed that are OUTSIDE the number range [low...high].
	 * return 0 if the list is null.
	 */
	public int countNotInRange(ArrayList<Integer> list, int low, int high) {
		return 0; //to be completed
	} 	

	/**
	 * 
	 * @param list
	 * @param target
	 * @return number of times target exists in the list passed.
	 * return 0 if list is null.
	 */
	public int countOccurrences(ArrayList<Integer> list, int target) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return the number of items in the list passed that occur exactly once in the array.
	 * return 0 if list is null.
	 * HINT: use method countOccurrences
	 */
	public int countUnique(ArrayList<Integer> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @return true if target exists in list passed, false otherwise.
	 * return false if list is null.
	 */
	public boolean contains(ArrayList<Integer> list, int target) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @return the first index at which target exists in the list passed.
	 * return -1 if list is null or target doesn't exist in the array.
	 */
	public int indexOf(ArrayList<Integer> list, int target) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @return the LAST index at which target exists in the list passed.
	 * return -1 if list is null or target doesn't exist in the array.
	 */
	public int lastIndexOf(ArrayList<Integer> list, int target) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @param startIndex
	 * @return true if target exists at index startIndex or later in the list passed, false otherwise.
	 * return false if list is null or target doesn't exist in the list starting at index startIndex.
	 */
	public boolean containsFromIndex(ArrayList<Integer> list, int target, int startIndex) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @param endIndex
	 * @return true if target exists up to (and including) index endIndex at which target exists in the list passed, false otherwise.
	 * return false if list is null or target doesn't exist in the list up to (and including) index endIndex.
	 */
	public boolean containsUptoIndex(ArrayList<Integer> list, int target, int endIndex) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param target
	 * @param startIndex
	 * @param endIndex
	 * @return true if target exists in the index range [startIndex...endIndex] at which target exists in the list passed, false otherwise.
	 * return false if list is null or target doesn't exist in the list in the index range [startIndex...endIndex].

	 */
	public boolean containsBetweenIndices(ArrayList<Integer> list, int target, int startIndex, int endIndex) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param startIndex
	 * @return sum of all items at index startIndex or higher in the list passed.
	 * return 0 if list is null.
	 */
	public int sumFromIndex(ArrayList<Integer> list, int startIndex) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param endIndex
	 * @return sum of all items at index endIndex or lower in the list passed.
	 * return 0 if list is null.
	 */
	public int sumUptoIndex(ArrayList<Integer> list, int endIndex) {
		return 0; //to be completed
	} 

	/**
	 * 
	 * @param list
	 * @param startIndex
	 * @param endIndex
	 * @return sum of all items in the index range [startIndex...endIndex].
	 * return 0 if list is null.
	 */
	public int sumBetweenIndices(ArrayList<Integer> list, int startIndex, int endIndex) {
		return 0; //to be completed
	} 

	/**
	 * 
	 * @param list
	 * @param startIndex
	 * @return sum of all even numbers at index startIndex or later.
	 * return 0 if list is null.
	 */
	public int sumEvenFromIndex(ArrayList<Integer> list, int startIndex) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param endIndex
	 * @return sum of all odd numbers up to, and including, endIndex
	 * return 0 if list is null.
	 */
	public int sumOddUptoIndex(ArrayList<Integer> list, int endIndex) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param endIndex
	 * @return product of all positive items up to index endIndex.
	 * return 1 if list is null or if no positive items exist up to index endIndex.
	 */
	public int productPositivesUptoIndex(ArrayList<Integer> list, int endIndex) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param startIndex
	 * @return product of all negative items starting at index startIndex.
	 * return 1 if list is null or if no negative items exist starting at index startIndex.
	 */
	public int productNegativesFromIndex(ArrayList<Integer> list, int startIndex) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param key
	 * @param startIndex
	 * @param endIndex
	 * @return number of times key exists in the list between the indices startIndex and endIndex.
	 * return 0 if list is null or if key doesn't exist between indices startIndex and endIndex. 
	 */
	public int countOccurrencesBetweenIndices(ArrayList<Integer> list, int key, int startIndex, int endIndex) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @param startIndex
	 * @param endIndex
	 * @return number of items that exist exactly once in the list between the indices startIndex and endIndex.
	 * return 0 if list is null or none of the items exist exactly once between indices startIndex and endIndex.
	 * HINT: use method countOccurrencesBetweenIndices
	 */
	public int countUniqueBetweenIndices(ArrayList<Integer> list, int startIndex, int endIndex) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if all items of the list are positive (more than 0), false otherwise.
	 * return false if the list is null.
	 */
	public boolean allPositives(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if all items of the list are negative (less than 0), false otherwise.
	 * return false if the list is null.
	 */
	public boolean allNegatives(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if all items of the list are zero, false otherwise.
	 * return false if the list is null.
	 */
	public boolean allZeroes(ArrayList<Integer> list) {
		return false; //to be completed
	}


	/**
	 * 
	 * @param list
	 * @return true if all items of the list are non-zero, false otherwise.
	 * return false if the list is null.
	 */
	public boolean allNonZeroes(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if there exists at least one positive (more than 0) value in the array, false otherwise.
	 * return false if the list is null.
	 */
	public boolean containsPositive(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if there exists at least one negative (less than 0) value in the array, false otherwise.
	 * return false if the list is null.
	 */
	public boolean containsNegative(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if there exists at least one zero in the array, false otherwise.
	 * return false if the list is null.
	 */
	public boolean containsZero(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if there exists at least one non-zero in the array, false otherwise.
	 * return false if the list is null.
	 */
	public boolean containsNonZero(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if the list is in ascending order, false otherwise.
	 * return false if the list is null.
	 */
	public boolean isAscending(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if the list is in descending order, false otherwise.
	 * return false if the list is null.
	 */
	public boolean isDescending(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if all items of the list are the same, false otherwise.
	 * return false if the list is null.
	 */
	public boolean isUnchanged(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return 2 if the list is sorted in both ascending and descending order,
	 * otherwise 1 if the list is sorted in ascending order,
	 * otherwise -1 if list is sorted in descending order, 
	 * otherwise 0
	 * return 0 if list is null.
	 * 
	 * NOTE: an list like {5, 5, 5} is sorted in both ascending AND descending order
	 */
	public int getSortedOrder(ArrayList<Integer> list) {
		return 0; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if the list contains the same number of positive (more than 0) and negative (less than 0) items.
	 * return false if list is null.
	 */
	public boolean isBalanced(ArrayList<Integer> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if each list.get(i) of the list is a valid digit ('0' to '9'), false otherwise.
	 * return false if list is null.
	 */
	public boolean allDigits(ArrayList<Character> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return true if at least 1 item of the list is a valid digit ('0' to '9'), false otherwise.
	 * return false if list is null.
	 */
	public boolean containsDigit(ArrayList<Character> list) {
		return false; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return the characters of the list converted to a String.
	 * return null if the list is null.
	 */
	public String toString(ArrayList<Character> list) {
		return null; //to be completed
	}

	/**
	 * 
	 * @param list
	 * @return a copy of the array.
	 * NOTE: the list returned SHOULD NOT refer to the same collection
	 * that the list passed refers to. 
	 * In other words
	 * if you update the values in the list returned, 
	 * the values in the list passed should not change. 
	 */
	public ArrayList<Integer> getCopy(ArrayList<Integer> list) {
		return null; //to be completed
	}
}

