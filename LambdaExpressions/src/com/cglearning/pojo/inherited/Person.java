package com.cglearning.pojo.inherited;

import com.cglearning.interfaces.PersonInterface;

public class Person implements PersonInterface {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String printDetails() {
        System.out.println("I am in child class, over-writing the default method in the interface");
        StringBuilder sb = new StringBuilder();
        sb.append("Name : ").append(getName())
                .append(" & ")
                .append("Age : ").append(getAge());
        return sb.toString();
    }
}
