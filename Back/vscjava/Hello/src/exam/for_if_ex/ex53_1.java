package exam.for_if_ex;

import java.util.Scanner;

public class ex53_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("a의 값을 입력하세요");
        int a = scan.nextInt();
        System.out.println("b의 값을 입력하세요");
        int b = scan.nextInt();

        double[] num = new double[4];
        double max = 0.0;

        num[0] = a + b;
        num[1] = a - b;
        num[2] = a * b;
        num[3] = a / b;
        for (int i = 0; i < num.length; i++) {
            if (max < num[i]) {
                max = num[i];
            }
        }
        System.out.println("최대값은: "+ (int)max);

        scan.close();

    }
}
