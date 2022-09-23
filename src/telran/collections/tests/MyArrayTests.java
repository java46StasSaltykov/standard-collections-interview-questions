package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.util.MyArray;


class MyArrayTests {
	
	Integer[] numbers = {1, 2, 3, 4, 5};
	MyArray<Integer> myArray;
	private static final int CAPACITY = 5;
	
	@BeforeEach
	void setUp() {
		myArray = new MyArray<Integer>(CAPACITY);
		for (int i = 0; i < CAPACITY; i++) {
			myArray.set(i, numbers[i]);
		}
	}
	
	@Test
	void testMyArray() {
		try {
			MyArray<Integer> testArray = new MyArray<Integer>(-2);
		} catch (Exception e) {

		}
	}

	@Test
	void testSetAll() {
		MyArray<Integer> newArray = new MyArray<Integer>(5);
		newArray.setAll(6);
		assertFalse(myArray.get(0).equals(newArray.get(0)));
		assertFalse(myArray.get(1).equals(newArray.get(1)));
		assertFalse(myArray.get(2).equals(newArray.get(2)));
		assertFalse(myArray.get(3).equals(newArray.get(3)));
		assertFalse(myArray.get(4).equals(newArray.get(4)));
		myArray.setAll(6);
		assertTrue(myArray.get(0).equals(newArray.get(0)));
		assertTrue(myArray.get(1).equals(newArray.get(1)));
		assertTrue(myArray.get(2).equals(newArray.get(2)));
		assertTrue(myArray.get(3).equals(newArray.get(3)));
		assertTrue(myArray.get(4).equals(newArray.get(4)));
	}

	@Test
	void testGet() {
		assertEquals(1, myArray.get(0));
		
	}

	@Test
	void testSet() {
		myArray.set(0, 7);
		assertNotEquals(1, myArray.get(0));
		assertEquals(7, myArray.get(0));
	}

}
