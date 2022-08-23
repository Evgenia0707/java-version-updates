package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UserTest {
    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.add(new User("Mike", "Smith",35));
        users.add(new User("Tom", "Evan",25));
        users.add(new User("Emma", "Polland",55));

        //print all elements in the list

        printName(users, user -> true);

        //print all people that last name starts wir E

        printName(users, user -> user.getLastName().startsWith("E"));

    }
        public static void printName (List<User> users, Predicate<User> p){//testing <User> obj
        for (User each : users){
            if (p.test(each) )//()call test - return boolean
                System.out.println(users.toString());
        }

        }
}
