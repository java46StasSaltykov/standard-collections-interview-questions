package telran.util;

import java.util.*;

public class Words {
	
	private TreeSet<String> words = new TreeSet<String>();
	
	/**
	 * adds word 
	 * @param word
	 * @return true if added, otherwise false if a word already exists (case insensitive)
	 */
	public boolean addWord(String word) {
		if (words.contains(word.toLowerCase())) {
			return false;
		} else {
			words.add(word.toLowerCase());
			return true;
		}
	}
	
	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix (case insensitive)
	 */
	public List<String> getWordsByPrefix(String prefix) {
		ArrayList<String> res = new ArrayList<String>();
		int prefixLength = prefix.length();
		for (String word: words) {
			if (prefix.toLowerCase().equals(word.substring(0, prefixLength))) {
				res.add(word);
			}
		}
		return res;
	}
	
}
