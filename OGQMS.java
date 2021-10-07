package com.company;

import java.util.*;

public class OGQMS extends Sort {

    /**
     * Sorts an array by finding sorted regions and merging them
     * @param arr array to be sorted
     */
    public void sort(double[] arr) {
        ArrayList<int[]> regionsIndices = sortRegions(arr); // Arraylist of start/end indices of sorted regions
        while (regionsIndices.size() > 1) {
            for (int i = 0; i < regionsIndices.size() - 1; i++) {
                int[] region1 = regionsIndices.remove(i), region2 = regionsIndices.remove(i); // removes and stores first and second region's indices to be used later
                merge(arr, Arrays.copyOfRange(arr, region1[0], region1[1] + 1), Arrays.copyOfRange(arr, region2[0], region2[1] + 1), region1[0]); // merges region1 and region2; + 1 because copyOfRange is exclusive
                regionsIndices.add(i, new int[]{region1[0], region2[1]}); // adds new array of region1's start and region2's end to beginning of arraylist
            }
        }
    }

    /**
     * Finds ArrayList of start/end indices of sorted regions
     * @param arr array to be searched
     * @return ArrayList of start/end indices of sorted regions
     */
    private ArrayList<int[]> sortRegions(double[] arr) { // finds and returns arraylist of start/end indices of sorted regions
        ArrayList<int[]> regions = new ArrayList<int[]>();
        int start = 0, end; // indices
        while (start < arr.length) {
            end = findRegion(arr, start);
            regions.add(new int[]{start, end}); // adds new start/end indices to regions
            start = end + 1; // start looking from next index
        }
        return regions;
    }

    /**
     * Finds end index of a sorted region
     * @param arr array to be searched
     * @param start starting index
     * @return end index of a sorted region
     */
    private int findRegion(double[] arr, int start) { // returns end index of sorted region
        int end = start;
        while (end < arr.length - 1 && arr[end] <= arr[end+1]) { // continue while in order and in bounds
            end++;
        }
        return end;
    }

    /**
     * Writes over original array by placing smallest elements from arrays region1 and region2
     * @param arr original array
     * @param region1 first sorted region
     * @param region2 second sorted region
     * @param start starting index of region1
     */
    private void merge(double[] arr, double[] region1, double[] region2, int start) { // alters original arr by placing smallest elements from region1 and region2
        int arrIndex = start, region1Index = 0, region2Index = 0;

        while(region1Index < region1.length && region2Index < region2.length) { // while there are still more than one elements to merge in both arrays
            if (region1[region1Index] < region2[region2Index]) // element from left array is lesser than right
                arr[arrIndex++] = region1[region1Index++]; // replace element
            else // element from right array is lesser than left
                arr[arrIndex++] = region2[region2Index++]; // replace element
        }
        // only one array has elements to merge
        while (region1Index < region1.length) // if there is still at least one element in left and none left in right
            arr[arrIndex++] = region1[region1Index++];
        while (region2Index < region2.length) // vice versa
            arr[arrIndex++] = region2[region2Index++];

    }

    /**
     * @return string representation of sort's name
     */
    public String toString() {
        return "OG Quicker merge sort";
    }
}
