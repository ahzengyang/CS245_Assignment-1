package com.company;

public class MergeSort extends Sort {

    /**
     * Sorts an array by it repeatedly splitting in half until it's sorted (length == 1) then combining them back together
     * @param arr array to be sorted
     */
    public void sort(double[] arr) {
        // base case: arr.length == 1; the array is sorted
        if (arr.length > 1) {
            double[] left = getLeft(arr);
            double[] right = getRight(arr);
            sort(left);
            sort(right);
            merge(arr, left, right);
        }
    }

    /**
     * Returns left half of the array
     * @param arr array to be copied
     * @return left half of the array
     */
    private double[] getLeft(double[] arr) {
        int size = arr.length/2;
        double[] left = new double[size];
        for (int i = 0; i < size; i++) {
            left[i] = arr[i];
        }
        return left;
    }

    /**
     * Returns right half of the array
     * @param arr array to be copied
     * @return right half of the array
     */
    private double[] getRight(double[] arr) {
        int size = arr.length - arr.length/2; // accounts for array of odd length
        double[] right = new double[size];
        if (arr.length % 2 == 0) { // if length of array is even
            for (int i = 0; i < size; i++) {
                right[i] = arr[size + i];
            }
        }
        else { // if length of array is odd
            for (int i = 0; i < size; i++) {
                right[i] = arr[size - 1 + i];
            }
        }
        return right;
    }

    /**
     * Writes over original array, placing elements from arrays left and right in ascending order
     * @param arr original array
     * @param left left array
     * @param right right array
     */
    private void merge(double[] arr, double[] left, double[] right) {
        int arrIndex = 0, leftIndex = 0, rightIndex = 0;

        while(leftIndex < left.length && rightIndex < right.length) { // while there are still more than one elements to merge in both arrays
            if (left[leftIndex] < right[rightIndex]) // element from left array is lesser than right
                arr[arrIndex++] = left[leftIndex++]; // replace element
            else // element from right array is lesser than left
                arr[arrIndex++] = right[rightIndex++]; // replace element
        }
        // only one array has elements to merge
        while (leftIndex < left.length) // if there is still at least one element in left and none left in right
            arr[arrIndex++] = left[leftIndex++];
        while (rightIndex < right.length) // vice versa
            arr[arrIndex++] = right[rightIndex++];
    }

    /**
     * @return string representation of sort's name
     */
    public String toString() {
        return "Merge sort";
    }
}
