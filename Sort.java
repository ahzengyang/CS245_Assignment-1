package com.company;

public abstract class Sort {

    public abstract void sort(double[] arr); // future implementations must implement sort

    public abstract String toString(); // String representation of sort's name

    /**
     * swaps two elements in an array
     * @param arr array of doubles
     * @param i index of first element to be swapped
     * @param j index of second element to be swapped
     */
    protected void swap(double[] arr, int i, int j) { // swaps two elements in an array using their indices
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
