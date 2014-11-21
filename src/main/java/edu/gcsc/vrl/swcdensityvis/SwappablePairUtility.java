/// package's name
package edu.gcsc.vrl.swcdensityvis;

/**
 * @brief utilities
 * @author stephan
 */
public final class SwappablePairUtility {
	/**
	 * @brief private ctor
	 */
	private SwappablePairUtility() {
		
	}
	
	/**
	 * @brief swaps the pair
	 * @param <T>
	 * @param spair 
	 */
	public static<T extends java.lang.Number> void swap(SwappablePair<T> spair) {
		T temp = spair.getFirst();
		spair.setFirst(spair.getSecond());
		spair.setSecond(temp);
	}
}
