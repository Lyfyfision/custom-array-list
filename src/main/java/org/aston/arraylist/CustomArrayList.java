package org.aston.arraylist;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *  Implementation of {@link CustomList} interface. Implements
 *  all optional list operations, and permits all elements, including
 *  {@code null}.  In addition to implementing the {@code CustomList} interface,
 *  this class provides methods to manipulate the size of the array that is
 *  used internally to store the list. This implementation is resizeable and
 *  including specific method for multiplying internal capacity.
 *
 * @param <T> the type of elements
 */
public class CustomArrayList<T> implements CustomList<T> {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_ARRAY_CAPACITY = 5;

    /**
     * Array capacity multiplier used only in {@code capacityGrow()} method.
     */
    private static final int CAPACITY_MULTIPLIER = 2;

    /**
     * Array capacity.
     */
    private int capacity;

    /**
     * The size of array/number of elements it contains.
     */
    private int size;

    /**
     * Shared empty array instance used as internal storage of given objects.
     */
    private Object[] initArray;

    /**
     * Add a given element in the end of a list. Also check size before adding and
     * perform {@code capacityGrow()} if needed.
     *
     * @param element element that would be added in a list
     */
    public void add(T element) {
        if (capacity == size) {
            capacityGrow();
        }
        this.initArray[size] = element;
        size++;
    }

    /**
     * Add a given element in specific place of array based on given index.
     *
     * @param element element that would be added in a list
     * @param index specified index in array
     * @throws IndexOutOfBoundsException if specified index is bigger then capacity
     */
    public void addByIndex(T element, int index) {
        if (capacity == size) {
            capacityGrow();
        }
        if (size == index) {
            add(element);
            return;
        }
        if (index > capacity) {
            throw new IndexOutOfBoundsException("Current capacity is - " + this.capacity + "." + "Please, insert correct index");
        }
        shiftElementsOnAdd(index);
        initArray[index] = element;
        size++;
    }

    /**
     * Set a given element on specified position in array. If there is an object already on this index, then older
     * object would be rewritten.
     *
     * @param element element that would be added in a list
     * @param index specified index in array
     */
    public void set(T element, int index) {
        this.initArray[index] = element;
    }

    /**
     * Get a specific element by given index.
     *
     * @param index specified index in array
     * @return element by index
     * @throws java.util.NoSuchElementException if there is null by given index.
     */
    public T get(int index) {
        if((T) this.initArray[index] == null) {
            throw new NoSuchElementException("There is null by this index");
        }
        return (T) this.initArray[index];
    }

    /**
     * Remove existing element by given index(actually replace it with {@code null}) and perform elements shifting,
     * if removed element wasn't the last.
     *
     * @param index specified index in array
     */
    public void remove(int index) {
        if (index != this.size) {
            shiftElementsOnDelete(index);
        }
        this.initArray[this.size] = null;
        size--;
    }

    /**
     * Remove all elements in a list (replace all with null) and set list's size counter to 0.
     */
    public void clearAll() {
        for (int i = 0; i < size; i++) {
            initArray[i] = null;
        }
        this.size = 0;
    }

    /**
     * Returns the number of elements in a list.
     *
     * @return current size of a list
     */
    public int size() {
        return this.size;
    }

    /**
     * Helper method that is responsible for list's auto-growing when needed. Take actual capacity of
     * current list and multiply it, then create new list with bigger capacity and copy all elements in this new list.
     */
    private void capacityGrow() {
        int newCapacity = this.capacity * CAPACITY_MULTIPLIER;
        Object[] resized = new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            resized[i] = this.initArray[i];
        }
        this.initArray = resized;
        this.capacity = newCapacity;
    }

    /**
     * Helper method that perform shifting (to the right) all existing elements from specified index
     * when new element has been added.
     *
     * @param index index after which elements are shifted
     */
    private void shiftElementsOnAdd(int index) {
        for (int i = this.size; i > index; i--) {
            initArray[i] = initArray[i - 1];
        }
    }

    /**
     * Helper method that perform shifting (to the left) all existing elements from specified index
     * when new element has been removed.
     *
     * @param index index after which elements are shifted
     */
    private void shiftElementsOnDelete(int index) {
        for (int i = index; i < this.size; i++) {
            initArray[i] = initArray[i + 1];
        }
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param capacity specified initial capacity
     */
    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        this.initArray = new Object[capacity];
    }

    /**
     * Constructs an empty list with the default capacity.
     */
    public CustomArrayList() {
        this.capacity = DEFAULT_ARRAY_CAPACITY;
        this.initArray = new Object[capacity];
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "capacity=" + capacity +
                ", size=" + size +
                ", initArray=" + Arrays.toString(initArray) +
                '}';
    }
}
