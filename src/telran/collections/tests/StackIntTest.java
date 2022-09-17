package telran.collections.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.StackInt;

class StackIntTest {
	
	StackInt stackInt = new StackInt(3);
	
	@BeforeEach
	void setUp() {
		stackInt.push(1);
		stackInt.push(2);
		stackInt.push(3);
	}

	@Test
	void testPop() {
		stackInt.pop();
		int[] expected = {1, 2, 0};
		assertArrayEquals(expected, stackInt.toArray());
	}

	@Test
	void testPush() {
		stackInt.pop();
		stackInt.push(4);
		int[] expected = {1, 2, 4};
		assertArrayEquals(expected, stackInt.toArray());
	}

	@Test
	void testIsEmpty() {
		stackInt.pop();
		stackInt.pop();
		stackInt.pop();
		int[] expected = {0, 0, 0};
		assertArrayEquals(expected, stackInt.toArray());
	}

	@Test
	void testGetMaxNumber() {
		assertEquals(3, stackInt.getMaxNumber());
		assertFalse(2 == stackInt.getMaxNumber());
	}

}
