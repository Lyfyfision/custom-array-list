package org.aston.arraylist;

/**
 * This class is implementing QuickSort algorithm for previously created custom {@link CustomArrayList}.
 * <p>Main logic is staging on "Divide and conquer" principle that is including 4 methods - {@code quicksort},
 * {@code partition}, {@code swap} and {@code sort}. First 3 methods are encapsulated and the last one is using for actual sorting
 * outside this class.
 *
 * @see CustomArrayList
 */
public class QuickSorting {

    /**
     * Public method to perform sorting.
     *
     * @param list list to sort
     * @param <T> the type of elements
     */
    public static <T extends Comparable<? super T>> void sort(CustomArrayList<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    /**
     * Combine 3 helper methods and perform Quicksort on list. First we need to clarify size of list. If there is only 1
     * element inside then it's nothing to sort. The two recursive calls are sorting the smaller elements and the larger elements;
     * the condition tested before the recursive calls serves as the base case.
     *
     * @param array list to sort
     * @param start index of first element in list
     * @param end index of last element in list
     * @param <T> the type of elements
     */
    private static <T extends Comparable<? super T>> void quickSort(CustomArrayList<T> array, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(array, start, end);
        quickSort(array, start, index - 1);
        quickSort(array, index + 1, end);
    }

    /**
     * Main part of the QuickSort algorithm. Selects last element as pivot.
     *
     * @param array list to sort
     * @param first index of first element in given list
     * @param last index of last element in given list
     * @return index before which values are smaller than the pivot, and starting at which the values are bigger than the pivot
     * @param <T> the type of elements
     */
    private static <T extends Comparable<? super T>> int partition(CustomArrayList<T> array, int first, int last) {
        T key = array.get(last);
        int smaller = first - 1;
        for(int test = first; test < last; test++) {
            if (array.get(test).compareTo(key) <= 0) {
                smaller++;
                swap(array, smaller, test);
            }
        }
        smaller++;
        swap(array, last, smaller);
        return smaller;
    }

    /**
     * Helper method that provide possibility to swapping 2 elements inside given list. Used only in {@code partition}
     * method.
     *
     * @param array given list
     * @param i first element to swap
     * @param j second element to swap
     * @param <T> the type of elements
     */
    private static <T extends Comparable<? super T>> void swap(CustomArrayList<T> array, int i, int j) {
        //Temporary variable to hold the element at index i
        T temp = array.get(j);
        array.set(array.get(i), j);
        array.set(temp, i);
    }
}
