package exam.for_if_ex;

import java.util.Scanner;

public class ex62_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int grade = scan.nextInt();
        int cl = scan.nextInt();
        int num = scan.nextInt();

        if(grade<=0 || cl<=0|| num<=0){
            System.out.println("음수는 안됩니다\n다시 실행해주세요");
            return;
        }

        // String s =  String.valueOf(grade).replaceAll("[^0-9]", "!");
        // if(s.equals("!")){
        //     System.out.println("문자가 입력되었습니다.");
        // }


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
