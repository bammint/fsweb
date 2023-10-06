package exam;

import java.util.Scanner;

public class ex33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("월별 계절: ");
        int ch = scanner.nextInt();
        // switch(ch){
        //     case 12:
        //     case 1:
        //     case 2:
        //     System.out.println("winter");
        //     break;
        //     case 3:
        //     case 4:
        //     case 5:
        //     System.out.println("spring");
        //     break;
        //     case 6:
        //     case 7:
        //     case 8:
        //     System.out.println("summer");
        //     break;
        //     case 9:
        //     case 10:
        //     case 11:
        //     System.out.println("fall");
        //     break;
        // }

        // if문으로 바꾸기

        if(12 == ch || 1==ch || 2 == ch){
            System.out.println("winter");
        }
        if(3<=ch && 5 >= ch){
            System.out.println("spring");
        }
        if(6<=ch && 8 >= ch){
            System.out.println("summer");
        }
        if(9<=ch && 11 >= ch){
            System.out.println("fall");
        }
        if(ch>=13) {
            System.out.println("다시 입력해주세요");
        }
        scanner.close();
    }
}
