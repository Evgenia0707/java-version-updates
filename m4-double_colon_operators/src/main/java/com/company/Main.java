package com.company;

import com.company.Calculate;
import com.company.Calculator;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

//                               implementation for abstract () belong to functional interface
        Predicate<Integer> pred = (p) -> p % 2 == 0 ? true : false;
//() signature - return boolean accept one parameter
        //interface accept Generic <>

        Calculate sum = (x, y) -> System.out.println(x + y);

        Calculate s1 = (x, y) -> Calculator.findSum(x, y);

//Reference to a Static Method if lambda calling () shorter :: (if stat () - clas
        Calculate s2 = Calculator::findSum;//implementation
        s2.calculate(10, 20);//Sum30//calling ()

        System.out.println("_________________________________________________________________");

//Reference to instance method
        Calculator obj = new Calculator();//create obj
        Calculate s3 = obj::findMultiply;// 1 way implementation

        Calculate s4 = new Calculator()::findMultiply;// 2 way implementation with creating obj inside

        System.out.println("____________________________________________________________________");

//                                                  obj
        BiFunction<String, Integer, String> func = (str, i) -> str.substring(i);
        //lamda expression is refer to () - implement coming from ()

        BiFunction<String, Integer, String> func2 = String::substring;
//substring is not static method why did we use String and not a string object this time
        //String ) bec we mention String in return type <String, Integer, String>

        System.out.println("_______________________________________________________________");
//               ()paramet, return type
        Function<Integer,Double> b = new MyClass() :: method;//static -call by ()name, here create new obj new com.company.MyClass()
        //              mention obj
        BiFunction<MyClass,Integer, Double> b1 = MyClass::method;//dnt need create new obj

        System.out.println("__________________________________________________________________");

        Consumer<Integer> display = i -> System.out.println(i);//only for print
        Consumer<Integer> display2 = System.out::println;//out -static - can call directly




    }
}
