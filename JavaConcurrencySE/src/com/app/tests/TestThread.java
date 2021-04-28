package com.app.tests;

import com.app.runnables.AppThread;

public class TestThread {
    public static void main(String[] args) {
        AppThread thread1 = new AppThread(); // NEW state
        AppThread thread2 = new AppThread();
        AppThread thread3 = new AppThread();

        thread1.start(); // RUNNABLE state
        thread2.start();
        thread3.start();

        // When the JVM calls the run method, its in RUNNING state.
        // When the Thread execution is completed its in DEAD/TERMINATED state.
        // wait() method makes it in WAITING state and sleep() makes it in BLOCKED state.
    }
}
