package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.Anagram;

class AnagramTests {

	@Test
	void testIsAnagram() {
		assertTrue(Anagram.isAnagram("Listen", "Silent"));
		assertFalse(Anagram.isAnagram("abcdef", "abcddf"));
		assertFalse(Anagram.isAnagram("yellow", "lowye"));
	}

}
