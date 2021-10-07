package com.company;

public class InsertionSort extends Sort {

    /**
     * Sorts an array by inserting elements where they belong
     * @param arr array to be sorted
     */
    public void sort(double[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1; // previous value to compare to i
            double element = arr[i]; // elInserto; element to be inserted
            while (j >= 0 && element < arr[j]) { // while we are in range and the sorted element is greater than the unsorted element
                arr[j+1] = arr[j--]; // shifts to the right
            }
            arr[j+1] = element; // inserts element where it belongs
        }
    }

    /**
     * @return string representation of sort's name
     */
    public String toString() {
        return "Insertion sort";
    }
}
