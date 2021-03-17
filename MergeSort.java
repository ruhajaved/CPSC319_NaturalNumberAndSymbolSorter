/**
 * Top-level Java class, which mimicks static class behaviour;
 * used to sort using MergeSort sorting method.
 */
public final class MergeSort
{
    /**
     * Empty, private constuctor.
     */
    private MergeSort()
    {
    }

    /**
     * sorts an array in descending order using merge sort.
     * @param array array of doubles to sort.
     * @param low the first index to start sorting at.
     * @param high the last index to stop sorting at - INCLUSIVE!
     */
    public static void sort(double[] array, int low, int high)
    {
        if(high <= low)  // base case - if length is only 1 index or indices don't make sense
        {
            return;
        }

        int mid = (low + high)/2;       // find mid point

        sort(array, low, mid);          // divide and conquer 1st half of array
        sort(array, mid + 1, high);     // divide and conquer 2nd half of array
        merge(array, low, mid, high);   // merge the 2 in descending order

    }

    /**
     * Merges 2 sections fo an area togther in descending order, 
     * assuming that both are already sorted in descending order.
     * @param array array to work on.
     * @param low first index to start merging at.
     * @param mid mid point seperating the 2 sections, included in the lower section.
     * @param high last index to stop merging at - INCLUSIVE!
     */
    public static void merge(double[] array, int low, int mid, int high)
    {
        int length = high - low + 1;
        double[] result = new double[length];   // need an array to store result in

        int leftIndex = low;                    // used to track index of first unused element in the 1st section
        int rightIndex = mid + 1;               // used to track index of first unused element in the 2nd section

        for(int resultIndex = 0; resultIndex < result.length; resultIndex++) //merge the 2
        {
            if(leftIndex == mid + 1)                          // if exhausted left array, add the rest of the 2nd in iterations
            {
                result[resultIndex] = array[rightIndex];
                rightIndex++;
            }
            else if(rightIndex == high + 1)                   // if exhausted right array, add the rest of the 1st in iterations
            {
                result[resultIndex] = array[leftIndex];
                leftIndex++;
            }
            else if(array[leftIndex] > array[rightIndex]) // if left array has larger element, add to result
            {
                result[resultIndex] = array[leftIndex];
                leftIndex++;
            }
            else                                          // if right array has larger element or equal element, add to result
            {
                result[resultIndex] = array[rightIndex];
                rightIndex++;
            }
        }

        System.arraycopy(result, 0, array, low, result.length); // copy result array into orignal array, within [low, high] boundaries
    }
}
