package com.company.Constr;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CarTest {
    public static void main(String[] args) {

//Zero Argument Constructor @NoArgsConstructor
        Supplier<Car> c1 = () -> new Car(); //return car obj <Car>
        System.out.println(c1.get().getModel());

        Supplier<Car> c2 = Car:: new; //new == constructor
        System.out.println(c2.get().getModel());

//One Argument Constructor @AllArgsConstructor
        Function<Integer,Car> f1 = model -> new Car(model);
        Function<Integer,Car> f2 = Car::new;//we call constr by keyword new

//Two argument Constr (2 param ret obj type)
        BiFunction<String,Integer,Car> a1 = Car::new;// = class name :: ret obj by calling const -new
        Car honda = a1.apply("Honda",2015);//a1 give car obj
        System.out.println(honda.getMake() + " " + honda.getModel());//Honda 2015



    }
}

