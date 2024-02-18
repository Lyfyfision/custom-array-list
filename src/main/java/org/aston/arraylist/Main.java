package org.aston.arraylist;

public class Main {
    public static void main(String[] args) {

        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("r");
        list.add("a");
        list.add("g");
        list.add("m");
        System.out.println(list);
        QuickSorting.sort(list);
        System.out.println(list);


    }
}