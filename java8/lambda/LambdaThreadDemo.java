
public class LambdaThreadDemo {
    public static void main(String[] args)

    {
        Runnable t1 = () -> {
            System.out.println("A started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            System.out.println("A ended");
        };

        Runnable t2 = () -> {
            System.out.println("B started");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
            System.out.println("B ended");
        };

        Thread thread = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread.start();
        thread2.start();
    }
}
