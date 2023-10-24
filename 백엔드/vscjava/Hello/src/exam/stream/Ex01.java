package exam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 주어진 정수 리스트에서 짝수 숫자만 필터링하는 Java 스트림 코드를 작성하세요
public class Ex01 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }
}
