package exam.for_if_ex;

import java.util.Scanner;

public class ex50 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("신장을 입력해주세요");
        double m = scan.nextInt();
        System.out.println("몸무게를 입력해주세요");
        double kg = scan.nextInt();
        double BMI = kg/(m/100*m/100);
        System.out.println("BMI 수치");
        System.out.println(BMI);
        System.out.println("BMI 수치를 입력해주세요");
        BMI = scan.nextDouble();
        System.out.println();

        if(BMI<18.5){
            System.out.println("저체중");
        }
        if(BMI>=18.5 && BMI<=23){
            System.out.println("정상체중");
        }
        if(BMI>23){
            System.out.println("비만");
        }

        scan.close();
    }
}
