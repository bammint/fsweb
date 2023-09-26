package A0926;

public class A0926_12 {
    public static void main(String[] args) {
        int apple = 1;
        int totalpieces = apple * 10;
        int number = 7;

        double result = totalpieces - number;
        System.out.println("10조각에서 남은 조각: " + result);
        System.out.println("사과 1개에서 남은 양: " + result/10.0);
    }
}
