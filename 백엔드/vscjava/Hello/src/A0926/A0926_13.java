package A0926;

public class A0926_13 {
    public static void main(String[] args) {
        // 5/0 -> 좌측이 정수이고 우측이 0일 경우 예외 발생
        int x = 5;
        double y = 0.0;
        double z = x / y; // 정수를 실수로 나누면 Infinity
        // double z = x % y;

        // 잘못된 코드
        System.out.println(z + 2); // Infinity

        // 알맞은 코드
        if(Double.isInfinite(z) || Double.isNaN(z)){
            System.out.println("값 산출 불가");
        } else {
            System.out.println(z+ 2);
        }
    }
}
