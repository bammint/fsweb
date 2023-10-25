package exam.for_if_ex;

import java.util.Scanner;

public interface ex38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("삼각형의 밑변 길이를 입력하세요");
        int width = scanner.nextInt();
        System.out.println("삼각형의 높이를 입력하세요");
        int height = scanner.nextInt();

        // double area = (double)width*height/2;
        System.out.println("삼각형의 넓이: " + (double)width*height/2);

        // System.out.printf("삼각형의 넓이는?"+"%.1f",(float)(a+b)/2);

        scanner.close();
    }
}
