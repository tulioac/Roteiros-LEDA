package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validate(array, leftIndex, rightIndex)) {
			for (int i = leftIndex; i < rightIndex; i++) {
				for (int j = i + 1; j < rightIndex + 1; j++) {
					if (array[i].compareTo(array[j]) > 0) {
						Util.swap(array, i, j);
					}
				}
				for (int k = rightIndex - i; k > i; k--) {
					if (array[k - 1].compareTo(array[k]) > 0) {
						Util.swap(array, k, k-1);
					}
				}
			}
		}
	}

	private boolean validate(T[] array, int leftIndex, int rightIndex) {
		return (array != null && leftIndex >= 0 && rightIndex <= array.length - 1
				&& array.length > 1);
	}
}
