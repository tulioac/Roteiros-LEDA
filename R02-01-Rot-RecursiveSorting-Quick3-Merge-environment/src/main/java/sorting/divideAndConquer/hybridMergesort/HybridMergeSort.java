package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

import java.util.Arrays;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(validate(array, leftIndex, rightIndex)) {
			if (leftIndex < rightIndex) {
				if (MERGESORT_APPLICATIONS <= 4) {
					int middle = (leftIndex + rightIndex) / 2;

					sort(array, leftIndex, middle);
					sort(array, middle + 1, rightIndex);

					merge(array, leftIndex, rightIndex);
				} else {
					for (int i = leftIndex + 1; i <= rightIndex; i++) {
						T key = array[i];
						int j = i - 1;

						while (j >= leftIndex && key.compareTo(array[j]) < 0) {
							array[j + 1] = array[j];
							j --;
						}

						array[j + 1] = key;
					}
				}
			}
		}
	}

	private void merge(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS += 1;
		T[] arrayAux = Arrays.copyOf(array, array.length);

		int start = leftIndex;
		int middle = (leftIndex + rightIndex) / 2;
		int secStart = middle + 1;
		int count = leftIndex;

		while (start <= middle && secStart <= rightIndex) {
			if (arrayAux[start].compareTo(arrayAux[secStart]) <= 0) {
				array[count++] = arrayAux[start++];
			} else {
				array[count++] = arrayAux[secStart++];
			}
		}

		while (start <= middle) {
			array[count++] = arrayAux[start++];
		}

		while (secStart <= rightIndex) {
			array[count++] = arrayAux[secStart++];
		}
	}

	private boolean validate(T[] array, int leftIndex, int rightIndex) {
		return (array != null && leftIndex >= 0 && rightIndex <= array.length - 1
				&& array.length > 1);
	}
}
