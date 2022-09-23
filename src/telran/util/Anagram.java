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
		Map<Character, Integer> charOccurencesWord = getCharOccurences(word);
		Map<Character, Integer> charOccurencesAnagram = getCharOccurences(anagram);
		if (charOccurencesWord.equals(charOccurencesAnagram)) {
			return true;
		} else {
			return false;
		}
	}

	private static Map<Character, Integer> getCharOccurences(String string) {
		Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
		char[] arr = string.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (hashMap.get(arr[i]) == null) {
				hashMap.put(arr[i], 1);
			} else {
				Integer count = hashMap.get(arr[i]);
				hashMap.put(arr[i], ++count);
			}
		}
		return hashMap;
	}
	
}
