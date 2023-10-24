package exam.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ex10 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "여성"),
                new Person("Bob", 30, "남성"),
                new Person("Charlie", 22, "여성"));

        // String p = people.stream()
        // .filter(Person::getSex)

        // long femaleCount = people.stream()
        // .filter(person -> "여성".equals(person.getSex()))
        // .count();
        // System.out.println(femaleCount);

        // 나이가 25 이상인 사람을 필터링하여 새로운 리스트에 저장 후 출력
        List<Person> up = people.stream()
                .filter(p -> p.getAge() >= 25)
                .collect(Collectors.toList());
        for (Person person : up) {
            System.out.println("name: " + person.getName() + ", age: " + person.getAge());
        }
        up.forEach(person -> {
            System.out.println("name: " + person.getName() + ", age: " + person.getAge());
        });

        // 0보다 큰 수 추출
        List<Integer> numbers = Arrays.asList(1, -2, 3, -4, 5, -6);
        List<Integer> n = numbers.stream()
                .filter(num -> num > 0)
                .collect(Collectors.toList());
        System.out.println(n);
    }
}
