package exam;

import java.util.Scanner;

public class ex62_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int grade = scan.nextInt();
        int cl = scan.nextInt();
        int num = scan.nextInt();

        if(grade!=0&&grade<=3){
            System.out.print(grade);
        }else{
            System.out.println("다시 입력해주세요");
        }

        if(cl!=0&&cl<=20){
            if(cl<10){
                System.out.print("0"+cl);
            }else{
                System.out.print(cl);
            }
        }else{
            System.out.println("다시 입력해주세요");
        }

        if(num!=0&&num<=999){
            if(num<10){
                System.out.print("00"+num);
            }else if(num>=10&&num<100){
                System.out.print("0"+num);
            }else{
                System.out.print(num);
            }
        }else{
            System.out.println("다시 입력해주세요");
        }
    }
}
