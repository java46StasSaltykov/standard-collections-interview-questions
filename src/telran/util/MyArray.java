package telran.util;

import java.util.HashMap;
import java.util.Map;

/**
 * All methods of the class should have complexity of O[1]
 * @author 97252
 *
 * @param <T>
 */
public class MyArray<T> {
	
	private Map<Integer, T> hashMap;
	private int size;
	
	public MyArray(int size) {
		if (size < 0) {
			throw new IllegalArgumentException("size must be positive number");
		}
		this.size = size;
		hashMap = new HashMap<Integer, T>(size);
	}
	
	/**
	 * sets all array's elements with a given value
	 * @param value
	 */
	public void setAll(T value) {
		if (hashMap.isEmpty()) {
			for (int i = 0; i < size; i++) {
				hashMap.put(i, value);
			}
		} else {
			for (int i = 0; i < size; i++) {
				hashMap.replace(i, value);
			}
		}
	}
	
	/**
	 * 
	 * @param index
	 * @return value at given index or null
	 */
	public T get(int index) {		
		return hashMap.get(index);
	}
	
	/**
	 * sets a given value at a given index
	 * throws IndexOutOfBoundException in the case of wrong index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("index must be positive number");
		}
		if (hashMap.get(index) == null) {
			hashMap.put(index, value);
		} else {
			hashMap.replace(index, value);
		}
	}
}
