package com.company.employee;

import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {


        System.out.println("Print all email");

        EmployeeData.readAll()
//                .map(employee -> employee.getEmpEmail())
                .map(Employee::getEmpEmail)
                .forEach(System.out::println);

        System.out.println("Print all Phone Number");

        EmployeeData.readAll()
                .flatMap(employee -> employee.getEmpPhoneNumber().stream())
                .forEach(System.out::println);

        System.out.println("Print all Phone Number with Double Colon");

        EmployeeData.readAll()
                .map(Employee::getEmpPhoneNumber)
                .flatMap( List::stream )
                .forEach(System.out::println);
    }
}
