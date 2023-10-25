package exam.for_if_ex;

import java.util.Scanner;

public class ex43 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] arr = str.toCharArray();
        String[] unit1 = { "", "십", "백", "천" };

        for (int i = 0; i < str.length(); i++) {
            switch (arr[i]) {
                case '1':
                    arr[i] = '일';
                    break;
                case '2':
                    arr[i] = '이';
                    break;
                case '3':
                    arr[i] = '삼';
                    break;
                case '4':
                    arr[i] = '사';
                    break;
                case '5':
                    arr[i] = '오';
                    break;
                case '6':
                    arr[i] = '육';
                    break;
                case '7':
                    arr[i] = '칠';
                    break;
                case '8':
                    arr[i] = '팔';
                    break;
                case '9':
                    arr[i] = '구';
                    break;
            }

            // if (i == arr.length - 2)
            // System.out.print(arr[i] + "십");
            // else if (i == arr.length - 3)
            // System.out.print(arr[i] + "백");
            // else if (i == arr.length - 4)
            // System.out.print(arr[i] + "천");
            // else if (i == arr.length - 5) {
            // System.out.print(arr[i] + "만");
            // if (i == arr.length - 7)
            // System.out.print(arr[i] + "십");
            // else if (i == arr.length - 8)
            // System.out.print(arr[i] + "백");
            // else if (i == arr.length - 9)
            // System.out.print(arr[i] + "천");
            // } else
            // System.out.print(arr[i]);

            System.out.print(arr[i] + unit1[arr.length-1]);
        }
    }
}
