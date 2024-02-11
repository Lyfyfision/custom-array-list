package org.aston.arraylist;

/**
 * This class is implementing QuickSort algorithm for previously created custom {@link CustomArrayList}.
 * <p> Main logic is staging on "Divide and conquer" principle that is including 4 methods - {@code quicksort},
 * {@code partition}, {@code swap} and {@code sort}. First 3 methods are encapsulated and the last one is using for actual sorting
 * outside this class.
 * @see CustomArrayList
 */
public class QuickSorting {

    public static <T extends Comparable<? super T>> void sort(CustomArrayList<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    /**
     *
     *
     * @param array list for sorting
     * @param start index of first element in list
     * @param end index of last element in list
     * @param <T> the type of elements
     */
    private static <T extends Comparable<? super T>> void quickSort(CustomArrayList<T> array, int start, int end) {
        if (start >= end) {
            return;
        }
        int quicksort = partition(array, start, end);
        quickSort(array, start, quicksort - 1);
        quickSort(array, quicksort + 1, end);
    }

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

    private static <T extends Comparable<? super T>> void swap(CustomArrayList<T> array, int i, int j) {
        T temp = array.get(j);
        array.set(array.get(i), j);
        array.set(temp, i);
    }
}
