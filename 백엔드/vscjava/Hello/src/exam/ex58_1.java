package exam;

import java.util.Scanner;

public class ex58_1 {
    public static void main(String[] args) {
        System.out.println("삼각형이 만들어질 수 있는 길이를 입력하세요.");
        Scanner scanner = new Scanner(System.in);

        int[] sides = new int[3];
        int maxLength = 0;

        for (int i = 0; i < 3; i++) {
            System.out.print((char) ('a' + i) + "의 값을 입력하세요> ");
            sides[i] = scanner.nextInt();
            maxLength = Math.max(maxLength, sides[i]);
        }

        if (isValidTriangle(sides, maxLength)) {
            System.out.println("삼각형을 만들 수 있습니다.");
        } else {
            System.out.println("삼각형을 만들 수 없습니다.");
        }
    }

    public static boolean isValidTriangle(int[] sides, int maxLength) {
        int sum = 0;

        for (int side : sides) {
            sum += side;
        }

        return (sum - maxLength) > maxLength;
    }
}
