package cz.vibri.multithreading;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        currentThread();
//        extendTheThreadClass();
//        useRunnableInterface();
//        threadPriorities();
//        threadState();
//        threadGroups();
        threadDaemonVsUser();
    }

    private static void threadDaemonVsUser() throws InterruptedException {
        Thread thread1 = new Thread(new MyThread1(10),"Thread1");
        Thread thread2 = new Thread(new MyThread1(3),"Thread2");

        thread1.setDaemon(true);
        thread1.start();
        thread2.start();

        thread1.join();
    }

    static class MyThread1 implements Runnable {

        private final int numberOfSecounds;

        public MyThread1(int numberOfSecounds) {
            this.numberOfSecounds = numberOfSecounds;
        }

        @Override
        public void run() {
            for (int i=0; i< numberOfSecounds; i++) {
                try {
                    System.out.println("Sleeping for 1s, thread: " + Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void threadGroups() throws InterruptedException {
        ThreadGroup group = new ThreadGroup("Group1");
        group.setMaxPriority(7);

        ThreadGroup parent = group.getParent();
        System.out.println("Parent name: " + parent.getName() + " priority = " + parent.getMaxPriority());
        Thread thread1 = new Thread(group, new MyInterruptedThread(), "Thread1");
        Thread thread2 = new Thread(group, new MyInterruptedThread(), "Thread2");
        Thread thread3 = new Thread(group, new MyInterruptedThread(), "Thread3");

        thread1.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println("Sleeping for 3 secounds...");
        Thread.sleep(3000);

        group.interrupt();
    }

    private static void threadState() throws InterruptedException {
        Thread thread = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            System.out.println("[1] State: " + currentThread.getState());
        });

        System.out.println("[2] State: " + thread.getState());

        thread.start();

        System.out.println("[3] State: " + thread.getState());

        thread.join();

        System.out.println("[4] State: " + thread.getState());

    }

    private static void threadPriorities() throws InterruptedException {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Thread thread1 = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName() + " priority: " + currentThread.getPriority());
        });
        thread1.setName("Thread_1");
        thread1.setPriority(Thread.MAX_PRIORITY);

        Thread thread2 = new Thread(() -> {
            Thread currentThread = Thread.currentThread();
            System.out.println(currentThread.getName() + " priority: " + currentThread.getPriority());
        });
        thread2.setName("Thread_2");
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }


    private static void currentThread() throws InterruptedException {
        Thread thread = Thread.currentThread();
        System.out.println("Current thread: " + thread.getName());

        Thread.sleep(3000);

        System.out.println("Current thread: " + thread.getName());

    }

    private static void extendTheThreadClass() {
        MyThread myThread = new MyThread();
        myThread.start();
    }

    private static void useRunnableInterface() throws InterruptedException {
        System.out.println("[1] Current thread: " + Thread.currentThread().getName());
        Runnable runnable = () -> System.out.println("[2] Current thread: " + Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        thread.setName("MyRunnable");
        thread.start();
        thread.join();
        System.out.println("[3] Current thread: " + Thread.currentThread().getName());
    }

    static class MyThread extends Thread {
        public void run() {
            setName("MyThread");
            System.out.println("Current thread: " + Thread.currentThread().getName());
        }
    }

    static class MyInterruptedThread implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Thread currentThread = Thread.currentThread();
                    System.out.println("Name: " + currentThread.getName() + " priority = " + currentThread.getPriority());
                }
            }
        }
    }
}
