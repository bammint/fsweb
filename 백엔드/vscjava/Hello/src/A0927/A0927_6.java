package A0927;

import java.util.Scanner;

public class A0927_6 {
    public static void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);

        // 사용자에게 메세지를 출력해서 점수 입력 받기
        System.out.print("점수를 입력하세요: ");
        int score = scanner.nextInt();

        // 입력 받은 점수에 따라 학점 계산
        char grade;

        if(score>=90){
            grade = 'A';
        } else if(score>=80){
            grade = 'B';
        }else if(score>=70){
            grade = 'C';
        }else if(score>=60){
            grade = 'D';
        }else{
            grade = 'F';
        }

        // 학점 출력
        System.out.println("학점: " + grade);

        // 스캐너 닫기(권장사항)
        scanner.close();
    }   
}
