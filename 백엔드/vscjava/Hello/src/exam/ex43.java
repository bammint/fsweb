package exam;

import java.util.Scanner;

public class ex43 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String out = Integer.toString(num);

        String[] str = { "", "십", "백", "천", "만", "십", "백", "천", "억" };

        System.out.println();
    }

    public static String read(int num) {
        switch (num) {
            case 1:
                return "일";
            case 2:
                return "이";
            case 3:
                return "삼";
            case 4:
                return "사";
            case 5:
                return "오";
            case 6:
                return "육";
            case 7:
                return "칠";
            case 8:
                return "팔";
            case 9:
                return "구";
        }
        return null;
    }
}
