package a1016.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Arrays3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열의 크기를 입력하세요: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];  // 입력한 크기만을 배열 생성
        System.out.println("배열의 숫자를 입력하세요");

        for(int i=0; i< size; i++){
            System.out.print("배열 요소 " + (i+1) + ": ");
            numbers[i] = scanner.nextInt(); // 사용자로부터 숫자 입력
        }
        System.out.println("입력한 배열 요소: " + Arrays.toString(numbers));
    }
}
