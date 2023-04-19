package com.cglearning.thread;

public class ThreadOne implements Runnable {

    @Override
    public void run() {
        System.out.println("We are in Thread One");
    }

}
