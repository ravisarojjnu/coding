interface FunInterface {
    void run();
}

class Var {
    int x = 1;
}

class VCaptureDemo {

    int x = 0;

    void run() {
        int y = 0;
        Var z = new Var();
        FunInterface fi = () -> {
            System.out.println(x);
            System.out.println(y);
            System.out.println(z.x);
            x = 1;
            // y+=1; error
            z.x += 1;

        };
        fi.run();
        System.out.println(x);
        System.out.println(z.x);

    }

}

public class LambdaVariableCaptureDemo {

    public static void main(String[] args) {

        VCaptureDemo demo = new VCaptureDemo();
        demo.run();

    }

}
