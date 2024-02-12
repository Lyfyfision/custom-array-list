package org.aston.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortingTest {

    private CustomArrayList<Integer> intList;
    private CustomArrayList<String> strList;

    @Test
    @DisplayName("Custom array list can be sorted")
    void testSort_whenTwoUnsortedListsGiven_shouldReturnSortedLists() {
        //Arrange
        intList = new CustomArrayList<>();
        strList = new CustomArrayList<>();

        CustomArrayList<Integer> expectedIntList = new CustomArrayList<>();
        expectedIntList.add(1);
        expectedIntList.add(4);
        expectedIntList.add(9);
        expectedIntList.add(23);

        CustomArrayList<String> expectedStringList = new CustomArrayList<>();
        expectedStringList.add("a");
        expectedStringList.add("b");
        expectedStringList.add("d");
        expectedStringList.add("e");

        intList.add(4);
        intList.add(1);
        intList.add(23);
        intList.add(9);

        strList.add("b");
        strList.add("e");
        strList.add("d");
        strList.add("a");

        //Act
        QuickSorting.sort(intList);
        QuickSorting.sort(strList);

        //Assert
        assertEquals(expectedIntList, intList);
        assertEquals(expectedStringList, strList);
    }
}