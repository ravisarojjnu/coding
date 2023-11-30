class DummyThread extends Thread {

    public void run() {

        System.out.println("inside thread!");

    }

}

public class ThreadDemo {

    public static void main(String[] args) {

        Thread t1 = new DummyThread();
        t1.start();
        try {
            t1.join();

        } catch (InterruptedException e) {
            e.printStackTrace();

        }

    }

}
