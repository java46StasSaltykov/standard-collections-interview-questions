package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Words;

class WordsTest {
	
	String[] fruitsAndVegetables = {"apple", "ananas", "banana", "tomato", "onion", "watermelon", "grapes", "cucumber", "garlic"};
	Words words;
	
	@BeforeEach
	void setUp() {
		words = new Words();
		for (int i = 0; i < fruitsAndVegetables.length; i++) {
			words.addWord(fruitsAndVegetables[i]);
		}
	}

	@Test
	void testAddWord() {
		assertTrue(words.addWord("grapeFruit"));
		assertFalse(words.addWord("apple"));
	}

	@Test
	void testGetWordsByPrefix() {
		String[] expected = {"ananas", "apple"};
		String[] expected1 = {};
		ArrayList<String> wordsByPrefix = (ArrayList<String>) words.getWordsByPrefix("A");
		ArrayList<String> wordsByPrefix1 = (ArrayList<String>) words.getWordsByPrefix("q");
		assertArrayEquals(expected, wordsByPrefix.toArray(String[]::new));
		assertArrayEquals(expected1, wordsByPrefix1.toArray(String[]::new));
	}

}
