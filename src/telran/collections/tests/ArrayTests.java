package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArrayTests {

	@Test
	void halfSum() {
		int arWithHalfSum[] = { 40, -20, 50, 10, 20 }; // sum = 100, 40 + 10 = 50
		int arWithNoHalfSum[] = { 40, -20, 50, 5, 25 }; // sum = 100 , no two numbers with sum = 50
		assertTrue(isHalfSumTwoNumbers(arWithHalfSum));
		assertFalse(isHalfSumTwoNumbers(arWithNoHalfSum));
	}

	/**
	 * 
	 * @param array with no limitations of the number values
	 * @return true if there are two numbers with sum equaled half of total sum of a
	 *         given array
	 */
	private boolean isHalfSumTwoNumbers(int[] array) {
		boolean res = false;
		int sum = 0;
		int halfSum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			halfSum = (sum + array[i]) / 2;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length - i; j++) {
				if ((array[i] + array[j]) == halfSum) {
					res = true;
				}
			}
		}
		return res;
	}

	@Test
	void valueWithMaxNegativeTest() {
		int arWithNegative[] = { 10, 20000000, 2, 4, 40, -4, 10, -20000000, -2 };
		int arWithNoNegative[] = { 10, 20, 2, 4, 40, -14, 10, -21, -3 };
		assertEquals(20000000, valueWithMaxNegative(arWithNegative));
		assertEquals(-1, valueWithMaxNegative(arWithNoNegative));
	}

	/**
	 * 
	 * @param array with numbers that may have the huge values
	 * @return maximal value with existing negative image (negative value with same
	 *         absolute value) if no value with its negative image the function
	 *         returns -1
	 */
	private Integer valueWithMaxNegative(int[] array) {
		int res = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				for (int j = 0; j < array.length; j++) {
					if (array[i] == (-1 * array[j]) && array[i] > res) {
						res = array[i];
					}
				}
			}
		}
		return res != 0 ? res : -1;
	}

}