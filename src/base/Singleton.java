/**
 * created by Zheng Jiateng on 2019/7/12.
 */
package base;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单例模式的5种实现方式
 *
 * 懒汉、饿汉、双重检验锁、枚举、内部类
 * 此为双重检验锁
 */
public class Singleton {
    private volatile static Singleton singleton;
    private Singleton(){}

    public Singleton(int x) {
        System.out.println(x);
    }
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    private static class Job implements Runnable {
        private int seq;
        private Semaphore semaphore;

        public Job(int seq, Semaphore semaphore) {
            this.seq = seq;
            this.semaphore = semaphore;
        }
        @Override
        public void run(){

        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 5; i++) {
            Runnable job = new Job(i, semaphore);
            new Thread(job).start();
        }
    }
}
