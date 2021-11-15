package com.seolin.question.question1000.question501t600.question575;

/**
 * @author liangzi on 2021/11/1
 */
public class Solution {

    public static volatile boolean isARun = false;
    public static volatile boolean isBRun = false;

    public static void main(String[] args) throws InterruptedException {
        lock();
    }

    public static void lock() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
                isARun = true;
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (!isARun) {
                    continue;
                }
                System.out.println("B");
                isBRun = true;
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                while (!isARun || !isBRun) {
                    continue;
                }
                System.out.println("C");
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }

    public static void join() throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("A");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
            }
        });
        threadA.start();
        threadA.join();

        threadB.start();
        threadB.join();

        threadC.start();
        threadC.join();
    }
}
