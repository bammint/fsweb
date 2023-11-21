package a1020.ram;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ram6 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice","Bob","Charlie");
        List<String> filteredNames = names.stream()
            .filter(name -> name.length() > 4)
            .collect(Collectors.toList());

        System.out.println("원래 이름 리스트: " + names);
        System.out.println("길이가 4보다 큰 이름 리스트: " + filteredNames);
    }
}
