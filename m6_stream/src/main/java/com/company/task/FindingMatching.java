package com.company.task;


import com.company.task.Dish;
import com.company.task.DishData;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

    public class FindingMatching {
        public static void main(String[] args) {

//ALL MATCH
            System.out.println("ALL MATCH");//checks if all the elem-s of the stream match the given predicate
            boolean isHealthy = DishData.getAll().stream().allMatch(dish -> dish.getCalories() < 1000);//check for all data return < 1000(all data need to mach or return false)
            System.out.println(isHealthy);//true

//ANY MATCH
            System.out.println("ANY MATCH");//checks if there is an elem in the stream matching the given predicate
            if (DishData.getAll().stream().anyMatch(Dish::isVegetarian)) {//if any match return true/false
                System.out.println("The menu is vegetarian friendly");//The menu is vegetarian friendly
            }

//NONE MATCH
            System.out.println("NONE MATCH");//ensures no elem-s in the stream match the given predicate
            boolean isHealthy2 = DishData.getAll().stream().noneMatch(dish -> dish.getCalories() >= 1000);
            System.out.println(isHealthy2);//true -> not matching

//FIND ANY
            System.out.println("FIND ANY");//return any elem from a stream
            Optional<Dish> dish = DishData.getAll().stream().filter(Dish::isVegetarian).findAny();
            System.out.println(dish);//Optional[Dish(name=fries, vegetarian=true, calories=530, type=OTHER)]
//dish.get()
            System.out.println(dish.get());//Dish(name=fries, vegetarian=true, calories=530, type=OTHER)

//FIND FIRST
            System.out.println("FIND FIRST");//return first elem from a stream
            Optional<Dish> dish2 = DishData.getAll().stream().filter(Dish::isVegetarian).findFirst();
            System.out.println(dish2.get());//Dish(name=fries, vegetarian=true, calories=530, type=OTHER)

            //PARALLEL STREAMS (Async)

            System.out.println(IntStream.range(0, 100).parallel().findAny());//OptionalInt[65]create num between 0 to 100(mathru..)//action random
            System.out.println(IntStream.range(0, 100).parallel().findAny().getAsInt());//65

            System.out.println(IntStream.range(0, 100).parallel().findFirst());//OptionalInt[0]

            List<String> list1 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");
            List<String> list2 = Arrays.asList("Jhonny", "David", "Jack", "Duke", "Jill", "Dany", "Julia", "Jenish", "Divya");

//parallelStream()
//        Optional<String> findFirst = list1.parallelStream().filter(s -> s.startsWith("D")).findFirst();//convert to parallel stream -> find
//        Optional<String> findAny = list2.parallelStream().filter(s -> s.startsWith("J")).findAny();//convert to parallel stream -> find

//        System.out.println(findFirst.get());//David
//        System.out.println(findAny.get());//Jill

//stream()
            Optional<String> findFirst = list1.stream().filter(s -> s.startsWith("D")).findFirst();//convert to parallel stream -> find
            Optional<String> findAny = list2.stream().filter(s -> s.startsWith("J")).findAny();

            System.out.println(findFirst.get());//David
            System.out.println(findAny.get());//Jhonny

            System.out.println("MIN");
//MIN                                                             sorted               get min cal
            Optional<Dish> dMin = DishData.getAll().stream().min(Comparator.comparing(Dish::getCalories));//return Optinal
//        DishData.getAll().stream().sorted().limit(1).min(Comparator.comparing(Dish::getCalories));
            System.out.println(dMin.get());//Dish(name=fruit, vegetarian=true, calories=120, type=OTHER)

            System.out.println("MAX");
//MAX
            Optional<Dish> dMax = DishData.getAll().stream().max(Comparator.comparing(Dish::getCalories));
            System.out.println(dMax.get());//Dish(name=pork, vegetarian=false, calories=800, type=MEAT)

        }
    }



