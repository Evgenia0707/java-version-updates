package com.company.java10;

import java.util.Arrays;
import java.util.List;

public class LocalVariableTypeDemo {
    public static void main(String[] args) {

        //Type inference --without declaring types, there is one type for all(lambda)compailer can detective type
        //can not use var -> instance var -belong the class -
        //if not initialize - will not work

        String s;
        s = "Ozzy";//can not do which var

        var str = "Cydeo";//var - only for local variable - inside
        var number = 5;

        byte x = 1;
        var y = 1;//int

        var price = 12.50;

//        List<Integer>numbers = Arrays.asList(3,4,5,6);
        var numbers = Arrays.asList(3,4,5,6);

        var sum = 0;
        for (var eachNumber : numbers){
            sum = sum+eachNumber;
        }


    }
}

