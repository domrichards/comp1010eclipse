// Cannot use Math library functions for any task

package practicePackage.introduction.attempts;

public class Stage3 {
	/**
	 * 
	 * @param n (assume n is more than 0)
	 * @return the sum of the first n positive integers (1+2+...+n)
	 */
	public int sum(int n) {
		int total = 0;
		while(n>0) {
			total += n;
			n--;
		}
		return total;
	}

	/**
	 * 
	 * @param n (assume n is more than 0)
	 * @return the sum of the first n positive EVEN integers (2+4+...+(2*n))
	 */
	public int sumEvenV1(int n) {
		int total = 0;
		while(n>0) {
			total += n*2;
			n--;
		}
		return total;
	}

	/**
	 * 
	 * @param n (assume n is more than 0)
	 * @return the sum of the first n positive ODD integers (1+3+...+(2*n-1))
	 */
	public int sumOddV1(int n) {
		int total = 0;
		while(n>0) {
			total += n*2-1;
			n--;
		}
		return total;
	}

	/**
	 * 
	 * @param n (assume n is more than 0)
	 * @return the sum of all positive even integers up to, and including n  
	 * either (2+4+...+n) or (2+4+...+(n-1))
	 */
	public int sumEvenV2(int n) {
		int total = 0;
		while(n>0) {
			if(n%2==0) {
				total += n;
			}
			n--;
		}
		return total;
	}

	/**
	 * 
	 * @param n (assume n is more than 0)
	 * @return the sum of all positive odd integers up to, and including n  
	 * either (1+3+...+n) or (1+3+...+(n-1))
	 */
	public int sumOddV2(int n) {
		int total = 0;
		while(n>0) {
			if(n%2==1) {
				total += n;
			}
			n--;
		}
		return total;
	}
	/**
	 * 
	 * @param n
	 * @return the product of the first n positive integers.
	 * for example, if n = 5, return 1*2*3*4*5 = 120
	 * return 1 if n < 1
	 */
	public int product(int n) {
		int total=n;
		if(n<1) {
			return 1;
		} else {
			while (n>1) {
				n--;
				total*=n;
			}
		} return total;
	}

	/**
	 * 
	 * @param n
	 * @return the product of the first n positive even integers.
	 * for example, if n = 5, return 2*4*6*8*10 = 3840
	 * return 1 if n < 1
	 */
	public int productEven(int n) {
		int total=n*2;
		if(n<1) {
			return 1;
		} else {
			while (n>1) {
				n--;
				total*=(n*2);
			}
		} return total;
	}

	/**
	 * 
	 * @param n
	 * @return the productOdd of the first n odd positive integers.
	 * for example, if n = 5, return 1*3*5*7*9 = 945
	 * return 1 if n < 1
	 */
	public int productOdd(int n) {
		int total=n*2-1;
		if(n<1) {
			return 1;
		} else {
			while (n>1) {
				n--;
				total*=(n*2-1);
			}
		} return total;
	}

	/**
	 * 
	 * @param n
	 * @return the number of digits in n.
	 * For example, 
	 * if n = 5, return 1.
	 * if n = 18, return 2.
	 * if n = 20478, return 5.
	 * 
	 * Noet: return 0 if n is less than or equal to 0.
	 */
	public int countDigits(int n) {
		int digits = 0;
		while(n!=0 ) {
			digits+=1;
			n = n/10;
		}
		return digits;
	}
	/**
	 * 
	 * @param x
	 * @param n (assume n is more than or equal to 0)
	 * @return x to the power of n without using Math library
	 */
	public int power(int x, int n) {
		if(n == 0) {
			return 1;
		}
		int total = 1;
		while(n > 0) {
			total *= x;
			n--;
		}
		return total;
	}

	/**
	 * 
	 * @param data: assume it's not null
	 * @return the sum of all items in data
	 */
	public int sum(int[] data) { 
        int sum = 0;
        for(int i=0; i<data.length; i++) {
         sum += data[i]; 
         }
        return sum; 
    }

	/**
	 * 
	 * @param data: assume it's not null
	 * @return the sum of all even numbers in data
	 */
	public int sumEven(int[] data) {
		int sum = 0;
        for(int i=0; i<data.length; i++) {
            if (data[i]%2 == 0) {
            sum+= data[i];
        }
        }
        return sum;
    } 

}
