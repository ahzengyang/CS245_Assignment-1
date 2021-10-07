package com.company;

public class SelectionSort extends Sort {

    /**
     * Sorts an array by placing the smallest element in front
     * @param arr array to be sorted
     */
    public void sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) { // loops through entire array for each element
            swap(arr, i, findSmallest(arr, i)); // finds smallest element and swaps with i
        }
    }

    /**
     * Finds the smallest element's index
     * @param arr array to be searched
     * @param start starting index to begin search
     * @return index of the smallest element
     */
    private int findSmallest(double[] arr, int start) {
        int smallest = start; // Index of smallest element, assume it's first
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] < arr[smallest])
                smallest = i;
        } // smallest element's index is stored in smallest variable at loop termination
        return smallest;
    }

    /**
     * @return string representation of sort's name
     */
    public String toString() {
        return "Selection sort";
    }
}
