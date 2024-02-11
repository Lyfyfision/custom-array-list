package org.aston.arraylist;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("r");
        list.add("a");
        list.add("g");
        list.add("m");
        list.add("i");
        list.add("z");
        list.add("e");
        list.add("e");
        list.add("e");
        System.out.println(list);
        QuickSorting.sort(list);
        System.out.println(list);

        CustomArrayList<Integer> listTwo = new CustomArrayList<>();
        listTwo.add(10);
        listTwo.add(122);
        listTwo.add(1);
        listTwo.add(5);
        listTwo.add(7);
        System.out.println(listTwo);
        QuickSorting.sort(listTwo);
        System.out.println(listTwo);
    }
}