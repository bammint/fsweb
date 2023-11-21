package exam.for_if_ex;

import java.util.Scanner;

public class ex35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요.");
        int num = scanner.nextInt();
        int sum = 0;

        for(int i=1; i<=num;i++){
            if(i%2 == 0){
                sum += i;
            }
        }
        System.out.println("짝수의 합: " + sum);
        scanner.close();
    }
}
