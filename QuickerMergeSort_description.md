QuickerMergeSort sorts an array by:
1. Finding sorted regions and saving their start/end indices to an ArrayList of int arrays.
-This is done by finding when the next element is less than the current element.
2. Removing and storing the first two adjacent sorted regions from the ArrayList.
3. Combining them and storing a new sorted region.
4. Adding a new start/end indices pair of the new sorted region.
5. Replacing the appropriate region in the original array with the new sorted region's data.
6. Repeating 2-5 until there is only 1 sorted region.
