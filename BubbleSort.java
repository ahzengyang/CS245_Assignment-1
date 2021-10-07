package com.company;

public class BubbleSort extends Sort {

    /**
     * Sorts an array by comparing adjacent elements rightward
     * @param arr array to be sorted
     */
    public void sort(double[] arr) {
        boolean sorted = false; // flag; keeps track of whether a swap has been made to allow the algorithm to stop early if the array is sorted
        for (int i = 1; !sorted; i++) { // i is used to ignore the (new) last element every loop, as it is the greatest (in order)
            sorted = true; // set flag to true; if no swaps are made, then the array is sorted
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) { // if next element is smaller
                    swap(arr, j, j + 1);
                    sorted = false; // not sorted this pass (because we had to swap)
                }
            }
        }
    }

    /**
     * @return string representation of sort's name
     */
    public String toString() {
        return "Bubble sort";
    }
}
