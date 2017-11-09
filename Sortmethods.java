package com.huang.sort;

public class Sortmethods {
	private int[] arrayOne = { 123, -10, 32, 34, 66, 134, 143, 24, 9, 42, 311,
			99, 76, 65 };

	public static void main(String[] args) {
		Sortmethods sort = new Sortmethods();
		// bubbleSort
		int[] array = sort.bubbleSort(sort.arrayOne);
		for (int i = 0; i < array.length - 1; i++) {
			if (i < 1) {
				System.out.println("bubbleSort:");
			}
			System.out.print(array[i] + "  ");
			if (i > array.length - 3) {
				System.out.println();
				System.out.println();
			}
		}
		// insertSort
		int[] array1 = sort.insertSort(sort.arrayOne);
		for (int i = 0; i < array1.length - 1; i++) {
			if (i < 1) {
				System.out.println("insertSort:");
			}
			System.out.print(array1[i] + "  ");
			if (i > array1.length - 3) {
				System.out.println();
				System.out.println();
			}
		}
		// selectSort
		int[] array2 = sort.selectSort(sort.arrayOne);
		for (int i = 0; i < array2.length - 1; i++) {
			if (i < 1) {
				System.out.println("selectSort:");
			}
			System.out.print(array2[i] + "  ");
			if (i > array2.length - 3) {
				System.out.println();
				System.out.println();
			}
		}
		// fastSort
		int[] array3 = sort.fastSort(sort.arrayOne);
		for (int i = 0; i < array3.length - 1; i++) {
			if (i < 1) {
				System.out.println("fastSort:");
			}
			System.out.print(array3[i] + "  ");
			if (i > array3.length - 3) {
				System.out.println();
				System.out.println();
			}
		}

	}

	/**
	 * bubbleSort
	 * 
	 * @param array
	 * @return int[] array
	 */
	private int[] bubbleSort(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		}
		for (int i = 0; i < array.length - 1; i++) {// 把最大的数字往后移动
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j + 1] < array[j]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}

		return array;

	}

	/**
	 * insertSort
	 * 
	 * @param array
	 * @return int[] array
	 */
	private int[] insertSort(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		}
		for (int i = 1; i < array.length; i++) {// 先排前两个，依次把后面的数字拿来和前面排好的数字做比较，插入一个位置
			for (int j = i - 1; j > -1; j--) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}

		return array;
	}

	/**
	 * selectSort
	 * 
	 * @param array
	 * @return int[] array
	 */
	private int[] selectSort(int[] array) {
		if (array == null || array.length < 2) {
			return array;
		}
		for (int i = 0; i < array.length; i++) {// 选择排序把最小数字往前移动
			int minIndex = i;
			for (int j = i + 1; j < array.length - 1; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;// 选择下标提高效率
				}
			}
			if (minIndex != i) {
				int temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		return array;

	}

	/**
	 * fastSort
	 * @param array
	 * @param low
	 * @param hight
	 * @return int[] array
	 */
	private int[] fastSort(int[] array) {
		int low = 0;
		int hight = array.length - 1;
		return fastSortHandler(array, low, hight);
	}

	private int[] fastSortHandler(int[] array, int low, int hight) {
		int l = low;
		int r = hight;
		int key = 0;
		if (l < array.length - 1) {
			key = array[l];
		}
		while (l < r) {
			while (l < r && array[r] >= key)
				r--;
			if (array[r] < key) {
				int temp = array[r];
				array[r] = key;
				key = temp;
			}
			while (l < r && array[l] <= key)
				l++;
			if (array[l] > key) {
				int temp = array[l];
				array[l] = key;
				key = temp;
			}
		}
		if (l > low) {
			fastSortHandler(array, low, l - 1);
		}
		if (r < hight) {
			fastSortHandler(array, r + 1, hight);
		}
		return array;
	}

}
