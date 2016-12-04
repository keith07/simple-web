package edu.keith.thread;

/**
 * Created by keith on 2016/3/27 0027.
 */
public class SpeedWithInterrupt {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "started");
                try {
                    synchronized (this){
                        wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println("inner interrupted");
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"stopped");
            }
        };
        thread.start();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "started");
                try{
                    thread.join();
                }catch(InterruptedException e){
                    System.out.println("outer interrupted");
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "stopped");
            }
        };
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (thread){
            thread.notify();

        }
    }
}
