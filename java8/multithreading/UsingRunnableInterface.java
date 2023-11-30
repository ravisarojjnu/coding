class DummyThread implements Runnable {

    public void run() {

        System.out.print("inside thread!");

    }
}

public class UsingRunnableInterface {

    public static void main(String[] args) {

        Thread t1 = new Thread(new DummyThread());
        t1.start();

        try{
            t1.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
           
        }

    }

}
