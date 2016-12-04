package edu.keith.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by keith on 2016/3/23 0023.
 */
public class SafeThread {
    private int count = 0;
    private int version = 1;
    private static SafeThread self = new SafeThread();
    private CountDownLatch latch;

    private SafeThread() {

    }
    public static SafeThread getInstance(){
        return self;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getCount() {

        return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }

    public synchronized void addCount(int val) {
        this.count += val;
    }

    public static void main(String[] args) throws InterruptedException {
        SafeThread self = SafeThread.getInstance();
        int count = 10;
        long time = System.currentTimeMillis();
        self.latch = new CountDownLatch(count);
        for(int i = 0; i<count; i++) {
            InnerThread thread = self.new InnerThread();
            thread.start();
        }
//        InnerThread thread1 = self.new InnerThread();
//        InnerThread thread2 = self.new InnerThread();
//        thread1.start();
//        thread2.start();
        self.latch.await();
        System.out.println("final count when thread finish:"+self.getCount()+" cost:"+(System.currentTimeMillis()-time));
    }

    class InnerThread extends Thread {
        SafeThread safeThread = SafeThread.getInstance();
        public void run() {
            for(int i = 0; i<1000000; i++) {
//                safeThread.addCount(1);
                synchronized(safeThread){
                    int count = safeThread.getCount();
                    safeThread.setCount(count+1);
                }
            }
            latch.countDown();
//            System.out.println("final count when thread finish:"+safeThread.getCount());
        }
    }

}
