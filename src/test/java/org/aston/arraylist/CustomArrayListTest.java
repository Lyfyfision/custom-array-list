package org.aston.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayListTest {

    private CustomArrayList<Integer> list;
    private CustomList defaultCapacity;
    private CustomList customCapacity;

    @BeforeEach
    void setUp() {
        list = new CustomArrayList<>();
        list.add(4);
        list.add(5);
        list.add(7);
        list.add(1);
        list.add(3);
    }

    @Test
    @DisplayName("New element can be added")
    void testAddElement_whenGivenInteger_shouldReturnListSize() {
        //Arrange

        //Act
        list.add(6);

        //Assert
        assertEquals(6, list.size());
    }

    @Test
    @DisplayName("List can be initialized with default capacity (5)")
    void testConstructor_whenDefaultCapacityExpected_shouldReturnDefaultCapacity() {
        //Arrange
        defaultCapacity = new CustomArrayList();

        //Act

        //Assert
        assertEquals(5, defaultCapacity.capacity());
    }

    @Test
    @DisplayName("List can be initialized with custom capacity")
    void testConstructor_whenCustomCapacityExpected_shouldReturnCustomCapacity() {
        //Arrange
        customCapacity = new CustomArrayList(10);

        //Act

        //Assert
        assertEquals(10, customCapacity.capacity());
    }

    @Test
    @DisplayName("New element can be correctly added by index")
    void addByIndex_whenAddElementByCorrectIndex_shouldReturnAddedElement() {
        //Arrange

        //Act
        list.addByIndex(6, 5);

        //Assert
        assertEquals(6, list.get(5));
    }

    @Test
    @DisplayName("New element can be set at specified place")
    void testSetNewElementOnIndex_whenGivenCorrectIndex_shouldReturnAddedElement() {
        //Arrange

        //Act
        list.set(1, 0);
        //Assert
        assertEquals(1, list.get(0));
    }

    @Test
    @DisplayName("Element can be returned by index")
    void testGetElement_shouldReturnElementByIndex() {
        //Arrange

        //Act

        //Assert
        assertEquals(4, list.get(0));
    }

    @Test
    @DisplayName("Element at last index can be removed")
    void testRemoveElement_whenGivenLastIndex_shouldThrowException() {
        //Arrange

        //Act
        list.remove(4);
        //Assert
        assertThrows(NoSuchElementException.class, () -> list.get(4));
    }

    @Test
    @DisplayName("Element can be removed by index")
    void testRemoveElement_whenGivenMiddleIndex_shouldReturnShiftedElement() {
        //Arrange

        //Act
        list.remove(2);

        //Assert
        assertEquals(1, list.get(2));
    }

    @Test
    @DisplayName("All elements can be deleted")
    void testClearAllElements_shouldReturnEmptySize() {
        //Arrange

        //Act
        list.clearAll();
        //Assert
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Number of elements can be properly returned")
    void testSize_shouldReturnTheNumberOfAllElements() {
        //Arrange

        //Act

        //Assert
        assertEquals(5, list.size());
    }
}