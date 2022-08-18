package com;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10,0,15,5,20);
        System.out.println(list);

//Ascending
        Collections.sort(list);
        System.out.println(list);//[0, 5, 10, 15, 20]

//Descending
        Collections.sort(list, new MyComparator());
        System.out.println(list);//[20, 15, 10, 5, 0]

//Descending with Lambda
        Collections.sort(list,(o1,o2) -> (o1 > o2) ? -1 : (o1 < o2) ? 1 : 0 );

//Ascending order
        list.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(list);//[0, 5, 10, 15, 20]

//Descending order
        list.sort((o2, o1) -> o1.compareTo(o2));
        System.out.println(list);//[20, 15, 10, 5, 0]

    }
}
