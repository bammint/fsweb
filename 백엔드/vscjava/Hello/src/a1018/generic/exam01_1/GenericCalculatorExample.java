package generic.exam01_1;

class Calculator<T extends Number> {
    public double add(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }
}

public class GenericCalculatorExample {
    public static void main(String[] args) {
        Calculator<Integer> intCalculator = new Calculator<>();
        double sumInt = intCalculator.add(5, 3);
        System.out.println("정수 합: " + sumInt);

        Calculator<Double> doubleCalculator = new Calculator<>();
        double sumDouble = doubleCalculator.add(2.5, 3.7);
        System.out.println("실수 합: " + sumDouble);
    }
}