package exam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex06 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig");
        List<String> longN = strings.stream()
                .filter(n -> n.length() > 3)
                .collect(Collectors.toList());
        System.out.println(longN);
    }
}
