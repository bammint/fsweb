package exam.for_if_ex;

import java.util.Scanner;

public class ex62 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        O: while (true) {
            System.out.println("값을 입력하여 주세요. ex)1 2 3");
            String str = scan.nextLine().replaceAll("[^0-9]", " ");
            String[] strArray = str.split(" ");
            for (int i= 0; i<strArray.length;i++) {
                if(strArray[i].isEmpty() || strArray.length !=3) {
                    System.out.println("값이 비었거나 숫자가 아닙니다.");
                    continue O;
                }else if (Integer.parseInt(strArray[i]) >0
                        && Integer.parseInt(strArray[0]) <=3
                        && Integer.parseInt(strArray[1])<=20
                        && Integer.parseInt(strArray[2])<=999
                ){
                    strArray[0] =String.format("%1d", Integer.parseInt(strArray[0]));
                    strArray[1] =String.format("%02d", Integer.parseInt(strArray[1]));
                    strArray[2] =String.format("%03d", Integer.parseInt(strArray[2]));
                    System.out.printf("%s", strArray[i]);
                }else{
                    System.out.println("값의 범위를 확인해주세요.\n 값을 다시 입력해주세요.");
                    continue O;
                }
            }
            break;
        }
    }
}