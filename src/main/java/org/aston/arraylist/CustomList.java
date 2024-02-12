package org.aston.arraylist;

/**
 * This interface represent a contract for custom implementation of array list.
 *
 * @param <T> the type of elements
 */
public interface CustomList<T> {

    void add(T e);
    void addByIndex(T element, int index);
    void set(T element, int index);
    T get(int index);
    void remove(int index);
    void clearAll();
    int size();

    int capacity();

}
