class DummyThread extends Thread {

    DummyThread(ThreadGroup tg, String name) {
        super(tg, name);
    }

    public void run() {

        System.out.println("Inside thread!- " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

public class ThreadGroupDemo {

    public static void main(String[] args) {

        ThreadGroup threadGroup = new ThreadGroup("Dummy Group");

        Thread t1 = new DummyThread(threadGroup, "t1");
        Thread t2 = new DummyThread(threadGroup, "t2");
        Thread t3 = new DummyThread(threadGroup, "t3");
        t1.start();
        t2.start();
        t3.start();

        System.out.println(threadGroup.activeCount());

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
