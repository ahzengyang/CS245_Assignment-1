package com.company;

public class QuickSort extends Sort {

    /**
     * Calls quickSort to sort an array
     * @param arr array to be sorted
     */
    public void sort(double[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    /**
     * Sorts an array by repeatedly arranging other elements in the array using a pivot element
     * @param arr array to be sorted
     * @param bot starting index
     * @param top ending index
     */
    private void quickSort(double[] arr, int bot, int top) {
        // base case: bot >= top
        if (bot < top) {
            int p = partition(arr, bot, top);
            quickSort(arr, bot, p-1);
            quickSort(arr, p+1, top);
        }
    }

    /**
     * Picks a pivot and sorts the elements around it
     * @param arr array to be sorted
     * @param left starting index of left side sweep
     * @param right starting index of right side sweep
     * @return index of the pivot
     */
    private int partition(double[] arr, int left, int right) {
        int pivot = right; // set to last element
        int bot = left;
        int top = right - 1; // prevent top from accounting pivot
        if (left < right) {
            while (bot <= top) {
                while (bot < right && arr[bot] < arr[pivot]) // find element larger than pivot from left
                    bot++;
                while (top >= bot && arr[top] >= arr[pivot]) // find element smaller than pivot from right
                    top--;
                if (bot < top)
                    swap(arr, bot, top);
                else //if (bot >= top)
                    swap(arr, bot, pivot);
            }
        }
        return bot;
    }

    /**
     * @return string representation of sort's name
     */
    public String toString() {
        return "Quick sort";
    }
}
