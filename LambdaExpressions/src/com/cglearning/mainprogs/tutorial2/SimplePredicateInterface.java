package com.cglearning.mainprogs.tutorial2;

import com.cglearning.pojo.notinherited.Person;
import com.cglearning.utility.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.cglearning.constants.Constants.LINE_DELIMITER;

public class SimplePredicateInterface {

    public static void main(String[] args) {
        List<Person> people = CommonUtil.getPeople();

        printPersonAgeMoreThan25(people);
        printPersonAgeMoreThan25UsingPredicate(people);
        demoOnReusablePredicate(people);
    }

    /**
     * Passing predicates to method calls
     * @param people
     */
    private static void demoOnReusablePredicate(List<Person> people) {
        System.out.println("demoOnReusablePredicate");
        System.out.println("Using many predicates");

        Predicate<Person> predicateAgeGreaterThan25 = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return (person.getAge() > 25);
            }
        };

        Predicate<Person> predicateAgeLessThan25 = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return (person.getAge() < 25);
            }
        };
        System.out.println("Age greater than 25");
        printDetailsFromPredicateCondition(people, predicateAgeGreaterThan25);
        System.out.println("Age less than 25");
        printDetailsFromPredicateCondition(people, predicateAgeLessThan25);
        System.out.println(LINE_DELIMITER);
    }

    private static void printDetailsFromPredicateCondition(List<Person> people, Predicate<Person> predicate) {
        for(Person person : people) {
            if(predicate.test(person)) {
                System.out.println(person.getName());
            }
        }
    }

    /**
     * Using predicate interface to filter the people whose age is greater than 25
     * @param people - ArrayList of person objects
     */
    private static void printPersonAgeMoreThan25UsingPredicate(List<Person> people) {
        System.out.println("printPersonAgeMoreThan25UsingPredicate");
        System.out.println("Using predicate, filtering the people whose age is greater than 25");

        /**
         * It is a functional interface which represents a predicate (boolean-valued function) of one argument.
         * It is defined in the java.util.function package and contains test() a functional method.
         */
        Predicate<Person> predicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return (person.getAge() > 25);
            }
        };

        // We have just created a predicate interface which returns true for the person objects whose age > 25
        // Now iterate and use predicate to get the list of names
        for(Person person : people) {
            if(predicate.test(person)) {
                System.out.println(person.getName());
            }
        }
        System.out.println(LINE_DELIMITER);
    }

    /**
     * Traditional way of filtering the people whose age is greater than 25
     * @param people - ArrayList of person objects
     */
    private static void printPersonAgeMoreThan25(List<Person> people) {
        System.out.println("printPersonAgeMoreThan25");
        System.out.println("Traditional way of filtering the people whose age is greater than 25");
        for(Person person : people) {
            if(person.getAge() > 25) {
                System.out.println(person.getName());
            }
        }
        System.out.println(LINE_DELIMITER);
    }
}
