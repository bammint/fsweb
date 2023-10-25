package exam.array;

import java.util.Arrays;

public class ArraySearchExample {
    public static void main(String[] args) {
        int[] numbers = {4,7,2,9,1,5};
        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers,7); // 배열에서 7 검색
        System.out.println("7 found at index: " + index);
    }
}
