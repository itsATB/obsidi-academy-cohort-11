package com.bptn.course.__Knowledge_Check_Ins.Day12;

import java.util.Scanner;

public class Counter {
    public static void main(String[] args) throws InterruptedException {
        MyCounter counter = new MyCounter();

        Scanner scan = new Scanner(System.in);
        System.out.print("Two counters will run. How many iterations should they count? ");

        int iter = scan.nextInt();

        Thread thread1 = new Thread(new CounterIncRunnable(counter, iter));
        thread1.setName("add thread");
        thread1.start();

        Thread thread2 = new Thread(new CounterIncRunnable(counter, iter));
        thread2.setName("add thread2");
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter.value());
    }
}

class CounterIncRunnable implements Runnable {
    private MyCounter counter;
    private int amount;

    public CounterIncRunnable(MyCounter counter, int amount) {
        this.counter = counter;
        this.amount = amount;
    }

    public void run() {
        for (int i = 0; i < amount; i++) {
            counter.increment();
        }
    }
}

class MyCounter {
    private volatile int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }
}
