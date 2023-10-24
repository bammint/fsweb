package exam.stream;

import java.util.Arrays;
import java.util.List;

public class ex09 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig");

        double avg = strings.stream()
                .mapToInt(String::length)   // 문자열 길이를 숫자로 매핑
                .average()  // 평균
                .orElse(0.0);   // 목록이 비어 있으면 0.0

        System.out.println("Average length: "+avg);

        // orElse: 기본값을 지정하여 안전하게 값을 가져옴
        // getAsDouble: 값이 반드시 존재해야 하는 경우에 사용되어야함

        // double avg = strings.stream()
        //         .mapToInt(String::length)
        //         .average()
        //         .getAsDouble();

        // System.out.println("Average length: "+avg);
    }
}
