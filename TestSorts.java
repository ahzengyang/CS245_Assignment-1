package com.company;

import java.util.*;

public class TestSorts {

    private Sort[] part1 = {new SelectionSort(), new BubbleSort(), new InsertionSort(), new MergeSort(), new QuickSort()};
    private Sort[] part2 = {new MergeSort(), new QuickerMergeSort()};
    private Sort[] partMerge = {new MergeSort(), new QuickerMergeSort(), new OGQMS()};

    /**
     * @param selection user's choice of what collection of sorts they wish to test; supplied by command-line arguments
     * @return array of Sort objects
     */
    private Sort[] whatPart(String selection) {
        if (selection.equalsIgnoreCase("part1"))
            return part1;
        if (selection.equalsIgnoreCase("part2"))
            return part2;
        return partMerge; // personal test for all iterations of merge
    }

    /**
     * Creates an ArrayList of 10 arrays ranging from size 50,000 to 500,000 in increments of 50,000
     * @return ArrayList detailed above
     */
    private ArrayList<double[]> createArrays() {
        ArrayList<double[]> arrays = new ArrayList<double[]>(); // arraylist to be returned
        int size = 50000;
        for (int i = 1; i <= 10; i++)
            arrays.add(fillArrays(size * i));
        return arrays;
    }

    /**
     * Creates a new array and fills it with random doubles
     * @param size the length of the array
     * @return array filled with random doubles ranging from 0.0 (inclusive) to 1.0 (exclusive)
     */
    private double[] fillArrays(int size) {
        Random rng = new Random();
        double[] arr = new double[size];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = rng.nextDouble();
        }
        return arr;
    }

    /**
     * Runs all sorts through a test
     * @param sorts array of Sort objects to be tested
     * @param arr ArrayList of arrays to be sorted
     */
    private void runSorts(Sort[] sorts, ArrayList<double[]> arr) {
        for (int i = 0; i < sorts.length; i++)
            printTime(sorts[i], testSort(sorts[i], arr));
    }

    /**
     * Tests a type of sort on unsorted arrays of increasing sizes
     * @param type Sort object that will be sorting
     * @param arr ArrayList of arrays to be sorted
     * @return array of times it took to sort each array
     */
    private long[] testSort(Sort type, ArrayList<double[]> arr) {
        long[] times = new long[10];
        for (int i = 0; i < arr.size(); i++) { // sorts a copy of each array using a specified sorting algorithm
            times[i] = sortingTime(type, Arrays.copyOf(arr.get(i), arr.get(i).length));
        }
        return times;
    }

    /**
     * Sorts unsorted array and returns time taken
     * @param type Sort object that will be sorting
     * @param arr array to be sorted
     * @return time taken to sort
     */
    private long sortingTime(Sort type, double[] arr) {
        long start, end;
        start = System.currentTimeMillis(); // start recording time
        type.sort(arr);
        end = System.currentTimeMillis(); // stop recording time
        if(!checkSorted(arr)) { // if the sort was unsuccessful
            System.out.println(type + " was unsuccessful in sorting an array of length " + arr.length + ".");
            System.exit(0);
        }
        return end - start;
    }

    /**
     * Checks if array is sorted by comparing adjacent elements
     * @param arr array that has been run through a sorting algorithm
     * @return if the array was successfully sorted
     */
    private boolean checkSorted(double[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]) // if an element is greater than the next, it's out of order
                return false;
        }
        return true;
    }

    /**
     * Prints time taken
     * @param type Sort object that has sorted
     * @param timesArray array of times it took to sort each array
     */
    private void printTime(Sort type, long[] timesArray) {
        System.out.println(type + "'s times: " + Arrays.toString(timesArray));
    }

    public static void main(String[] args) {
        TestSorts test = new TestSorts();
        ArrayList<double[]> arrays = test.createArrays();
        Sort[] sorts = test.whatPart(args[0]);
        test.runSorts(sorts, arrays);
    }
}
