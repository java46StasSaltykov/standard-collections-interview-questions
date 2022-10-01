package telran.util;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

	/**
	 * 
	 * @param word
	 * @param anagram
	 * @return true if anagram is one of the possible anagrams of a given word
	 * anagram is a string containing all symbols from a given word with different order
	 * example: yellow (wolely)
	 */
	public static boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		word = word.toLowerCase();
		anagram = anagram.toLowerCase();
		HashMap<Character, Integer> map = new HashMap<>();
		int wordLength = word.length();
		int anagramLength = anagram.length();
		for (int i = 0; i < wordLength; i++) {
			map.merge(word.charAt(i), 1, Integer::sum);
		}
		for (int i = 0; i < anagramLength; i++) {
			if (map.containsKey(anagram.charAt(i)) && map.get(anagram.charAt(i)) > 0) {
				map.compute(anagram.charAt(i), (key, value) -> value - 1);
			} else {
				return false;
			}
		}
		return true;
	}
	
}
