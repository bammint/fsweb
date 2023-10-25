package exam.array;

import java.util.Arrays;

public class ArraySortExample {
    public static void main(String[] args) {
        int[] numbers = {5,2,9,1,5,6};
        Arrays.sort(numbers);   // 배열 정렬
        for(int number:numbers){
            System.out.print(number + " ");
        }
    }
}
