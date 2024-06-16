package com.example.demo;

import net.jcip.annotations.ThreadSafe;

import java.util.Timer;
import java.util.TimerTask;

@ThreadSafe
public class ThreadExample extends Thread {

    public static void main(String[] args) throws InterruptedException {
        ThreadExample thread = new ThreadExample();
        thread.start();
        System.out.println("This code is outside of the thread");
        thread.sleep(1000);
        writter("Sub");
    }

    @Override
    public void run() {
        System.out.println("This code is running in a thread");
        writter("er");
    }

    public static void writter(String text){
        System.out.println("This code is running in a thread"+text);
    }


}
