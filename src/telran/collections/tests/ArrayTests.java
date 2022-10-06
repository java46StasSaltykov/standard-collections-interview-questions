package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;

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
		int halfSum = Arrays.stream(array).sum() / 2;
		HashSet<Integer> setHelper = new HashSet<>();
		for (int num : array) {
			if (setHelper.contains(halfSum - num)) {
				return true;
			}
			setHelper.add(num);
		}

		return false;
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
		int res = -1;
		HashSet<Integer> setHelper = new HashSet<>();
		for (int num : array) {
			int absNum = Math.abs(num);
			if (setHelper.contains(-num) && absNum > res) {
				res = absNum;
			}
			setHelper.add(num);
		}

		return res;
	}
	
	/**
	 * The method doesn't update a given array
	 * @param <T>
	 * @param array
	 * @return true if there is exactly one swap for getting sorted array
	 * examples: 
	 * {1, 2, 3, 10, -1, 5, 6} -> false 
	 * {1, 2, 3, 5, 6, 10} -> false (already sorted)
	 * {1, 3, 2, 4, 3, 10} -> false
	 * {10, 2, 3, 4, 1} -> true (swap 1 and 10)
	 * {1, 2, 4, 3, 5, 10} -> true (swap 3 and 4)
	 * {1, 5, 3, 4, 2, 10} -> true (swap 2 and 5)
	 * {"lmn", "ab", "bc", "cd", "a"} -> true (swap "lmn" and "a")
	 * An array should contain comparable elements
	 */
	<T> boolean isOneSwapForSorted(T[] array) {
		// TODO
		return false;
	}
	
	@Test
	void isOneSwapTest() {
		// TODO
	}

}