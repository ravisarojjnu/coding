
//zero argument

interface Print{
    void run();
}

//single argument
interface Square{
    int calculate(int x);
}

//multiple argument
interface Summation{
    int calculate(int x,int y);
}



public class LambdaIntroDemo{

public static void main(String[] args){

Print print=()->{System.out.println("Hello");};

//defining lambda function for computing square
Square square= x-> x*x;
System.out.println(square.calculate(11));


//defining lambda function for computing sum
Summation summation= (x,y)->x+y;
System.out.println(summation.calculate(11,4));

print.run();


}


}
