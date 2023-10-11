package a1011.aven;

public class MyMathTest1 {
    public static void main(String[] args) {
        MyMath1 myMath = new MyMath1();
        System.out.println(myMath.max(1.23, 3.45));
        System.out.println(myMath.min(5.43, 3.21));
    }
}

class MyMath1 {
    double max(double a, double b) {
        return (a > b) ? a : b;
    }
    double min(double a, double b) {
        return (a < b) ? a : b;
    }
}