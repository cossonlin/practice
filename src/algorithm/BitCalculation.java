package algorithm;

import java.util.Arrays;

public class BitCalculation {

	public static void main(String[] args) {
		/*[0,1,1,0,0,1,0,1,1,1,0,1,0,1,1]
		  [0,0,1,0,0,1,1,1,1,1,0,1,0,0,0]

		  [0,1,0,1,1,0,0,0,1,0,1,1,1]*/
		int[] A = new int[]{0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1};
		int[] B = new int[]{0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0};
		BitCalculation p = new BitCalculation();
		int[] C = p.solution(A, B);
		for (int a : C) {
			System.out.print(a + ",");
		}
	}

	public int[] solution(int[] A, int[] B) {
		int lengthA = A.length;
		int lengthB = B.length;
		int lengthC = Math.max(lengthA, lengthB) + 2;
		int[] C = new int[lengthC];
		int nextDigitIncremental = 0;
		int nextNextDigitIncremental = 0;
		if (lengthA <= lengthB) {
			for (int i = 0; i < lengthA; i++) {
				int result = A[i] + B[i] + nextDigitIncremental;
				nextDigitIncremental = nextNextDigitIncremental;
				nextNextDigitIncremental = 0;
				if (result < 2) {
					C[i] = result;
				} else {
					C[i] = result % 2;
					if (nextDigitIncremental == 1) {
						--nextDigitIncremental;
					} else {
						++nextDigitIncremental;
						++nextNextDigitIncremental;
					}
				}
			}
			for (int i = lengthA; i < lengthB; i++) {
				int result = B[i] + nextDigitIncremental;
				nextDigitIncremental = nextNextDigitIncremental;
				nextNextDigitIncremental = 0;
				if (result < 2) {
					C[i] = result;
				} else {
					C[i] = result % 2;
					if (nextDigitIncremental == 1) {
						--nextDigitIncremental;
					} else {
						++nextDigitIncremental;
						++nextNextDigitIncremental;
					}
				}
			}
			C[lengthB] = nextDigitIncremental;
			C[lengthB + 1] = nextDigitIncremental;
		} else {
			for (int i = 0; i < lengthB; i++) {
				int result = A[i] + B[i] + nextDigitIncremental;
				nextDigitIncremental = nextNextDigitIncremental;
				nextNextDigitIncremental = 0;
				if (result < 2) {
					C[i] = result;
				} else {
					C[i] = result % 2;
					if (nextDigitIncremental == 1) {
						--nextDigitIncremental;
					} else {
						++nextDigitIncremental;
						++nextNextDigitIncremental;
					}
				}
			}
			for (int i = lengthB; i < lengthA; i++) {
				int result = A[i] + nextDigitIncremental;
				nextDigitIncremental = nextNextDigitIncremental;
				nextNextDigitIncremental = 0;
				if (result < 2) {
					C[i] = result;
				} else {
					C[i] = result % 2;
					if (nextDigitIncremental == 1) {
						--nextDigitIncremental;
					} else {
						++nextDigitIncremental;
						++nextNextDigitIncremental;
					}
				}
			}
			C[lengthB] = nextDigitIncremental;
			C[lengthB + 1] = nextDigitIncremental;
		}
		return trimArray(C);
	}

	private int[] trimArray(int[] C) {
		int length = 1;
		for (int i = C.length - 1; i >= 0; i--) {
			if (C[i] == 1) {
				length = i + 1;
				break;
			}
		}
		return Arrays.copyOf(C, length);
	}

}
