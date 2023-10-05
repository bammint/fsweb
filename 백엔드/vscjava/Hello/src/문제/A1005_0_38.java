package 문제;

import java.util.Scanner;

public interface A1005_0_38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        double area = (double)width*height/2;
        System.out.println(area);
        scanner.close();
    }
}
