package exam.for_if_ex;

import java.util.Scanner;

public class ex44 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("요일을 입력해주세요");
        int num = scan.nextInt();

        String[] str = {"월요일","화요일","수요일","목요일","금요일","토요일","일요일"};

        int i = num-1;
            if(num < 8){
                if(num <= 6){
                    System.out.println(str[i] + "\noh my god");
                } else{
                    System.out.println(str[i] + "\nenjoy");
                }
            } else {
                System.out.println("다시 입력해주세요");
            }
        scan.close();
    }
}
