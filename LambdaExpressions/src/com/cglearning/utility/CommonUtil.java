package com.cglearning.utility;

import com.cglearning.pojo.notinherited.Person;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {

    public static List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Thejoshree", 5));
        people.add(new Person("Ashika", 29));
        people.add(new Person("Bhavan", 28));
        people.add(new Person("Kundana", 21));
        people.add(new Person("Vivek", 11));
        return people;
    }
}
