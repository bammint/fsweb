package exam;

import java.util.Arrays;

public class ArrayEqualsExample {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,2,3,4,5};
        boolean areEqual = Arrays.equals(array1,array2);    // 배열 비교
        System.out.println("Arrays are equal: " + areEqual);
    }
}
