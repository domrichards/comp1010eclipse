// Cannot use Math library functions for any task

package practicePackage.introduction.attempts;

public class Stage2 {
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return true if exactly two out of the three values are the same, false otherwise
	 */
	public boolean twoOutOfThree(int a, int b, int c) {
		if(a == b && a!=c) {
			return true;
		}
		if(b == c && b!=a) {
			return true;
		}
		if(a == c && a!=b) {
			return true;
		}	
		return false;
	}

	/**
	 * 
	 * @param n (n could be positive, negative or zero)
	 * @return the last digit of the number
	 * For example,
	 * lastDigit(15) = 5
	 * lastDigit(-15) = 5
	 * lastDigit(0) = 0
	 * lastDigit(8) = 8
	 */
	public int lastDigit(int n) {
		if(n<0) {
			n*=-1;
		}
		
		return n%10;
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return the average of the two integers passed.
	 * for example,
	 * average(5, 9) = 7 (or 7.0)
	 * average(5, 8) = 6.5
	 */
	public double average(int a, int b) {
		return(a+b)/2.0;
	}

	/**
	 * 
	 * @param n
	 * @return the absolute value for n.
	 * absolute value is defined as the number without the negative sign, if any
	 * For example, absolute(-6) = 6, absolute(9) = 9
	 */
	public int absolute(int n) {
		if(n < 0) {
			return(n*=-1);
		}
		return n;
	}

	/**
	 * 
	 * @param val
	 * @param low
	 * @param high (assume low is less than or equal to high)
	 * @return value val constrained between low and high.
	 * that is,
	 * 
	 * if val is less than low, return low
	 * if val is more than high, return high
	 * in all other cases, return val
	 */
	public int constrain(int val, int low, int high) {
		if(val < low) {
			return low;
		}
		if( val > high) {
			return high;
		}
		return val;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @return the quadrant in which coordinate (x, y) exists
	 * quadrant 1: non-negative x, non-negative y
	 * quadrant 2: negative x, non-negative y
	 * quadrant 3: negative x, negative y
	 * quadrant 4: non-negative x, negative y
	 * 
	 */
	public int getQuadrant(int x, int y) {
		if(x >= 0 && y >= 0) {
			return 1;
		}
		if(x < 0 && y >= 0) {
			return 2;
		}
		if(x < 0 && y < 0) {
			return 3;
		} 
		return 4;
		
	}

	/**
	 * 
	 * @param val (assume val is more than or equal to zero)
	 * @return val rounded to the nearest integer.
	 */
	public int roundOff(double val) {
		return 0;
	}

	/**
	 * @param val (assume val is more than or equal to zero)
	 * @return floor of val
	 * floor of a floating-point value is defined as the highest integer
	 * that is less than or equal to the value.
	 * For example, floor(4.2) = 4, floor(7.0) = 7, floor(5.9999) = 5
	 */
	public int floor(double val) {
		return (int) val;
	}

	/**
	 * 
	 * @param val (assume val is more than or equal to zero)
	 * @return ceiling of val
	 * ceiling of a floating-point value is defined as the smallest integer
	 * that is more than or equal to the value.
	 * For example, ceiling(4.2) = 5, ceiling(7.0) = 7,
	 * ceiling(5.9999) = 6, ceiling(-3.7) = -3
	 */
	public int ceiling(double val) {
		int floor = (int)val;
		if(val > floor) {
			return floor + 1;
		}
		return (int) val;
	}
	
	/**
	 * 
	 * @param str: assume it contains at least one character
	 * @return the last character in the String
	 */
	public char getLastChar(String str) {
		return str.charAt(str.length()-1);
	}
	
	/**
	 * 
	 * @param str: assume it contains at least one character
	 * @return the String with the first character removed
	 */
	public String getWithoutFirstChar(String str) {
		return str.substring(1);
	}
	
	/**
	 * 
	 * @param str: assume it contains at least one character
	 * @return the String with the last character removed
	 */
	public String getWithoutLastChar(String str) {
		return str.substring(0, str.length()-1);
	}
}
