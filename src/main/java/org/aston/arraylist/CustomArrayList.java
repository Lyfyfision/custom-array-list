package org.aston.arraylist;

import java.util.Arrays;

/**
 * Implementation of {@link CustomList} interface.
 * @param <T>
 */
public class CustomArrayList<T> implements CustomList<T> {
    private static final int DEFAULT_ARRAY_CAPACITY = 5;
    private static final int CAPACITY_MULTIPLIER = 2;
    private int capacity;
    private int size;
    private Object[] initArray;

    public void add(T element) {
        if (capacity == size) {
            capacityGrow();
        }
        this.initArray[size] = element;
        size++;
    }

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

    public void set(T element, int index) {
        this.initArray[index] = element;
    }

    public T get(int index) {
        return (T) this.initArray[index];
    }

    public void remove(int index) {
        if (index != this.size) {
            shiftElementsOnDelete(index);
        }
        this.initArray[this.size] = null;
        size--;
    }

    public void clearAll() {
        for (int i = 0; i < size; i++) {
            initArray[i] = null;
        }
        this.size = 0;
    }

    //TODO - set up quicksort here
    public void sort() {

    }

    public int size() {
        return this.size;
    }

    private void capacityGrow() {
        int newCapacity = this.capacity * CAPACITY_MULTIPLIER;
        Object[] resized = new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            resized[i] = this.initArray[i];
        }
        this.initArray = resized;
        this.capacity = newCapacity;
    }

    private void shiftElementsOnAdd(int index) {
        for (int i = this.size; i > index; i--) {
            initArray[i] = initArray[i - 1];
        }
    }

    private void shiftElementsOnDelete(int index) {
        for (int i = index; i < this.size; i++) {
            initArray[i] = initArray[i + 1];
        }
    }

    public CustomArrayList(int capacity) {
        this.capacity = capacity;
        this.initArray = new Object[capacity];
    }

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
