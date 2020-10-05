package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (validate(array, leftIndex, rightIndex)) {
			if (leftIndex < rightIndex) {
				int pivot = partition(array, leftIndex, rightIndex);

				sort(array, leftIndex, pivot - 1);
				sort(array, pivot + 1, rightIndex);
			}
		}
	}

	private int partition (T[] array, int leftIndex, int rightIndex) {
		int mediaThree = mediaOfThree(array, leftIndex, rightIndex);
		Util.swap(array, leftIndex, mediaThree);
		int pivot = leftIndex;
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(array[pivot]) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, i, pivot);

		return i;
	}

	private int mediaOfThree(T[] array, int i, int j) {
		int mid = (i + j) / 2;

		int[] sortedIndexes = {i, mid, j};

		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 2; l++) {
				if (array[sortedIndexes[l]].compareTo(array[sortedIndexes[l+1]]) > 0) {
					int aux = sortedIndexes[l];
					sortedIndexes[l] = sortedIndexes[l + 1];
					sortedIndexes[l + 1] = aux;
				}
			}
		}

		return sortedIndexes[1];
	}

	private boolean validate(T[] array, int leftIndex, int rightIndex) {
		return (array != null && leftIndex >= 0 && rightIndex <= array.length - 1
				&& array.length > 1);
	}
}
