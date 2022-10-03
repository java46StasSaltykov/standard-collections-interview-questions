package telran.structure;

import java.util.Set;

public interface MultiCounters {
	
	/**
	 * O[LogN]
	 * @param item
	 * @return how many times the item has been added
	 * if item is the new one then 1 will be returned
	 */
	Integer addItem(Object item);
	
	/**
	 * O[1]
	 * @param item
	 * @return how many times a given item has been added
	 * if never then null will be returned
	 */
	Integer getValue(Object item);

	/**
	 * O[LogN]
	 * removes item with all counters
	 * @param item
	 * @return true if item has been removed otherwise false (if a given item doesn't exist)
	 */
	boolean remove(Object item);

	/**
	 * O[LogN]
	 * @return set of items with maximal counters
	 */
	Set<Object> getMaxItems();
	
	
}
