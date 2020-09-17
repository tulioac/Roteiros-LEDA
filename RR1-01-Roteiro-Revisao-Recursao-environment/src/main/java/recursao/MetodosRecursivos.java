package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;

		result = calcularSomaArray(array, 0, array.length - 1);

		return result;
	}

	private int calcularSomaArray(int[] array, int elemIndex, int widthArray) {
		int result = 0;

		result += array[elemIndex];

		if (widthArray > 0) {
			result += calcularSomaArray(array, elemIndex + 1, widthArray - 1);
		}

		return  result;
	}

	public long calcularFatorial(int n) {
		long result = 1;

		result *= n;

		if (n > 1) {
			result *= calcularFatorial(n - 1);
		}

		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;

		if (n > 1) {
			result = calcularFibonacci(n, 0, 1);
		}

		return result;
	}

	public int calcularFibonacci(int n, int primeiro, int segundo) {
		int result = 0;

		result += primeiro + segundo;
		if (n > 1) {
			result = calcularFibonacci(n - 1, segundo, result);
		}

		return result;
	}

	public int countNotNull(Object[] array) {
		int result = 0;

		result = countNotNull(array, 0, array.length - 1);

		return result;
	}

	public int countNotNull(Object[] array, int index, int width) {
		int result = 0;
		if (array[index] != null) {
			result += 1;
			if (width > 0) {
				result += countNotNull(array, index + 1, width - 1);
			}
		}
		return result;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;

		if (expoente > 0) {
			result *= 2;
			if (expoente > 1) {
				result *= potenciaDe2(expoente - 1);
			}
		}

		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;

		if (n > 0) {
			result = termoInicial;
			result += razao;
			if (n > 1) {
				result += progressaoAritmetica(termoInicial, razao, n - 1);
			}
		}

		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;

		if (n > 0) {
			if (termoInicial != 0) {
				result = termoInicial;
			}
			result *= razao;
			if (n > 1) {
				result *= progressaoAritmetica(termoInicial, razao, n - 1);
			}
		}

		return result;
	}
	
	
}
