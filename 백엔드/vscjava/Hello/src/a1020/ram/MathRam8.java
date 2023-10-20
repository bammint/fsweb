package a1020.ram;

@FunctionalInterface
interface MathOperation{
    int operation(int a, int b);
}

public class MathRam8 {
    public static void main(String[] args) {
        MathOperation add = (a,b)->a+b;
        MathOperation subtract = (a,b)->a-b;

        int result1 = add.operation(5, 3);  // 결과: 8
        int result2 = subtract.operation(5, 3);  // 결과: 2

        System.out.println("Addition Result: " + result1);
        System.out.println("Subtraction Result: " + result2);
    }
}
