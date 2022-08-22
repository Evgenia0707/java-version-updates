package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {

        List<Integer> number = Arrays.asList(2, 4, 2, 10, 23);

//empty() - isPresent()
        Optional<String> empty = Optional.empty();
        System.out.println(empty);//Optional.empty
        System.out.println(empty.isPresent());//false

        System.out.println(Optional.of(number).isPresent()); //true

        System.out.println("____________________________________________________________________");

//        System.out.println(empty.get());//NoSuchElementException: No value present

        System.out.println("______________________________________________________________");
//ifPresent
        Optional<Integer> bigNumber = number.stream().filter(x -> x > 100).findAny();

        bigNumber.ifPresent(System.out::println);//condition wrong-non print

//        System.out.println(bigNumber.get());//NoSuchElementException: No value present
        System.out.println("_________________________________________________________________");
//orElse
        System.out.println(bigNumber.orElse(5));//5

    }
}
