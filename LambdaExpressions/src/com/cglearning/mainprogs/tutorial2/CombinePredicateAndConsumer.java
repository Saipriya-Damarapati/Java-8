package com.cglearning.mainprogs.tutorial2;

import com.cglearning.pojo.notinherited.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static com.cglearning.constants.Constants.LINE_DELIMITER;

public class CombinePredicateAndConsumer {

    public static void main(String[] args) {
        List<Person> people = new CopyOnWriteArrayList<>();
        people.add(new Person("Thejoshree", 5));
        people.add(new Person("Ashika", 29));
        people.add(new Person("Bhavan", 28));
        people.add(new Person("Kundana", 21));
        people.add(new Person("Vivek", 11));

        demoOnReusablePredicate(people);

    }

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
        printDetailsFromConcurrentModificationException(people, predicateAgeLessThan25);
        System.out.println(LINE_DELIMITER);
    }

    private static void printDetailsFromPredicateCondition(List<Person> people, Predicate<Person> predicate) {
        List<Person> criteriaList = new ArrayList<>();
        for(Person person : people) {
            if(predicate.test(person)) {
                criteriaList.add(person);
            }
        }
        Consumer<Person> consumer = person -> System.out.println(person);
        criteriaList.forEach(consumer);
    }

    private static void printDetailsFromConcurrentModificationException(List<Person> people, Predicate<Person> predicate) {
        for(Person person : people) {
            // if age < 25 does not match, remove the person from people list
            if(!predicate.test(person)) {
                // this will throw ConcurrentModificationException,
                // we are iterating the arrayList and also modifying the arraylist at the same time
                people.remove(person);
            }
        }
        Consumer<Person> consumer = person -> System.out.println(person);
        people.forEach(consumer);
    }
}
