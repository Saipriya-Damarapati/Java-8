package com.cglearning.mainprogs.tutorial2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static com.cglearning.constants.Constants.LINE_DELIMITER;

public class SimpleConsumerWithAndThen {

    public static void main(String[] args) {
        originalExample();
        understandingTheSame();
    }

    private static void understandingTheSame() {
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> upperCaseConsumer = new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) {
                for(int i=0; i< strings.size(); i++){
                    strings.set(i, strings.get(i).toUpperCase());
                }
                System.out.println(LINE_DELIMITER);
            }
        };
        Consumer<List<String>> printConsumer = new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) {
                for(int i=0; i< strings.size(); i++){
                    System.out.println(strings.get(i));
                }
                System.out.println(LINE_DELIMITER);
            }
        } ;

        //upperCaseConsumer.andThen(printConsumer).accept(cities);
        printConsumer.andThen(upperCaseConsumer).andThen(printConsumer).accept(cities);
    }

    private static void originalExample() {
        List<String> cities = Arrays.asList("Sydney", "Dhaka", "New York", "London");

        Consumer<List<String>> upperCaseConsumer = list -> {
            for(int i=0; i< list.size(); i++){
                list.set(i, list.get(i).toUpperCase());
            }
        };
        Consumer<List<String>> printConsumer = list -> list.forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(cities);
    }
}
