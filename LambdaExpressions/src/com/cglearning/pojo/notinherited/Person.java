package com.cglearning.pojo.notinherited;

public class Person {
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
        System.out.println("Implementation from Person.java class");
        StringBuilder sb = new StringBuilder();
        sb.append("Name : ").append(getName())
                .append(" & ")
                .append("Age : ").append(getAge())
                .append(" & ");
        return sb.toString();
    }
}
