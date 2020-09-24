package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validate(array, leftIndex, rightIndex)) {
			for (int i = leftIndex; i < rightIndex; i++) {
				int minor_index = i;

				for (int j = i + 1; j < rightIndex + 1; j++) {
					if (array[j].compareTo(array[minor_index]) < 0) {
						minor_index = j;
					}
				}

				Util.swap(array, i, minor_index);
			}
		}
	}

	private boolean validate(T[] array, int leftIndex, int rightIndex) {
		return (array != null && leftIndex >= 0 && rightIndex <= array.length - 1
				&& array.length > 1);
	}
}
