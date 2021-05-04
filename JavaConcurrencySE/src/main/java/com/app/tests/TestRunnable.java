package com.app.tests;

import java.io.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TestRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            // try with resources statement. This way we don't have to explicitly close the resources.
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\singhshu\\Personal-dev\\Java\\JavaConcurrencySE\\Sample.txt")))) {
                String line = null;
                while((line = bufferedReader.readLine()) != null) {
                    System.out.println(Thread.currentThread().getName() + "reading the line: " + line);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        /*

            Option 1: Thread Class
            Thread thread1 = new Thread(runnable);
            thread1.start();

            Option 2: Executor Framework
         */

        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(runnable);

    }
}
