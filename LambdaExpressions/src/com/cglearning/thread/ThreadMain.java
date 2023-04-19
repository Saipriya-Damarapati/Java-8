package com.cglearning.thread;

import static com.cglearning.constants.Constants.LINE_DELIMITER;

public class ThreadMain {

    public static void main(String[] args) {
        ThreadInSeparateClass();
        ThreadInAnonymousInnerClass();
        ThreadWithLambdaExpression();
        ThreadWithMethodReference();
    }

    /**
     * 
     */
    private static void ThreadWithMethodReference() {
        System.out.println(LINE_DELIMITER);
        System.out.println("ThreadWithMethodReference()");
        Thread threadNewOne = new Thread(ThreadMain::run);
        threadNewOne.start();
    }

    private static void run() {
        System.out.println("We are in thread created from method reference");
    }

    /**
     * The method thread takes Runnable implementation as constructor
     * Runnable interface is a functional interface, which contains only one abstract method called run
     * Hence lambda expression can be implemented
     */
    private static void ThreadWithLambdaExpression() {
        System.out.println(LINE_DELIMITER);
        System.out.println("ThreadWithLambdaExpression()");
        Thread threadNewOne = new Thread(() -> System.out.println("We are in a Thread Lambda"));
        threadNewOne.start();
    }

    /**
     * Create an anonymous inner class for Runnable interface
     */
    private static void ThreadInAnonymousInnerClass() {
        System.out.println(LINE_DELIMITER);
        System.out.println("ThreadInAnonymousInnerClass()");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in a new Thread");
            }
        };
        Thread threadNew = new Thread(runnable);
        threadNew.start();
    }

    /**
     * ThreadOne is a separate class
     * which implements Runnable interafce
     */
    private static void ThreadInSeparateClass() {
        System.out.println(LINE_DELIMITER);
        System.out.println("ThreadInSeparateClass()");
        ThreadOne t1 = new ThreadOne();
        Thread thread = new Thread(t1);
        thread.start();
    }
}
