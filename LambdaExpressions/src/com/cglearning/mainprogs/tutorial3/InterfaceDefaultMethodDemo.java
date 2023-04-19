package com.cglearning.mainprogs.tutorial3;

import com.cglearning.pojo.inherited.Person;

import static com.cglearning.constants.Constants.LINE_DELIMITER;

public class InterfaceDefaultMethodDemo {
    public static void main(String[] args) {
        Person person = new Person("Dheera Ram", 2);
        System.out.println(person);
        System.out.println(LINE_DELIMITER);
        System.out.println(person.printDetails());
        System.out.println(LINE_DELIMITER);
        System.out.println(person.printDetails("Thank You !"));
        System.out.println(LINE_DELIMITER);
    }
}
