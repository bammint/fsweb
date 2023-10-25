package exam.for_if_ex;

import java.util.Scanner;

public class ex43_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("숫자를 입력해주세요.");
            // 공백제거하여 str변수에 대입
            String str = scanner.nextLine().replaceAll(" ", "").replaceAll("[^0-9]", "");
            if (Integer.parseInt(str) > 99999 || Integer.parseInt(str) < -99999) {
                System.out.println("n은 -99999보다 크고 99999보다 작습니다.");
                continue;
            }
            char[] arr = str.toCharArray();
            String[] units = { "", "십", "백", "천", "만" };
            for (int i = 0; i < str.length(); i++) {
                switch (arr[i]) {
                    case '0':
                        arr[i] = '영';
                        break;
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
                }
                if (arr[i] == '영')
                    System.out.print(units[0]);
                else {
                    if (i == arr.length - 2 || i == arr.length - 6)
                        System.out.print(arr[i] + units[1]);
                    else if (i == arr.length - 3 || i == arr.length - 7)
                        System.out.print(arr[i] + units[2]);
                    else if (i == arr.length - 4 || i == arr.length - 8)
                        System.out.print(arr[i] + units[3]);
                    else if (i == arr.length - 5) {
                        System.out.print(arr[i] + units[4]);
                    } else
                        System.out.print(arr[i]);
                }
            }
            System.out.println();
            System.out.println("숫자 출력을 마칩니다.");
            break;
        }
    }
}