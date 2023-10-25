package exam.for_if_ex;

import java.util.Scanner;

public class ex43_3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("한글로 변환할 수를 입력하세요:");
        int number = scan.nextInt();

        String[] units = {"", "십", "백", "천", "만"};
        String[] digits = {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};

        String result = "";
        int unitIndex = 0;
        int i = 0;

        while (number > 0) {
            int digit = number % 10;
            if (digit != 0) {
                result = digits[digit] + units[unitIndex] + result;
            } else {
                if (!result.isEmpty() && result.charAt(0) != '영') {
                    result = digits[digit] + result;
                }
                // else if(result.charAt(i) == '영'){
                //     // result = " ";
                //     result = digits[digit];
                // }
            }

            number /= 10;
            unitIndex++;
            i++;
        }

        System.out.println(result);
    }
}
