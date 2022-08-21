package com.company;

import com.company.task.Dish;
import com.company.task.DishData;
import com.company.task.Type;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 4, 3, 5, 6, 6, 7);

//toCollection(Supplier): is used to create a Collection using Collector(stream.collect inside call ())
        List<Integer> numberList = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(numberList);//[4, 6, 6]

        Set<Integer> numberSet = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(numberSet);//[4, 6]

//toList() : return a Collector Interface that gathers than input data into a new List
        List<Integer> numberList2 = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

//toSet() : return a Collector Interface that gathers than input data into a new Set
        Set<Integer> numberSet2 = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toSet());

//toMap(Function, Function) : return a Collector Interface that gathers the input data into a new map
        Map<String, Integer> dishMap = DishData.getAll().stream()
                .collect(Collectors.toMap(Dish::getName, Dish::getCalories));
        System.out.println(dishMap);

//summingInt(ToIntFunction) : return a Collector that produces the sum of a Integer-valued function
        Integer sum = DishData.getAll().stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(sum);//4200

//counting() : return a Collector that counts the number of the elements
        Long evenCount = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.counting());
        System.out.println(evenCount);//3

//averageingInt(ToIntFunction) : return the average of the Integers passed values
        Double calorieAverage = DishData.getAll().stream()
                .collect(Collectors.averagingInt(Dish::getCalories));
        System.out.println(calorieAverage);//466.6666666666667

//joining() : use to join various elements of a character or String Array into a single object (concatenation)
        List<String> courses = Arrays.asList("Java", "JS","TS");
        String str = courses.stream()
                .collect(Collectors.joining(","));
        System.out.println(str);//Java,JS,TS

//partitioningBy() : is used to partition a Stream of objects (for a set of elements) based on a given predicate
        Map<Boolean, List<Dish>> veggieDish = DishData.getAll().stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(veggieDish);//{false=[Dish(name=pork, vegetarian=false, calories=800, type=MEAT)......true=[Dish(name=fries,...

//groupingBy() : is used for grouping objects by some property and storing in a Map instance
        Map<Type, List<Dish>> dishType = DishData.getAll().stream()
                .collect(Collectors.groupingBy(Dish::getType));
        System.out.println(dishType);//{OTHER=[Dish(name=fries, v..FISH=[Dish(name=prawns,...MEAT=[Dish(name=pork,...















    }
}
