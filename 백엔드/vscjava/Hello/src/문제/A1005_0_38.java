package 문제;

import java.util.Scanner;

public interface A1005_0_38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("삼각형의 밑변과 높이의 길이를 입력하세요");
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        double area = (double)width*height/2;
        System.out.println("삼각형의 넓이: " + area);
        scanner.close();
    }
}
