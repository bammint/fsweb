package exam.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ex08 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 22));

        // int young = people.stream()
        // .map(Person::getAge)
        // .min(Integer::compareTo)
        // .orElse(0);
        // System.out.println(young);

        // String youngestName = youngestPerson.map(Person::getName).orElse("No youngest person found");
        // System.out.println("Youngest person: " + youngestName);

        Optional<Person> young = people.stream()
                .min(Comparator.comparing(Person::getAge));

        young.ifPresent(person -> System.out.println("가장 어린 친구: " + person.getName()));
        // ------------------------------------------------------------------
        // int max1 = transactions.stream()
        // .map(Transaction::getValue)
        // .max(Integer::compareTo)
        // .orElse(0);
        // System.out.println("Max Transaction Value: " + max1);
    }
}
