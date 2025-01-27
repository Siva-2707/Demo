package com.siva.algorithim;

public class Sorting {
	int arr[];
	int arrSize;

	public Sorting(int arr[]) {
		this.arr = arr;
		this.arrSize = arr.length;
	}

	public void bubbleSort() {

		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1])
					swap(j, j + 1);
			}
		}
	}

	public void selectionSort() {
		for (int i = 0; i < arrSize; i++) {
			int minIndex = i;
			for (int j = i; j < arrSize; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(i, minIndex);
		}
	}

	public void insertionSort() {
		System.out.println("Entering insersion sort");
		for (int i = 1; i < arrSize; i++) {
			int thePickedElement = arr[i];
			int j = i;
			while (j > 0 && thePickedElement < arr[j - 1]) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = thePickedElement;
		}
		System.out.println("Exiting insersion sort");
	}

	private void swap(int j, int i) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i : arr) {
			str += i + " ";
		}
		return str;
	}

	public int[] getSortedArray() {
		return arr;
	}
}
