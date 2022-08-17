package lambda.prettyPrintApple;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class Apple {

    private Integer weight;
    private Color color;

}//1
/*
Write a prettyPrintApple method that takes aList of Apples and that can be
parameterized with multiple ways to generate a String output from an apple
public static void prettyPrintApple(List<Apple> inventory, ???){
 for(Apple apple : inventory){
 String output = ???.???(apple);
 System.out.println(output);
 }
}
Sample Output :
 A Light GREEN apple
 A Heavy RED apple
 A Light GREEN apple
Sample Output :
 An apple of 80g
 An apple of 155g
 An apple of 120g
 */
