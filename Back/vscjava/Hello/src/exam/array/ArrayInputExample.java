package exam.array;

import java.util.Scanner;

public class ArrayInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("배열 크기를 입력하세요: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for(int i=0; i<size; i++){
            System.out.print("숫자를 입력하세요: ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("입력한 숫자 배열: ");
        for(int number:numbers){
            System.out.print(number + " ");
        }
        scanner.close();
    }
}
