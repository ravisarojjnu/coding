interface CheckEvenNumber {
    boolean run(int n);
}

interface FindFactorial {
    int run(int n);
}

class LamdaBlockCode {

    static void runEvenDemo() {
        CheckEvenNumber isEven = n -> n % 2 == 0;

        boolean out = isEven.run(10);
        System.out.println(out);
    }

    static void runFactorialDemo() {
        FindFactorial calFact = n -> {
            if (n < 1)
                return 1;
            int f = 1;
            for (int i = 2; i <= n; i++)
                f = f * i;
            return f;
        };

        int out = calFact.run(10);
        System.out.println(out);
    }
}

public class LambdaBlockCodeDemo {

    public static void main(String[] args){
        LamdaBlockCode.runEvenDemo();
        LamdaBlockCode.runFactorialDemo();
    }

}
