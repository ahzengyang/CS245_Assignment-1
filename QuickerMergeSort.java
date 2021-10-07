package com.company;

import java.util.*;

public class QuickerMergeSort extends Sort {

    /**
     * Sorts an array by finding sorted regions and merging them
     * @param arr array to be sorted
     */
    public void sort(double[] arr) {
        ArrayList<int[]> regionsIndices = sortRegions(arr); // Arraylist of start/end indices of sorted regions
        double[] sortedRegion;
        while (regionsIndices.size() > 1) {
            for (int i = 0; i < regionsIndices.size() - 1; i++) {
                int[] region1 = regionsIndices.remove(i), region2 = regionsIndices.remove(i); // removes and stores first and second region's indices to be used later
                sortedRegion = merge(Arrays.copyOfRange(arr, region1[0], region1[1] + 1), Arrays.copyOfRange(arr, region2[0], region2[1] + 1)); // merges region1 and region2; + 1 because copyOfRange is exclusive
                regionsIndices.add(i, new int[]{region1[0], region2[1]}); // adds new array of region1's start and region2's end to beginning of arraylist
                replace(arr, sortedRegion, regionsIndices.get(i));
            }
        }
    }

    /**
     * Finds ArrayList of start/end indices of sorted regions
     * @param arr array to be searched
     * @return ArrayList of start/end indices of sorted regions
     */
    private ArrayList<int[]> sortRegions(double[] arr) {
        ArrayList<int[]> regions = new ArrayList<int[]>();
        int start = 0, end; // indices
        while (start < arr.length) {
            end = findRegion(arr, start);
            regions.add(new int[]{start, end});
            start = end + 1;
        }
        return regions;
    }

    /**
     * Finds end index of a sorted region
     * @param arr array to be searched
     * @param start starting index
     * @return end index of a sorted region
     */
    private int findRegion(double[] arr, int start) {
        int end = start;
        while (end < arr.length - 1 && arr[end] <= arr[end+1]) {
            end++;
        }
        return end;
    }

    /**
     * Combines two regions together in ascending order
     * @param region1 first sorted array
     * @param region2 second sorted array
     * @return a new sorted region
     */
    private double[] merge(double[] region1, double[] region2) {
        double[] finalRegion = new double[region1.length + region2.length]; // return
        int regF = 0, reg1 = 0, reg2 = 0; // indices
        while(reg1 < region1.length && reg2 < region2.length) { // while there are still more than one elements to merge in both arrays
            if (region1[reg1] < region2[reg2]) // element from left array is lesser than right
                finalRegion[regF++] = region1[reg1++]; // replace element
            else // element from right array is lesser than left
                finalRegion[regF++] = region2[reg2++]; // replace element
        }
        // only one array has elements to merge
        while (reg1 < region1.length) // if there is still at least one element in left and none left in right
            finalRegion[regF++] = region1[reg1++];
        while (reg2 < region2.length) // vice versa
            finalRegion[regF++] = region2[reg2++];
        return finalRegion;
    }

    /**
     * Writes over original array with a sorted region
     * @param arr original array
     * @param region sorted sub array of the original array
     * @param indices what part of the original array the sub array is from
     */
    private void replace(double[] arr, double[] region, int[] indices) {
        for (int i = indices[0], reg = 0; i <= indices[1]; i++, reg++) {
            arr[i] = region[reg];
        }
    }

    /**
     * @return string representation of sort's name
     */
    public String toString() {
        return "Quicker merge sort";
    }
}