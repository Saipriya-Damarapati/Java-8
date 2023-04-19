package com.cglearning.mainprogs.tutorial2;

import com.cglearning.pojo.notinherited.Person;
import com.cglearning.utility.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SimpleConsumerInterface {

    public static void main(String[] args) {
        List<Person> people = CommonUtil.getPeople();

        printPeopleDetailsUsingCollectionsForEach(people);
    }

    /**
     * New feature in Java 8
     * forEach method on collection objects
     * @param people
     */
    private static void printPeopleDetailsUsingCollectionsForEach(List<Person> people) {
        System.out.println("printPeopleDetailsUsingCollectionsForEach");
        /*Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person);
            }
        };*/
        // The below lambda implements the accept function
        Consumer<Person> consumer = person -> System.out.println(person);
        people.forEach(consumer);
    }
}
