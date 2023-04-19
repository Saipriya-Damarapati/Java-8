package com.cglearning.interfaces;

public interface PersonInterface {

    String helloStr = "Hello"; // variables in the interface are always public, static, final
    /*
        Implementation of the below abstract methods is mandatory in all child classes
        Abstract classes are written to achieve polymorphism
     */
    void setName(String name);
    String getName();

    void setAge(int age);
    int getAge();

    /*
        Default methods of interface cannot be over-written in the child classes
     */
    default String printDetails() {
        System.out.println("This is default method in interface which is a new feature of Java 8");
        StringBuilder sb = new StringBuilder();
        sb.append("Name : ").append(getName())
                .append(" & ")
                .append("Age : ").append(getAge());
        return sb.toString();
    }

    default String printDetails(String str) {
        System.out.println("Interface allows more than one defaut method with same signature, " +
                "but with different arguments or return type");
        StringBuilder sb = new StringBuilder();
        sb.append("Name : ").append(getName())
                .append(" & ")
                .append("Age : ").append(getAge())
                .append(" & ")
                .append("String input : ").append(str);
        return sb.toString();
    }

    default void tryChangingValue() {
        // the below line is not allowed because it is final
        //helloStr = "Changing";
    }
}
