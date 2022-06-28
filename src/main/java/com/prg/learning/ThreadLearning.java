package com.prg.learning;

class Test1 extends Thread {

    @Override
    public void run() {
        new Test2().notify();
    }
}

class Test2 extends Thread {

    int data = 10;

    @Override
    public void run() {
        data = 10;
        try {
            new Test2().wait();
            System.out.println(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadLearning {

}
