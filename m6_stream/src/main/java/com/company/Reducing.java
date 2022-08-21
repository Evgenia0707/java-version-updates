package com.company;

import com.company.task.Dish;
import com.company.task.DishData;

import java.lang.management.MonitorInfo;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4,5,3,9);

//        int sum = 0;
//        for (int number : numbers){
//            sum = sum + number;
//        }

        int result = numbers.stream().reduce(0, (a,b) -> a + b);
        Optional<Integer> result1 = numbers.stream().reduce( (a, b) -> a + b);
        System.out.println(result1.get());
        System.out.println(result);//21

        System.out.println("Dish calories total: ");
        int calTotal =
        DishData.getAll().stream()
                .map(Dish::getCalories)
                .reduce((a,b)-> a+b)
                .get();
        System.out.println(calTotal);//4200

        Optional<Integer> calTotal1 = DishData.getAll().stream()
                .map(Dish::getCalories)
//                .reduce((a,b)-> a+b);// == Integer::sum)
                .reduce(Integer::sum);

        System.out.println(calTotal1.get());//4200

//MAX and MIN
        Optional<Integer> min = numbers.stream().reduce(Integer:: min);
        Optional<Integer> max = numbers.stream().reduce(Integer:: max);
        Optional<Integer> sum = numbers.stream().reduce(Integer:: sum);

        System.out.println("Min = " + min.get());//Min = 3
        System.out.println("Max = " + max.get());//Max = 9
        System.out.println("Sum = " + max.get());//Sum = 9

//COUNT
        System.out.println("COUNT");
        long dishCount = DishData.getAll().stream().count();
        System.out.println(dishCount);//9


    }
}
